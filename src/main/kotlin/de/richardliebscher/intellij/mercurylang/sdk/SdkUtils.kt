package de.richardliebscher.intellij.mercurylang.sdk

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.SystemInfo
import java.io.IOException
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

private val LOG: Logger = Logger.getInstance(MercurySdkType::class.java)
private val VERSION_RE: Pattern = Pattern.compile("Mercury Compiler, version ([^,]+), on");

fun getExecutableName(name: String): String {
    return if (SystemInfo.isWindows) {
        "$name.exe"
    } else {
        name
    }
}

fun callMercuryCompilerVersion(mmc: String): String? {
    val proc = ProcessBuilder(mmc, "--version")
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    return try {
        if (proc.waitFor(2, TimeUnit.SECONDS)) {
            if (proc.exitValue() == 0) {
                proc.inputStream.bufferedReader().readText()
            } else {
                LOG.error("Unable to detect mmc version: status: ${proc.exitValue()}")
                null
            }
        } else {
            proc.destroyForcibly()
            val stderr = proc.errorStream.bufferedReader().readText()
            LOG.error("Unable to detect mmc version: stderr: $stderr")
            null
        }
    } catch (e: IOException) {
        LOG.error("Unable to run mmc --version", e)
        null
    } finally {
        proc.destroyForcibly()
    }
}

fun parseMercuryCompilerVersion(mmcVersionOutput: String): String? {
    val matcher = VERSION_RE.matcher(mmcVersionOutput)
    return if (matcher.find()) {
        matcher.group(1)
    } else {
        null
    }
}

fun retrieveMercuryCompilerVersion(mmc: String): String? {
    return callMercuryCompilerVersion(mmc)?.let { parseMercuryCompilerVersion(it) }
}
package de.richardliebscher.intellij.mercurylang.sdk

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.projectRoots.*
import com.intellij.openapi.util.SystemInfo
import com.intellij.openapi.util.SystemInfoRt
import com.intellij.openapi.util.text.StringUtilRt
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.EnvironmentUtil
import de.richardliebscher.intellij.mercurylang.language.MercuryIcons
import org.jdom.Element
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import javax.swing.Icon

val mmc = getExecutableName("mmc");
val pathSeparator = File.pathSeparator


class MercurySdkType : SdkType("Mercury") {
    override fun getPresentableName(): String = "Mercury SDK"

    override fun getIcon(): Icon = MercuryIcons.FILE

    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {}

    override fun suggestHomePath(): String? {
        return if (SystemInfo.isLinux && Files.isDirectory(Path.of("/usr/bin/mmc"))) {
            "/usr"
        } else {
            null
        }
    }

    override fun suggestHomePaths(): MutableCollection<String> {
        return try {
            val pathVarString: String? = EnvironmentUtil.getValue("PATH")
            if (pathVarString.isNullOrEmpty()) {
                return mutableListOf()
            }
            val result = mutableListOf<String>()
            for (pathEntry in pathVarString.split(pathSeparator).toSet()) {
                val path: Path = Path.of(pathEntry)
                if (!StringUtilRt.equal(path.fileName.toString(), "bin", SystemInfoRt.isFileSystemCaseSensitive)) {
                    continue
                }
                val homePath = path.parent ?: continue
                if (Files.isExecutable(homePath.resolve("bin").resolve(mmc))) {
                    result.add(homePath.toString())
                }
            }
            result
        } catch (e: Exception) {
            LOG.warn("Failed to scan PATH for Mercury SDK. " + e.message, e)
            mutableListOf()
        }
    }

    override fun adjustSelectedSdkHome(homePath: String): String {
        val path = Path.of(homePath)
        if (path.parent != null) {
            if (path.fileName.toString() == "bin" && Files.isExecutable(path.resolve(mmc))) {
                return path.parent.toString()
            }
            if (path.fileName.toString() == "mmc" && Files.isExecutable(path)
                && path.parent.fileName.toString() == "bin" && path.parent.parent != null) {
                return path.parent.parent.toString()
            }
        }
        return super.adjustSelectedSdkHome(homePath)
    }

    override fun isValidSdkHome(path: String): Boolean {
        return checkSdkHome(path)
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        return if (!currentSdkName.isNullOrEmpty()) {
            currentSdkName
        } else {
            val versionString = getVersionString(sdkHome)
            if (versionString != null) {
                "mercury-$versionString"
            } else {
                "unknown"
            }
        }
    }

    override fun createAdditionalDataConfigurable(
        sdkModel: SdkModel,
        sdkModificator: SdkModificator
    ): AdditionalDataConfigurable? = null

    override fun getVersionString(sdkHome: String?): String? {
        return getMmcPath(sdkHome)?.let { retrieveMercuryCompilerVersion(it) }
    }

    override fun getHomeChooserDescriptor(): FileChooserDescriptor {
        return object : FileChooserDescriptor(true, false, false, false, false, false) {
            override fun validateSelectedFiles(files: Array<out VirtualFile>) {
                if (files.isNotEmpty()) {
                    val selectedPath = files[0].path
                    val valid = isValidSdkHome(adjustSelectedSdkHome(selectedPath))
                    if (!valid) {
                        throw Exception("Not valid mmc executable: " + files[0].name)
                    }
                }
            }

            override fun isFileVisible(file: VirtualFile, showHiddenFiles: Boolean): Boolean {
                if (!file.isDirectory && file.name != mmc) {
                    return false
                }
                return super.isFileVisible(file, showHiddenFiles)
            }
        }.withTitle("Select Mercury compiler executable")
    }

    private fun checkSdkHome(sdkHome: String): Boolean {
        val homePath = Path.of(sdkHome);
        return Files.isExecutable(homePath.resolve("bin").resolve(mmc))
                && Files.isDirectory(homePath.resolve("lib/mercury"));
    }

    private fun getMmcPath(sdkHome: String?): String? {
        if (sdkHome == null || !checkSdkHome(sdkHome)) return null

        val homePath = Path.of(sdkHome);
        return homePath.resolve("bin").resolve(mmc).toString()
    }

    companion object {
        private val LOG: Logger = Logger.getInstance(MercurySdkType::class.java)
    }
}
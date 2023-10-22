package de.richardliebscher.intellij.mercurylang.language

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object MercuryFileType: LanguageFileType(MercuryLanguage) {
    override fun getName(): String = "Mercury Source File"

    override fun getDescription(): String = "Source file of Mercury language"

    override fun getDefaultExtension(): String = "m"

    override fun getIcon(): Icon = MercuryIcons.FILE

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"
}
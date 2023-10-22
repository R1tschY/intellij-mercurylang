package de.richardliebscher.intellij.mercurylang.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MercuryFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MercuryLanguage) {
    override fun getFileType(): FileType = MercuryFileType
    override fun toString(): String = "Mercury:" + viewProvider.virtualFile.presentableName
}
package de.richardliebscher.intellij.mercurylang.language

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes

private val FILE = IFileElementType(MercuryLanguage)

class MercuryParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = MercuryLexerAdapter()

    override fun createParser(project: Project?): PsiParser = MercuryParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(MercuryTypes.LINE_COMMENT, MercuryTypes.BLOCK_COMMENT)

    override fun getStringLiteralElements(): TokenSet = TokenSet.create(MercuryTypes.STRING)

    override fun createElement(node: ASTNode?): PsiElement = MercuryTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MercuryFile(viewProvider)
}
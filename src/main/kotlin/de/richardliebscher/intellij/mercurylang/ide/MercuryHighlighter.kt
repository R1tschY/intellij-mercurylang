package de.richardliebscher.intellij.mercurylang.ide

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.richardliebscher.intellij.mercurylang.ide.colors.MercuryColors
import de.richardliebscher.intellij.mercurylang.language.*
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes


class MercuryHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = MercuryLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(when (tokenType) {
            MercuryTypes.PERIOD -> MercuryColors.PERIOD
            MercuryTypes.COMMA -> MercuryColors.COMMA

            in KEYWORDS -> MercuryColors.KEYWORDS
            in OPERATORS -> MercuryColors.OPERATORS
            in PARENTHESES -> MercuryColors.PARENTHESES
            in BRACES -> MercuryColors.BRACES
            in BRACKETS -> MercuryColors.BRACKETS
//            in DETERMINISM_CATEGORY -> MercuryColors.DETERMINISM_CATEGORY

            MercuryTypes.FLOAT, MercuryTypes.INTEGER -> MercuryColors.NUMBER
            MercuryTypes.STRING -> MercuryColors.STRING

            MercuryTypes.IDENT -> MercuryColors.IDENT
            MercuryTypes.VARIABLE -> MercuryColors.VARIABLE

            MercuryTypes.LINE_COMMENT -> MercuryColors.LINE_COMMENT
            MercuryTypes.BLOCK_COMMENT -> MercuryColors.BLOCK_COMMENT

            TokenType.BAD_CHARACTER -> MercuryColors.BAD_CHARACTER
            else -> null
        }?.textAttributesKey)
    }
}


class MercurySyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter =
        MercuryHighlighter()
}
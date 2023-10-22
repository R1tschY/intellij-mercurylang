package de.richardliebscher.intellij.mercurylang.ide.colors

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

enum class MercuryColors(name: String, default: TextAttributesKey? = null) {
    KEYWORDS("Keywords", DefaultLanguageHighlighterColors.KEYWORD),
    PARENTHESES("Parentheses", DefaultLanguageHighlighterColors.PARENTHESES),
    BRACES("Braces", DefaultLanguageHighlighterColors.BRACES),
    BRACKETS("Brackets", DefaultLanguageHighlighterColors.BRACKETS),
    OPERATORS("Operators", DefaultLanguageHighlighterColors.OPERATION_SIGN),

    PERIOD("Period", DefaultLanguageHighlighterColors.SEMICOLON),
    COMMA("Comma", DefaultLanguageHighlighterColors.COMMA),

    VARIABLE("Variable", DefaultLanguageHighlighterColors.IDENTIFIER),
    IDENT("Name", DefaultLanguageHighlighterColors.IDENTIFIER),

    NUMBER("Literal//Number", DefaultLanguageHighlighterColors.NUMBER),
    STRING("Literal//String", DefaultLanguageHighlighterColors.STRING),

    DETERMINISM_CATEGORY("Determinism category", DefaultLanguageHighlighterColors.CONSTANT),

    LINE_COMMENT("Comment//Line", DefaultLanguageHighlighterColors.LINE_COMMENT),
    BLOCK_COMMENT("Comment//Block", DefaultLanguageHighlighterColors.BLOCK_COMMENT),

    BAD_CHARACTER("Bad value", HighlighterColors.BAD_CHARACTER),
    ;

    val textAttributesKey = TextAttributesKey.createTextAttributesKey("mercury.$name", default)
}
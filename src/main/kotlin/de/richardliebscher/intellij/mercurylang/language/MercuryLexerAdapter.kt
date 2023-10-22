package de.richardliebscher.intellij.mercurylang.language

import com.intellij.lexer.FlexAdapter

class MercuryLexerAdapter : FlexAdapter(MercuryLexer(null))
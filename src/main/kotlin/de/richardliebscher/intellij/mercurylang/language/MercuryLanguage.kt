package de.richardliebscher.intellij.mercurylang.language

import com.intellij.lang.Language

object MercuryLanguage: Language("Mercury") {
    private fun readResolve(): Any = MercuryLanguage
}
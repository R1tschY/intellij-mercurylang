package de.richardliebscher.intellij.mercurylang.ide

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes

class MercuryQuoteHandler : SimpleTokenSetQuoteHandler(MercuryTypes.STRING)
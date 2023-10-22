package de.richardliebscher.intellij.mercurylang.language.psi

import com.intellij.psi.tree.IElementType
import de.richardliebscher.intellij.mercurylang.language.MercuryLanguage
import org.jetbrains.annotations.NonNls

class MercuryElementType(@NonNls debugName: String): IElementType(debugName, MercuryLanguage)
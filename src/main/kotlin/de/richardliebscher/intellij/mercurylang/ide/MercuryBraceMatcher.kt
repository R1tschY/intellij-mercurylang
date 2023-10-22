package de.richardliebscher.intellij.mercurylang.ide

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes

private val bracePairs = arrayOf(
    BracePair(MercuryTypes.OPEN, MercuryTypes.CLOSE, false),
    BracePair(MercuryTypes.OPEN_CURLY, MercuryTypes.CLOSE_CURLY, false),
    BracePair(MercuryTypes.OPEN_LIST, MercuryTypes.CLOSE_LIST, false),
)

class MercuryBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = bracePairs

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}
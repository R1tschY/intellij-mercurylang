package de.richardliebscher.intellij.mercurylang.language.psi.impl

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.tree.TokenSet
import com.intellij.util.PlatformIcons
import com.intellij.util.containers.stream
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryDeclaration
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryQname
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes
import java.util.stream.Collectors
import javax.swing.Icon


class MercuryPsiImplUtil {
    companion object {
        @JvmStatic
        fun toString(element: MercuryQname): String {
            return element.node.getChildren(TokenSet.create(MercuryTypes.IDENT))
                .stream().map { it.text }.collect(Collectors.joining("."))
        }

        @JvmStatic
        fun getPresentation(element: MercuryDeclaration): ItemPresentation {
            return object : ItemPresentation {
                override fun getPresentableText(): String? {
                    val declPred = element.declPred
                    if (declPred != null) {
                        return declPred.qname?.let { toString(it) }
                    }
                    return null
                }

                override fun getLocationString(): String {
                    return element.containingFile.name
                }

                override fun getIcon(unused: Boolean): Icon? {
                    return PlatformIcons.METHOD_ICON
                }
            }
        }
    }
}
package de.richardliebscher.intellij.mercurylang.ide.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.SmartList
import de.richardliebscher.intellij.mercurylang.language.MercuryFile
import de.richardliebscher.intellij.mercurylang.language.psi.*
import de.richardliebscher.intellij.mercurylang.language.psi.impl.MercuryDeclarationImpl
import de.richardliebscher.intellij.mercurylang.language.psi.impl.MercuryPredicateRuleImpl
import io.ktor.util.reflect.*


class MercuryStructureViewModel(editor: Editor, psiFile: PsiFile)
    : StructureViewModelBase(psiFile, editor, MercuryStructureViewElement(psiFile))
    , StructureViewModel.ElementInfoProvider {

    override fun getSorters(): Array<Sorter> = arrayOf(Sorter.ALPHA_SORTER)

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        val value = (element ?: return false).value
        return value.instanceOf(MercuryDeclaration::class)
                || value.instanceOf(MercuryFunctionRule::class)
                || value.instanceOf(MercuryPredicateRule::class)
                || value.instanceOf(MercuryDcgRule::class)
    }

    override fun getSuitableClasses(): Array<Class<Any>> {
        return arrayOf(
            MercuryDeclaration::class.java as Class<Any>,
            MercuryFunctionRule::class.java as Class<Any>,
            MercuryPredicateRule::class.java as Class<Any>,
            MercuryDcgRule::class.java as Class<Any>,
        )
    }
}


class MercuryStructureViewElement(private val myElement: NavigatablePsiElement) : StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any {
        return myElement
    }

    override fun navigate(requestFocus: Boolean) {
        myElement.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return myElement.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return myElement.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        val name = myElement.name
        return name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        val presentation = myElement.presentation
        return presentation ?: PresentationData()
    }

    override fun getChildren(): Array<out TreeElement> {
        if (myElement is MercuryFile) {
            val treeElements: MutableList<TreeElement> = ArrayList()
            var child: PsiElement? = myElement.getFirstChild()
            while (child != null) {
                if (child is MercuryInterfaceBlock) {
                    getInnerChildren(child, false, treeElements);
                }
                child = child.nextSibling
            }
            return treeElements.toTypedArray()
        }
        return StructureViewTreeElement.EMPTY_ARRAY
    }

    private fun getInnerChildren(element: PsiElement, impl: Boolean, results: MutableList<TreeElement>) {
        var child: PsiElement? = element.firstChild
        while (child != null) {
            if (child is MercuryDeclaration) {
                results.add(MercuryStructureViewElement(child as MercuryDeclarationImpl))
            }
            child = child.nextSibling
        }
    }
}

class MercuryStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return MercuryStructureViewModel(editor!!, psiFile)
            }
        }
    }
}
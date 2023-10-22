package de.richardliebscher.intellij.mercurylang.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryDeclaration
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryImplicationGoal
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes
import de.richardliebscher.intellij.mercurylang.language.psi.impl.MercuryDeclarationImpl


class MercuryCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(MercuryTypes.COLON_MINUS),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module"))
                }
            }
        )
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement().withParent(PlatformPatterns.psiElement(MercuryTypes.DECLARATION)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module2"))
                }
            }
        )
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement().withSuperParent(2, PlatformPatterns.psiElement(MercuryTypes.DECLARATION)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module3"))
                }
            }
        )
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement().withSuperParent(2, MercuryDeclarationImpl::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module3"))
                }
            }
        )
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement().withParent(MercuryDeclarationImpl::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module34"))
                }
            }
        )
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(MercuryImplicationGoal::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("use_module35"))
                }
            }
        )
    }

    override fun beforeCompletion(context: CompletionInitializationContext) {
        context.dummyIdentifier = CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED
    }

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        super.fillCompletionVariants(parameters, result)
    }
}
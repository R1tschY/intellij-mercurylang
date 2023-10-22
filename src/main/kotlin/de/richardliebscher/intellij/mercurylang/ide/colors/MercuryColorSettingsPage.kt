package de.richardliebscher.intellij.mercurylang.ide.colors

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import de.richardliebscher.intellij.mercurylang.ide.MercuryHighlighter
import de.richardliebscher.intellij.mercurylang.language.MercuryIcons
import javax.swing.Icon

private val ATTRIBUTE_DESCRIPTORS = MercuryColors.values().map {
    AttributesDescriptor(it.name, it.textAttributesKey)
}.toTypedArray()

private val DEMO_TEXT = """
    % Line comment
    /* block comment */
    :- module hello.
    
    :- interface.
    :- import_module io.
    
    :- pred main(io::di, io::uo) is det.
    
    :- implementation.
    
    main(!IO) :-
        io.write_string("Hello, World!\n", !IO).""".trimIndent()


class MercuryColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = MercuryIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = MercuryHighlighter()

    override fun getDemoText(): String = DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getAttributeDescriptors(): Array<out AttributesDescriptor> = ATTRIBUTE_DESCRIPTORS

    override fun getColorDescriptors(): Array<out ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "Mercury"
}
package de.richardliebscher.intellij.mercurylang.ide

import com.intellij.lang.Commenter

class MercuryCommenter : Commenter {
    override fun getLineCommentPrefix(): String = "%"
    override fun getBlockCommentPrefix(): String = "/*"
    override fun getBlockCommentSuffix(): String = "*/"
    override fun getCommentedBlockCommentPrefix(): String? = null
    override fun getCommentedBlockCommentSuffix(): String? = null
}
// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes.*;
import de.richardliebscher.intellij.mercurylang.language.psi.*;

public class MercuryLiteralTermImpl extends MercuryTermImpl implements MercuryLiteralTerm {

  public MercuryLiteralTermImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MercuryVisitor visitor) {
    visitor.visitLiteralTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MercuryVisitor) accept((MercuryVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getFloat() {
    return findChildByType(FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getIdent() {
    return findChildByType(IDENT);
  }

  @Override
  @Nullable
  public PsiElement getImplementationDefinedLiteral() {
    return findChildByType(IMPLEMENTATION_DEFINED_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}

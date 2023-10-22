// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.richardliebscher.intellij.mercurylang.language.psi.*;

public class MercuryDeclTypeImpl extends ASTWrapperPsiElement implements MercuryDeclType {

  public MercuryDeclTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MercuryVisitor visitor) {
    visitor.visitDeclType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MercuryVisitor) accept((MercuryVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MercuryAbstractType getAbstractType() {
    return findChildByClass(MercuryAbstractType.class);
  }

  @Override
  @Nullable
  public MercuryDiscriminatedUnion getDiscriminatedUnion() {
    return findChildByClass(MercuryDiscriminatedUnion.class);
  }

  @Override
  @Nullable
  public MercuryEquivalenceType getEquivalenceType() {
    return findChildByClass(MercuryEquivalenceType.class);
  }

  @Override
  @Nullable
  public MercurySubtype getSubtype() {
    return findChildByClass(MercurySubtype.class);
  }

  @Override
  @Nullable
  public MercuryTypeRef getTypeRef() {
    return findChildByClass(MercuryTypeRef.class);
  }

}

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

public class MercuryDeclArgumentTypeImpl extends ASTWrapperPsiElement implements MercuryDeclArgumentType {

  public MercuryDeclArgumentTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MercuryVisitor visitor) {
    visitor.visitDeclArgumentType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MercuryVisitor) accept((MercuryVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MercuryDeclArgumentType> getDeclArgumentTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MercuryDeclArgumentType.class);
  }

  @Override
  @Nullable
  public MercuryQname getQname() {
    return findChildByClass(MercuryQname.class);
  }

  @Override
  @Nullable
  public PsiElement getVariable() {
    return findChildByType(VARIABLE);
  }

}

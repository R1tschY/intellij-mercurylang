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

public class MercuryImplementationBlockImpl extends ASTWrapperPsiElement implements MercuryImplementationBlock {

  public MercuryImplementationBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MercuryVisitor visitor) {
    visitor.visitImplementationBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MercuryVisitor) accept((MercuryVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MercuryDcgRule> getDcgRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MercuryDcgRule.class);
  }

  @Override
  @NotNull
  public MercuryDeclImplementation getDeclImplementation() {
    return findNotNullChildByClass(MercuryDeclImplementation.class);
  }

  @Override
  @NotNull
  public List<MercuryDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MercuryDeclaration.class);
  }

  @Override
  @NotNull
  public List<MercuryFunctionRule> getFunctionRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MercuryFunctionRule.class);
  }

  @Override
  @NotNull
  public List<MercuryPredicateRule> getPredicateRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MercuryPredicateRule.class);
  }

}

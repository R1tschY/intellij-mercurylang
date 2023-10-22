// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MercuryInterfaceBlock extends PsiElement {

  @NotNull
  List<MercuryDcgRule> getDcgRuleList();

  @NotNull
  MercuryDeclInterface getDeclInterface();

  @NotNull
  List<MercuryDeclaration> getDeclarationList();

  @NotNull
  List<MercuryFunctionRule> getFunctionRuleList();

  @NotNull
  List<MercuryPredicateRule> getPredicateRuleList();

}

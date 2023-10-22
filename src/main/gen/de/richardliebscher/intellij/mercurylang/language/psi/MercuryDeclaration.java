// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface MercuryDeclaration extends PsiElement {

  @Nullable
  MercuryDeclImportModule getDeclImportModule();

  @Nullable
  MercuryDeclPred getDeclPred();

  @Nullable
  MercuryDeclSolverType getDeclSolverType();

  @Nullable
  MercuryDeclType getDeclType();

  @Nullable
  MercuryDeclUseModule getDeclUseModule();

  @NotNull
  ItemPresentation getPresentation();

}

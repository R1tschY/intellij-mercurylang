// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MercuryDeclArgumentType extends PsiElement {

  @NotNull
  List<MercuryDeclArgumentType> getDeclArgumentTypeList();

  @Nullable
  MercuryQname getQname();

  @Nullable
  PsiElement getVariable();

}

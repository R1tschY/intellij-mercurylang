// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.richardliebscher.intellij.mercurylang.language.psi.impl.*;

public interface MercuryTypes {

  IElementType ABSTRACT_TYPE = new MercuryElementType("ABSTRACT_TYPE");
  IElementType ADD_TERM = new MercuryElementType("ADD_TERM");
  IElementType ARGUMENT_LIST = new MercuryElementType("ARGUMENT_LIST");
  IElementType BOOL_AND_TERM = new MercuryElementType("BOOL_AND_TERM");
  IElementType BOOL_OR_TERM = new MercuryElementType("BOOL_OR_TERM");
  IElementType CONJUNCTION_GOAL = new MercuryElementType("CONJUNCTION_GOAL");
  IElementType DATA_TERM = new MercuryElementType("DATA_TERM");
  IElementType DCG_RULE = new MercuryElementType("DCG_RULE");
  IElementType DECLARATION = new MercuryElementType("DECLARATION");
  IElementType DECL_ARGUMENT_LIST = new MercuryElementType("DECL_ARGUMENT_LIST");
  IElementType DECL_ARGUMENT_TYPE = new MercuryElementType("DECL_ARGUMENT_TYPE");
  IElementType DECL_ARGUMENT_TYPE_WITH_MODE = new MercuryElementType("DECL_ARGUMENT_TYPE_WITH_MODE");
  IElementType DECL_IMPLEMENTATION = new MercuryElementType("DECL_IMPLEMENTATION");
  IElementType DECL_IMPORT_MODULE = new MercuryElementType("DECL_IMPORT_MODULE");
  IElementType DECL_INTERFACE = new MercuryElementType("DECL_INTERFACE");
  IElementType DECL_MODULE = new MercuryElementType("DECL_MODULE");
  IElementType DECL_PRED = new MercuryElementType("DECL_PRED");
  IElementType DECL_SOLVER_TYPE = new MercuryElementType("DECL_SOLVER_TYPE");
  IElementType DECL_TYPE = new MercuryElementType("DECL_TYPE");
  IElementType DECL_USE_MODULE = new MercuryElementType("DECL_USE_MODULE");
  IElementType DETERMINISM_CATEGORY = new MercuryElementType("DETERMINISM_CATEGORY");
  IElementType DISCRIMINATED_UNION = new MercuryElementType("DISCRIMINATED_UNION");
  IElementType DISJUNCTION_GOAL = new MercuryElementType("DISJUNCTION_GOAL");
  IElementType DIV_TERM = new MercuryElementType("DIV_TERM");
  IElementType DOT_TERM = new MercuryElementType("DOT_TERM");
  IElementType EQUIVALENCE_TYPE = new MercuryElementType("EQUIVALENCE_TYPE");
  IElementType EXCLAMATION_TERM = new MercuryElementType("EXCLAMATION_TERM");
  IElementType FAIL_GOAL = new MercuryElementType("FAIL_GOAL");
  IElementType FDIV_TERM = new MercuryElementType("FDIV_TERM");
  IElementType FUNCTION_RULE = new MercuryElementType("FUNCTION_RULE");
  IElementType GOAL = new MercuryElementType("GOAL");
  IElementType IDIV_TERM = new MercuryElementType("IDIV_TERM");
  IElementType IF_THEN_ELSE_1_GOAL = new MercuryElementType("IF_THEN_ELSE_1_GOAL");
  IElementType IF_THEN_ELSE_2_GOAL = new MercuryElementType("IF_THEN_ELSE_2_GOAL");
  IElementType IMPLEMENTATION_BLOCK = new MercuryElementType("IMPLEMENTATION_BLOCK");
  IElementType IMPLICATION_GOAL = new MercuryElementType("IMPLICATION_GOAL");
  IElementType INEQUALITY_GOAL = new MercuryElementType("INEQUALITY_GOAL");
  IElementType INTERFACE_BLOCK = new MercuryElementType("INTERFACE_BLOCK");
  IElementType LEFT_SHIFT_TERM = new MercuryElementType("LEFT_SHIFT_TERM");
  IElementType LIST_TERM = new MercuryElementType("LIST_TERM");
  IElementType LITERAL_TERM = new MercuryElementType("LITERAL_TERM");
  IElementType LOGICAL_EQUIVALENCE_GOAL = new MercuryElementType("LOGICAL_EQUIVALENCE_GOAL");
  IElementType MINUS_MINUS_TERM = new MercuryElementType("MINUS_MINUS_TERM");
  IElementType MINUS_TERM = new MercuryElementType("MINUS_TERM");
  IElementType MODE_IDENT = new MercuryElementType("MODE_IDENT");
  IElementType MODULE_LIST = new MercuryElementType("MODULE_LIST");
  IElementType MOD_TERM = new MercuryElementType("MOD_TERM");
  IElementType MUL_TERM = new MercuryElementType("MUL_TERM");
  IElementType NEGATION_GOAL = new MercuryElementType("NEGATION_GOAL");
  IElementType PARALLEL_CONJUNCTION_GOAL = new MercuryElementType("PARALLEL_CONJUNCTION_GOAL");
  IElementType PARENTHESIZED_TERM = new MercuryElementType("PARENTHESIZED_TERM");
  IElementType PLUS_PLUS_TERM = new MercuryElementType("PLUS_PLUS_TERM");
  IElementType PLUS_TERM = new MercuryElementType("PLUS_TERM");
  IElementType PREDICATE_CALL_GOAL = new MercuryElementType("PREDICATE_CALL_GOAL");
  IElementType PREDICATE_RULE = new MercuryElementType("PREDICATE_RULE");
  IElementType QNAME = new MercuryElementType("QNAME");
  IElementType REM_TERM = new MercuryElementType("REM_TERM");
  IElementType REVERSE_IMPLICATION_GOAL = new MercuryElementType("REVERSE_IMPLICATION_GOAL");
  IElementType RIGHT_SHIFT_TERM = new MercuryElementType("RIGHT_SHIFT_TERM");
  IElementType SIMPLE_COMPOUND_TERM = new MercuryElementType("SIMPLE_COMPOUND_TERM");
  IElementType SUBTYPE = new MercuryElementType("SUBTYPE");
  IElementType SUB_TERM = new MercuryElementType("SUB_TERM");
  IElementType TERM = new MercuryElementType("TERM");
  IElementType TRUE_GOAL = new MercuryElementType("TRUE_GOAL");
  IElementType TUPLE_TERM = new MercuryElementType("TUPLE_TERM");
  IElementType TYPE_REF = new MercuryElementType("TYPE_REF");
  IElementType UNIFICATION_GOAL = new MercuryElementType("UNIFICATION_GOAL");
  IElementType VARIABLE_LIST = new MercuryElementType("VARIABLE_LIST");
  IElementType VARIABLE_TERM = new MercuryElementType("VARIABLE_TERM");

  IElementType AND = new MercuryTokenType("&");
  IElementType BLOCK_COMMENT = new MercuryTokenType("BLOCK_COMMENT");
  IElementType BOOL_AND = new MercuryTokenType("/\\\\");
  IElementType BOOL_OR = new MercuryTokenType("\\\\/");
  IElementType CLOSE = new MercuryTokenType(")");
  IElementType CLOSE_CURLY = new MercuryTokenType("}");
  IElementType CLOSE_LIST = new MercuryTokenType("]");
  IElementType COLONCOLON = new MercuryTokenType("::");
  IElementType COLON_MINUS = new MercuryTokenType(":-");
  IElementType COMMA = new MercuryTokenType(",");
  IElementType DIV = new MercuryTokenType("div");
  IElementType DOT = new MercuryTokenType(".");
  IElementType DOUBLE_EQUAL = new MercuryTokenType("==");
  IElementType END_MODULE = new MercuryTokenType("end_module");
  IElementType EQUAL = new MercuryTokenType("=");
  IElementType EQUAL_LESS = new MercuryTokenType("=<");
  IElementType EXCLAMATION = new MercuryTokenType("!");
  IElementType FAIL = new MercuryTokenType("fail");
  IElementType FINALISE = new MercuryTokenType("finalise");
  IElementType FLOAT = new MercuryTokenType("FLOAT");
  IElementType FUNC = new MercuryTokenType("func");
  IElementType HT_SEP = new MercuryTokenType("|");
  IElementType IDENT = new MercuryTokenType("IDENT");
  IElementType IMPLEMENTATION = new MercuryTokenType("implementation");
  IElementType IMPLEMENTATION_DEFINED_LITERAL = new MercuryTokenType("IMPLEMENTATION_DEFINED_LITERAL");
  IElementType IMPLICATION = new MercuryTokenType("IMPLICATION");
  IElementType IMPORT_MODULE = new MercuryTokenType("import_module");
  IElementType INCLUDE_MODULE = new MercuryTokenType("include_module");
  IElementType INITIALISE = new MercuryTokenType("initialise");
  IElementType INST = new MercuryTokenType("inst");
  IElementType INSTANCE = new MercuryTokenType("instance");
  IElementType INTEGER = new MercuryTokenType("INTEGER");
  IElementType INTERFACE = new MercuryTokenType("interface");
  IElementType IS = new MercuryTokenType("is");
  IElementType LEFT_SHIFT = new MercuryTokenType("<<");
  IElementType LINE_COMMENT = new MercuryTokenType("LINE_COMMENT");
  IElementType LOGICAL_EQUIVALENCE = new MercuryTokenType("LOGICAL_EQUIVALENCE");
  IElementType MINUS = new MercuryTokenType("-");
  IElementType MINUS_MINUS = new MercuryTokenType("--");
  IElementType MOD = new MercuryTokenType("mod");
  IElementType MODE = new MercuryTokenType("mode");
  IElementType MODULE = new MercuryTokenType("module");
  IElementType MUTABLE = new MercuryTokenType("mutable");
  IElementType NOT = new MercuryTokenType("not");
  IElementType OPEN = new MercuryTokenType("(");
  IElementType OPEN_CURLY = new MercuryTokenType("{");
  IElementType OPEN_LIST = new MercuryTokenType("[");
  IElementType PERIOD = new MercuryTokenType("PERIOD");
  IElementType PLUS = new MercuryTokenType("+");
  IElementType PLUS_PLUS = new MercuryTokenType("++");
  IElementType PRAGMA = new MercuryTokenType("pragma");
  IElementType PRED = new MercuryTokenType("pred");
  IElementType PROMISE = new MercuryTokenType("promise");
  IElementType REM = new MercuryTokenType("rem");
  IElementType REVERSE_IMPLICATION = new MercuryTokenType("REVERSE_IMPLICATION");
  IElementType RIGHT_SHIFT = new MercuryTokenType(">>");
  IElementType SEMICOLON = new MercuryTokenType(";");
  IElementType SLASH = new MercuryTokenType("/");
  IElementType SLASHSLASH = new MercuryTokenType("//");
  IElementType SLASH_EQUAL = new MercuryTokenType("\\\\=");
  IElementType SLASH_PLUS = new MercuryTokenType("\\\\+");
  IElementType SOLVER = new MercuryTokenType("solver");
  IElementType STAR = new MercuryTokenType("*");
  IElementType STRING = new MercuryTokenType("STRING");
  IElementType THREE_DASH_ARROW = new MercuryTokenType("--->");
  IElementType TRUE = new MercuryTokenType("true");
  IElementType TWO_DASH_ARROW = new MercuryTokenType("-->");
  IElementType TYPE = new MercuryTokenType("type");
  IElementType TYPECLASS = new MercuryTokenType("typeclass");
  IElementType USE_MODULE = new MercuryTokenType("use_module");
  IElementType VARIABLE = new MercuryTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ABSTRACT_TYPE) {
        return new MercuryAbstractTypeImpl(node);
      }
      else if (type == ADD_TERM) {
        return new MercuryAddTermImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new MercuryArgumentListImpl(node);
      }
      else if (type == BOOL_AND_TERM) {
        return new MercuryBoolAndTermImpl(node);
      }
      else if (type == BOOL_OR_TERM) {
        return new MercuryBoolOrTermImpl(node);
      }
      else if (type == CONJUNCTION_GOAL) {
        return new MercuryConjunctionGoalImpl(node);
      }
      else if (type == DATA_TERM) {
        return new MercuryDataTermImpl(node);
      }
      else if (type == DCG_RULE) {
        return new MercuryDcgRuleImpl(node);
      }
      else if (type == DECLARATION) {
        return new MercuryDeclarationImpl(node);
      }
      else if (type == DECL_ARGUMENT_LIST) {
        return new MercuryDeclArgumentListImpl(node);
      }
      else if (type == DECL_ARGUMENT_TYPE) {
        return new MercuryDeclArgumentTypeImpl(node);
      }
      else if (type == DECL_ARGUMENT_TYPE_WITH_MODE) {
        return new MercuryDeclArgumentTypeWithModeImpl(node);
      }
      else if (type == DECL_IMPLEMENTATION) {
        return new MercuryDeclImplementationImpl(node);
      }
      else if (type == DECL_IMPORT_MODULE) {
        return new MercuryDeclImportModuleImpl(node);
      }
      else if (type == DECL_INTERFACE) {
        return new MercuryDeclInterfaceImpl(node);
      }
      else if (type == DECL_MODULE) {
        return new MercuryDeclModuleImpl(node);
      }
      else if (type == DECL_PRED) {
        return new MercuryDeclPredImpl(node);
      }
      else if (type == DECL_SOLVER_TYPE) {
        return new MercuryDeclSolverTypeImpl(node);
      }
      else if (type == DECL_TYPE) {
        return new MercuryDeclTypeImpl(node);
      }
      else if (type == DECL_USE_MODULE) {
        return new MercuryDeclUseModuleImpl(node);
      }
      else if (type == DETERMINISM_CATEGORY) {
        return new MercuryDeterminismCategoryImpl(node);
      }
      else if (type == DISCRIMINATED_UNION) {
        return new MercuryDiscriminatedUnionImpl(node);
      }
      else if (type == DISJUNCTION_GOAL) {
        return new MercuryDisjunctionGoalImpl(node);
      }
      else if (type == DIV_TERM) {
        return new MercuryDivTermImpl(node);
      }
      else if (type == DOT_TERM) {
        return new MercuryDotTermImpl(node);
      }
      else if (type == EQUIVALENCE_TYPE) {
        return new MercuryEquivalenceTypeImpl(node);
      }
      else if (type == EXCLAMATION_TERM) {
        return new MercuryExclamationTermImpl(node);
      }
      else if (type == FAIL_GOAL) {
        return new MercuryFailGoalImpl(node);
      }
      else if (type == FDIV_TERM) {
        return new MercuryFdivTermImpl(node);
      }
      else if (type == FUNCTION_RULE) {
        return new MercuryFunctionRuleImpl(node);
      }
      else if (type == IDIV_TERM) {
        return new MercuryIdivTermImpl(node);
      }
      else if (type == IF_THEN_ELSE_1_GOAL) {
        return new MercuryIfThenElse1GoalImpl(node);
      }
      else if (type == IF_THEN_ELSE_2_GOAL) {
        return new MercuryIfThenElse2GoalImpl(node);
      }
      else if (type == IMPLEMENTATION_BLOCK) {
        return new MercuryImplementationBlockImpl(node);
      }
      else if (type == IMPLICATION_GOAL) {
        return new MercuryImplicationGoalImpl(node);
      }
      else if (type == INEQUALITY_GOAL) {
        return new MercuryInequalityGoalImpl(node);
      }
      else if (type == INTERFACE_BLOCK) {
        return new MercuryInterfaceBlockImpl(node);
      }
      else if (type == LEFT_SHIFT_TERM) {
        return new MercuryLeftShiftTermImpl(node);
      }
      else if (type == LIST_TERM) {
        return new MercuryListTermImpl(node);
      }
      else if (type == LITERAL_TERM) {
        return new MercuryLiteralTermImpl(node);
      }
      else if (type == LOGICAL_EQUIVALENCE_GOAL) {
        return new MercuryLogicalEquivalenceGoalImpl(node);
      }
      else if (type == MINUS_MINUS_TERM) {
        return new MercuryMinusMinusTermImpl(node);
      }
      else if (type == MINUS_TERM) {
        return new MercuryMinusTermImpl(node);
      }
      else if (type == MODE_IDENT) {
        return new MercuryModeIdentImpl(node);
      }
      else if (type == MODULE_LIST) {
        return new MercuryModuleListImpl(node);
      }
      else if (type == MOD_TERM) {
        return new MercuryModTermImpl(node);
      }
      else if (type == MUL_TERM) {
        return new MercuryMulTermImpl(node);
      }
      else if (type == NEGATION_GOAL) {
        return new MercuryNegationGoalImpl(node);
      }
      else if (type == PARALLEL_CONJUNCTION_GOAL) {
        return new MercuryParallelConjunctionGoalImpl(node);
      }
      else if (type == PARENTHESIZED_TERM) {
        return new MercuryParenthesizedTermImpl(node);
      }
      else if (type == PLUS_PLUS_TERM) {
        return new MercuryPlusPlusTermImpl(node);
      }
      else if (type == PLUS_TERM) {
        return new MercuryPlusTermImpl(node);
      }
      else if (type == PREDICATE_CALL_GOAL) {
        return new MercuryPredicateCallGoalImpl(node);
      }
      else if (type == PREDICATE_RULE) {
        return new MercuryPredicateRuleImpl(node);
      }
      else if (type == QNAME) {
        return new MercuryQnameImpl(node);
      }
      else if (type == REM_TERM) {
        return new MercuryRemTermImpl(node);
      }
      else if (type == REVERSE_IMPLICATION_GOAL) {
        return new MercuryReverseImplicationGoalImpl(node);
      }
      else if (type == RIGHT_SHIFT_TERM) {
        return new MercuryRightShiftTermImpl(node);
      }
      else if (type == SIMPLE_COMPOUND_TERM) {
        return new MercurySimpleCompoundTermImpl(node);
      }
      else if (type == SUBTYPE) {
        return new MercurySubtypeImpl(node);
      }
      else if (type == SUB_TERM) {
        return new MercurySubTermImpl(node);
      }
      else if (type == TRUE_GOAL) {
        return new MercuryTrueGoalImpl(node);
      }
      else if (type == TUPLE_TERM) {
        return new MercuryTupleTermImpl(node);
      }
      else if (type == TYPE_REF) {
        return new MercuryTypeRefImpl(node);
      }
      else if (type == UNIFICATION_GOAL) {
        return new MercuryUnificationGoalImpl(node);
      }
      else if (type == VARIABLE_LIST) {
        return new MercuryVariableListImpl(node);
      }
      else if (type == VARIABLE_TERM) {
        return new MercuryVariableTermImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

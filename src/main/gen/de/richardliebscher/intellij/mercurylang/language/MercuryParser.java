// This is a generated file. Not intended for manual editing.
package de.richardliebscher.intellij.mercurylang.language;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MercuryParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return module(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(CONJUNCTION_GOAL, DISJUNCTION_GOAL, FAIL_GOAL, GOAL,
      IF_THEN_ELSE_1_GOAL, IF_THEN_ELSE_2_GOAL, IMPLICATION_GOAL, INEQUALITY_GOAL,
      LOGICAL_EQUIVALENCE_GOAL, NEGATION_GOAL, PARALLEL_CONJUNCTION_GOAL, PREDICATE_CALL_GOAL,
      REVERSE_IMPLICATION_GOAL, TRUE_GOAL, UNIFICATION_GOAL),
    create_token_set_(ADD_TERM, BOOL_AND_TERM, BOOL_OR_TERM, DATA_TERM,
      DIV_TERM, DOT_TERM, EXCLAMATION_TERM, FDIV_TERM,
      IDIV_TERM, LEFT_SHIFT_TERM, LIST_TERM, LITERAL_TERM,
      MINUS_MINUS_TERM, MINUS_TERM, MOD_TERM, MUL_TERM,
      PARENTHESIZED_TERM, PLUS_PLUS_TERM, PLUS_TERM, REM_TERM,
      RIGHT_SHIFT_TERM, SIMPLE_COMPOUND_TERM, SUB_TERM, TERM,
      TUPLE_TERM, VARIABLE_TERM),
  };

  /* ********************************************************** */
  public static boolean abstract_type(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ABSTRACT_TYPE, true);
    return true;
  }

  /* ********************************************************** */
  // data_term (COMMA data_term) *
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = data_term(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA data_term) *
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA data_term
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && data_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rule | dcg_rule
  static boolean clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clause")) return false;
    boolean r;
    r = rule(b, l + 1);
    if (!r) r = dcg_rule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // term
  static boolean constructor_definition(PsiBuilder b, int l) {
    return term(b, l + 1, -1);
  }

  /* ********************************************************** */
  // [constructor_definition (';' constructor_definition) *]
  static boolean constructor_definition_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_definition_list")) return false;
    constructor_definition_list_0(b, l + 1);
    return true;
  }

  // constructor_definition (';' constructor_definition) *
  private static boolean constructor_definition_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_definition_list_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = constructor_definition(b, l + 1);
    p = r; // pin = 1
    r = r && constructor_definition_list_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (';' constructor_definition) *
  private static boolean constructor_definition_list_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_definition_list_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constructor_definition_list_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constructor_definition_list_0_1", c)) break;
    }
    return true;
  }

  // ';' constructor_definition
  private static boolean constructor_definition_list_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_definition_list_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, SEMICOLON);
    p = r; // pin = 1
    r = r && constructor_definition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // functor_term
  static boolean data_functor(PsiBuilder b, int l) {
    return term(b, l + 1, -1);
  }

  /* ********************************************************** */
  // VARIABLE | data_functor
  public static boolean data_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, DATA_TERM, "<data term>");
    r = consumeTokenFast(b, VARIABLE);
    if (!r) r = data_functor(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // functor_term '-->' functor_term
  public static boolean dcg_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dcg_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DCG_RULE, "<dcg rule>");
    r = term(b, l + 1, -1);
    r = r && consumeToken(b, TWO_DASH_ARROW);
    r = r && term(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' decl_argument_type_with_mode (COMMA decl_argument_type_with_mode) * ')'
  public static boolean decl_argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_list")) return false;
    if (!nextTokenIs(b, OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_ARGUMENT_LIST, null);
    r = consumeToken(b, OPEN);
    p = r; // pin = 1
    r = r && report_error_(b, decl_argument_type_with_mode(b, l + 1));
    r = p && report_error_(b, decl_argument_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, CLOSE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA decl_argument_type_with_mode) *
  private static boolean decl_argument_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decl_argument_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decl_argument_list_2", c)) break;
    }
    return true;
  }

  // COMMA decl_argument_type_with_mode
  private static boolean decl_argument_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && decl_argument_type_with_mode(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // qname ( '(' decl_argument_type (COMMA decl_argument_type)* ')' )? | VARIABLE
  public static boolean decl_argument_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type")) return false;
    if (!nextTokenIs(b, "<decl argument type>", IDENT, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECL_ARGUMENT_TYPE, "<decl argument type>");
    r = decl_argument_type_0(b, l + 1);
    if (!r) r = consumeToken(b, VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // qname ( '(' decl_argument_type (COMMA decl_argument_type)* ')' )?
  private static boolean decl_argument_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qname(b, l + 1);
    r = r && decl_argument_type_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( '(' decl_argument_type (COMMA decl_argument_type)* ')' )?
  private static boolean decl_argument_type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_0_1")) return false;
    decl_argument_type_0_1_0(b, l + 1);
    return true;
  }

  // '(' decl_argument_type (COMMA decl_argument_type)* ')'
  private static boolean decl_argument_type_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN);
    r = r && decl_argument_type(b, l + 1);
    r = r && decl_argument_type_0_1_0_2(b, l + 1);
    r = r && consumeToken(b, CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA decl_argument_type)*
  private static boolean decl_argument_type_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decl_argument_type_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decl_argument_type_0_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA decl_argument_type
  private static boolean decl_argument_type_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && decl_argument_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // decl_argument_type ("::" mode_ident)?
  public static boolean decl_argument_type_with_mode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_with_mode")) return false;
    if (!nextTokenIs(b, "<decl argument type with mode>", IDENT, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECL_ARGUMENT_TYPE_WITH_MODE, "<decl argument type with mode>");
    r = decl_argument_type(b, l + 1);
    r = r && decl_argument_type_with_mode_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("::" mode_ident)?
  private static boolean decl_argument_type_with_mode_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_with_mode_1")) return false;
    decl_argument_type_with_mode_1_0(b, l + 1);
    return true;
  }

  // "::" mode_ident
  private static boolean decl_argument_type_with_mode_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_argument_type_with_mode_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLONCOLON);
    r = r && mode_ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPLEMENTATION
  public static boolean decl_implementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_implementation")) return false;
    if (!nextTokenIs(b, IMPLEMENTATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPLEMENTATION);
    exit_section_(b, m, DECL_IMPLEMENTATION, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_MODULE module_list
  public static boolean decl_import_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_import_module")) return false;
    if (!nextTokenIs(b, IMPORT_MODULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_IMPORT_MODULE, null);
    r = consumeToken(b, IMPORT_MODULE);
    p = r; // pin = 1
    r = r && module_list(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // INTERFACE
  public static boolean decl_interface(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_interface")) return false;
    if (!nextTokenIs(b, INTERFACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTERFACE);
    exit_section_(b, m, DECL_INTERFACE, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE qname
  public static boolean decl_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_module")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_MODULE, "<decl module>");
    r = consumeToken(b, MODULE);
    p = r; // pin = 1
    r = r && qname(b, l + 1);
    exit_section_(b, l, m, r, p, MercuryParser::no_period);
    return r || p;
  }

  /* ********************************************************** */
  // PRED qname decl_argument_list ('is' determinism_category)?
  public static boolean decl_pred(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_pred")) return false;
    if (!nextTokenIs(b, PRED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_PRED, null);
    r = consumeToken(b, PRED);
    p = r; // pin = 1
    r = r && report_error_(b, qname(b, l + 1));
    r = p && report_error_(b, decl_argument_list(b, l + 1)) && r;
    r = p && decl_pred_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('is' determinism_category)?
  private static boolean decl_pred_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_pred_3")) return false;
    decl_pred_3_0(b, l + 1);
    return true;
  }

  // 'is' determinism_category
  private static boolean decl_pred_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_pred_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, IS);
    p = r; // pin = 1
    r = r && determinism_category(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // SOLVER TYPE
  public static boolean decl_solver_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_solver_type")) return false;
    if (!nextTokenIs(b, SOLVER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_SOLVER_TYPE, null);
    r = consumeTokens(b, 1, SOLVER, TYPE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TYPE type_ref (
  //     discriminated_union | equivalence_type | subtype | abstract_type)
  public static boolean decl_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_type")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_TYPE, null);
    r = consumeToken(b, TYPE);
    p = r; // pin = 1
    r = r && report_error_(b, type_ref(b, l + 1));
    r = p && decl_type_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // discriminated_union | equivalence_type | subtype | abstract_type
  private static boolean decl_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_type_2")) return false;
    boolean r;
    r = discriminated_union(b, l + 1);
    if (!r) r = equivalence_type(b, l + 1);
    if (!r) r = subtype(b, l + 1);
    if (!r) r = abstract_type(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // USE_MODULE module_list
  public static boolean decl_use_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_use_module")) return false;
    if (!nextTokenIs(b, USE_MODULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_USE_MODULE, null);
    r = consumeToken(b, USE_MODULE);
    p = r; // pin = 1
    r = r && module_list(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !(no_interface_impl) COLON_MINUS (decl_type
  //     | decl_solver_type
  //     | decl_import_module
  //     | decl_pred
  //     | decl_use_module
  // )
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = declaration_0(b, l + 1);
    r = r && consumeToken(b, COLON_MINUS);
    p = r; // pin = 2
    r = r && declaration_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !(no_interface_impl)
  private static boolean declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !declaration_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (no_interface_impl)
  private static boolean declaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = no_interface_impl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // decl_type
  //     | decl_solver_type
  //     | decl_import_module
  //     | decl_pred
  //     | decl_use_module
  private static boolean declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2")) return false;
    boolean r;
    r = decl_type(b, l + 1);
    if (!r) r = decl_solver_type(b, l + 1);
    if (!r) r = decl_import_module(b, l + 1);
    if (!r) r = decl_pred(b, l + 1);
    if (!r) r = decl_use_module(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean determinism_category(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "determinism_category")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, DETERMINISM_CATEGORY, r);
    return r;
  }

  /* ********************************************************** */
  // '--->' constructor_definition_list
  public static boolean discriminated_union(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discriminated_union")) return false;
    if (!nextTokenIs(b, THREE_DASH_ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THREE_DASH_ARROW);
    r = r && constructor_definition_list(b, l + 1);
    exit_section_(b, m, DISCRIMINATED_UNION, r);
    return r;
  }

  /* ********************************************************** */
  // '==' term
  public static boolean equivalence_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equivalence_type")) return false;
    if (!nextTokenIs(b, DOUBLE_EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_EQUAL);
    r = r && term(b, l + 1, -1);
    exit_section_(b, m, EQUIVALENCE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // data_term EQUAL data_term (COLON_MINUS goal)?
  public static boolean function_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_RULE, "<function rule>");
    r = data_term(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && data_term(b, l + 1);
    r = r && function_rule_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON_MINUS goal)?
  private static boolean function_rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_rule_3")) return false;
    function_rule_3_0(b, l + 1);
    return true;
  }

  // COLON_MINUS goal
  private static boolean function_rule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_rule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && goal(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON_MINUS decl_implementation PERIOD item_*
  public static boolean implementation_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implementation_block")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && decl_implementation(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    r = r && implementation_block_3(b, l + 1);
    exit_section_(b, m, IMPLEMENTATION_BLOCK, r);
    return r;
  }

  // item_*
  private static boolean implementation_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implementation_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "implementation_block_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COLON_MINUS decl_interface PERIOD item_*
  public static boolean interface_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_block")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && decl_interface(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    r = r && interface_block_3(b, l + 1);
    exit_section_(b, m, INTERFACE_BLOCK, r);
    return r;
  }

  // item_*
  private static boolean interface_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "interface_block_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (declaration | clause) PERIOD
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item__0(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, m, null, r);
    return r;
  }

  // declaration | clause
  private static boolean item__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__0")) return false;
    boolean r;
    r = declaration(b, l + 1);
    if (!r) r = clause(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // qname
  public static boolean mode_ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mode_ident")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qname(b, l + 1);
    exit_section_(b, m, MODE_IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // start_module
  //  (interface_block | implementation_block)*
  //  stop_module?
  static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = start_module(b, l + 1);
    r = r && module_1(b, l + 1);
    r = r && module_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (interface_block | implementation_block)*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_1", c)) break;
    }
    return true;
  }

  // interface_block | implementation_block
  private static boolean module_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1_0")) return false;
    boolean r;
    r = interface_block(b, l + 1);
    if (!r) r = implementation_block(b, l + 1);
    return r;
  }

  // stop_module?
  private static boolean module_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2")) return false;
    stop_module(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // qname (COMMA qname)*
  public static boolean module_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_list")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qname(b, l + 1);
    r = r && module_list_1(b, l + 1);
    exit_section_(b, m, MODULE_LIST, r);
    return r;
  }

  // (COMMA qname)*
  private static boolean module_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_list_1", c)) break;
    }
    return true;
  }

  // COMMA qname
  private static boolean module_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && qname(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON_MINUS (decl_interface | decl_implementation)
  static boolean no_interface_impl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "no_interface_impl")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && no_interface_impl_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // decl_interface | decl_implementation
  private static boolean no_interface_impl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "no_interface_impl_1")) return false;
    boolean r;
    r = decl_interface(b, l + 1);
    if (!r) r = decl_implementation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(PERIOD)
  static boolean no_period(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "no_period")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // data_term (COLON_MINUS goal)?
  public static boolean predicate_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE_RULE, "<predicate rule>");
    r = data_term(b, l + 1);
    r = r && predicate_rule_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON_MINUS goal)?
  private static boolean predicate_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_rule_1")) return false;
    predicate_rule_1_0(b, l + 1);
    return true;
  }

  // COLON_MINUS goal
  private static boolean predicate_rule_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_rule_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && goal(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT (DOT IDENT)*
  public static boolean qname(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && qname_1(b, l + 1);
    exit_section_(b, m, QNAME, r);
    return r;
  }

  // (DOT IDENT)*
  private static boolean qname_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qname_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qname_1", c)) break;
    }
    return true;
  }

  // DOT IDENT
  private static boolean qname_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function_rule | predicate_rule
  static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    boolean r;
    r = function_rule(b, l + 1);
    if (!r) r = predicate_rule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // COLON_MINUS decl_module PERIOD
  static boolean start_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_module")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_MINUS);
    r = r && decl_module(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON_MINUS END_MODULE PERIOD
  static boolean stop_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stop_module")) return false;
    if (!nextTokenIs(b, COLON_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON_MINUS, END_MODULE, PERIOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '=<' type_ref '--->' constructor_definition_list
  public static boolean subtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subtype")) return false;
    if (!nextTokenIs(b, EQUAL_LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL_LESS);
    r = r && type_ref(b, l + 1);
    r = r && consumeToken(b, THREE_DASH_ARROW);
    r = r && constructor_definition_list(b, l + 1);
    exit_section_(b, m, SUBTYPE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT variable_list?
  public static boolean type_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && type_ref_1(b, l + 1);
    exit_section_(b, m, TYPE_REF, r);
    return r;
  }

  // variable_list?
  private static boolean type_ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref_1")) return false;
    variable_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' variable_term (COMMA variable_term) * ')'
  public static boolean variable_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_list")) return false;
    if (!nextTokenIs(b, OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_LIST, null);
    r = consumeToken(b, OPEN);
    p = r; // pin = 1
    r = r && report_error_(b, variable_term(b, l + 1));
    r = p && report_error_(b, variable_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, CLOSE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA variable_term) *
  private static boolean variable_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_list_2", c)) break;
    }
    return true;
  }

  // COMMA variable_term
  private static boolean variable_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && variable_term(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Expression root: goal
  // Operator priority table:
  // 0: BINARY(conjunction_goal)
  // 1: BINARY(parallel_conjunction_goal)
  // 2: ATOM(if_then_else1_goal)
  // 3: BINARY(if_then_else2_goal)
  // 4: BINARY(disjunction_goal)
  // 5: ATOM(true_goal)
  // 6: ATOM(fail_goal)
  // 7: ATOM(negation_goal)
  // 8: BINARY(implication_goal)
  // 9: BINARY(reverse_implication_goal)
  // 10: BINARY(logical_equivalence_goal)
  // 11: ATOM(unification_goal)
  // 12: ATOM(inequality_goal)
  // 13: ATOM(predicate_call_goal)
  public static boolean goal(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "goal")) return false;
    addVariant(b, "<goal>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<goal>");
    r = if_then_else1_goal(b, l + 1);
    if (!r) r = true_goal(b, l + 1);
    if (!r) r = fail_goal(b, l + 1);
    if (!r) r = negation_goal(b, l + 1);
    if (!r) r = unification_goal(b, l + 1);
    if (!r) r = inequality_goal(b, l + 1);
    if (!r) r = predicate_call_goal(b, l + 1);
    p = r;
    r = r && goal_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean goal_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "goal_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, COMMA)) {
        r = goal(b, l, -1);
        exit_section_(b, l, m, CONJUNCTION_GOAL, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, AND)) {
        r = goal(b, l, 0);
        exit_section_(b, l, m, PARALLEL_CONJUNCTION_GOAL, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, "->")) {
        r = report_error_(b, goal(b, l, 3));
        r = if_then_else2_goal_1(b, l + 1) && r;
        exit_section_(b, l, m, IF_THEN_ELSE_2_GOAL, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, SEMICOLON)) {
        r = goal(b, l, 3);
        exit_section_(b, l, m, DISJUNCTION_GOAL, r, true, null);
      }
      else if (g < 8 && consumeTokenSmart(b, IMPLICATION)) {
        r = goal(b, l, 7);
        exit_section_(b, l, m, IMPLICATION_GOAL, r, true, null);
      }
      else if (g < 9 && consumeTokenSmart(b, REVERSE_IMPLICATION)) {
        r = goal(b, l, 8);
        exit_section_(b, l, m, REVERSE_IMPLICATION_GOAL, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, LOGICAL_EQUIVALENCE)) {
        r = goal(b, l, 9);
        exit_section_(b, l, m, LOGICAL_EQUIVALENCE_GOAL, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // "if" goal "then" goal "else" goal
  public static boolean if_then_else1_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_then_else1_goal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_THEN_ELSE_1_GOAL, "<if then else 1 goal>");
    r = consumeTokenSmart(b, "if");
    r = r && goal(b, l + 1, -1);
    r = r && consumeToken(b, "then");
    r = r && goal(b, l + 1, -1);
    r = r && consumeToken(b, "else");
    r = r && goal(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ";" goal
  private static boolean if_then_else2_goal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_then_else2_goal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, SEMICOLON);
    r = r && goal(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TRUE
  public static boolean true_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "true_goal")) return false;
    if (!nextTokenIsSmart(b, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, TRUE);
    exit_section_(b, m, TRUE_GOAL, r);
    return r;
  }

  // FAIL
  public static boolean fail_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fail_goal")) return false;
    if (!nextTokenIsSmart(b, FAIL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, FAIL);
    exit_section_(b, m, FAIL_GOAL, r);
    return r;
  }

  // NOT goal | SLASH_PLUS goal
  public static boolean negation_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negation_goal")) return false;
    if (!nextTokenIsSmart(b, NOT, SLASH_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEGATION_GOAL, "<negation goal>");
    r = negation_goal_0(b, l + 1);
    if (!r) r = negation_goal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT goal
  private static boolean negation_goal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negation_goal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, NOT);
    r = r && goal(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SLASH_PLUS goal
  private static boolean negation_goal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negation_goal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, SLASH_PLUS);
    r = r && goal(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // data_term EQUAL data_term
  public static boolean unification_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unification_goal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNIFICATION_GOAL, "<unification goal>");
    r = data_term(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && data_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // data_term SLASH_EQUAL data_term
  public static boolean inequality_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inequality_goal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INEQUALITY_GOAL, "<inequality goal>");
    r = data_term(b, l + 1);
    r = r && consumeToken(b, SLASH_EQUAL);
    r = r && data_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENT ( OPEN data_term (COMMA data_term) CLOSE )?
  public static boolean predicate_call_goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_call_goal")) return false;
    if (!nextTokenIsSmart(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENT);
    r = r && predicate_call_goal_1(b, l + 1);
    exit_section_(b, m, PREDICATE_CALL_GOAL, r);
    return r;
  }

  // ( OPEN data_term (COMMA data_term) CLOSE )?
  private static boolean predicate_call_goal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_call_goal_1")) return false;
    predicate_call_goal_1_0(b, l + 1);
    return true;
  }

  // OPEN data_term (COMMA data_term) CLOSE
  private static boolean predicate_call_goal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_call_goal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, OPEN);
    r = r && data_term(b, l + 1);
    r = r && predicate_call_goal_1_0_2(b, l + 1);
    r = r && consumeToken(b, CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA data_term
  private static boolean predicate_call_goal_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_call_goal_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && data_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: term
  // Operator priority table:
  // 0: BINARY(dot_term) PREFIX(exclamation_term) BINARY(mul_term) BINARY(fdiv_term)
  //    BINARY(idiv_term) BINARY(left_shift_term) BINARY(right_shift_term) BINARY(div_term)
  //    BINARY(mod_term) BINARY(rem_term) PREFIX(plus_term) BINARY(add_term)
  //    PREFIX(minus_term) BINARY(sub_term) BINARY(plus_plus_term) BINARY(minus_minus_term)
  //    BINARY(bool_and_term) BINARY(bool_or_term) ATOM(simple_compound_term) ATOM(list_term)
  //    ATOM(tuple_term) PREFIX(parenthesized_term) ATOM(literal_term) ATOM(variable_term)
  public static boolean term(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "term")) return false;
    addVariant(b, "<term>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<term>");
    r = exclamation_term(b, l + 1);
    if (!r) r = plus_term(b, l + 1);
    if (!r) r = minus_term(b, l + 1);
    if (!r) r = simple_compound_term(b, l + 1);
    if (!r) r = list_term(b, l + 1);
    if (!r) r = tuple_term(b, l + 1);
    if (!r) r = parenthesized_term(b, l + 1);
    if (!r) r = literal_term(b, l + 1);
    if (!r) r = variable_term(b, l + 1);
    p = r;
    r = r && term_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean term_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "term_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, DOT)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, DOT_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, STAR)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, MUL_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, SLASH)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, FDIV_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, SLASHSLASH)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, IDIV_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, LEFT_SHIFT)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, LEFT_SHIFT_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, RIGHT_SHIFT)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, RIGHT_SHIFT_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, DIV)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, DIV_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, MOD)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, MOD_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, REM)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, REM_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, PLUS)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, ADD_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, MINUS)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, SUB_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, PLUS_PLUS)) {
        r = term(b, l, -1);
        exit_section_(b, l, m, PLUS_PLUS_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, MINUS_MINUS)) {
        r = term(b, l, -1);
        exit_section_(b, l, m, MINUS_MINUS_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, BOOL_AND)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, BOOL_AND_TERM, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, BOOL_OR)) {
        r = term(b, l, 0);
        exit_section_(b, l, m, BOOL_OR_TERM, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean exclamation_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclamation_term")) return false;
    if (!nextTokenIsSmart(b, EXCLAMATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, EXCLAMATION);
    p = r;
    r = p && term(b, l, -1);
    exit_section_(b, l, m, EXCLAMATION_TERM, r, p, null);
    return r || p;
  }

  public static boolean plus_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_term")) return false;
    if (!nextTokenIsSmart(b, PLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, PLUS);
    p = r;
    r = p && term(b, l, -1);
    exit_section_(b, l, m, PLUS_TERM, r, p, null);
    return r || p;
  }

  public static boolean minus_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "minus_term")) return false;
    if (!nextTokenIsSmart(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, MINUS);
    p = r;
    r = p && term(b, l, -1);
    exit_section_(b, l, m, MINUS_TERM, r, p, null);
    return r || p;
  }

  // IDENT OPEN argument_list? ')'
  public static boolean simple_compound_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_compound_term")) return false;
    if (!nextTokenIsSmart(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, IDENT, OPEN);
    r = r && simple_compound_term_2(b, l + 1);
    r = r && consumeToken(b, CLOSE);
    exit_section_(b, m, SIMPLE_COMPOUND_TERM, r);
    return r;
  }

  // argument_list?
  private static boolean simple_compound_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_compound_term_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  // '[' (argument_list ('|' term)? )? ']'
  public static boolean list_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_term")) return false;
    if (!nextTokenIsSmart(b, OPEN_LIST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, OPEN_LIST);
    r = r && list_term_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_LIST);
    exit_section_(b, m, LIST_TERM, r);
    return r;
  }

  // (argument_list ('|' term)? )?
  private static boolean list_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_term_1")) return false;
    list_term_1_0(b, l + 1);
    return true;
  }

  // argument_list ('|' term)?
  private static boolean list_term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_list(b, l + 1);
    r = r && list_term_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('|' term)?
  private static boolean list_term_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_term_1_0_1")) return false;
    list_term_1_0_1_0(b, l + 1);
    return true;
  }

  // '|' term
  private static boolean list_term_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_term_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, HT_SEP);
    r = r && term(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' argument_list? '}'
  public static boolean tuple_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_term")) return false;
    if (!nextTokenIsSmart(b, OPEN_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, OPEN_CURLY);
    r = r && tuple_term_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_CURLY);
    exit_section_(b, m, TUPLE_TERM, r);
    return r;
  }

  // argument_list?
  private static boolean tuple_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_term_1")) return false;
    argument_list(b, l + 1);
    return true;
  }

  public static boolean parenthesized_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesized_term")) return false;
    if (!nextTokenIsSmart(b, OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, OPEN);
    p = r;
    r = p && term(b, l, -1);
    r = p && report_error_(b, consumeToken(b, CLOSE)) && r;
    exit_section_(b, l, m, PARENTHESIZED_TERM, r, p, null);
    return r || p;
  }

  // INTEGER | FLOAT | STRING | IDENT | IMPLEMENTATION_DEFINED_LITERAL
  public static boolean literal_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_TERM, "<literal term>");
    r = consumeTokenSmart(b, INTEGER);
    if (!r) r = consumeTokenSmart(b, FLOAT);
    if (!r) r = consumeTokenSmart(b, STRING);
    if (!r) r = consumeTokenSmart(b, IDENT);
    if (!r) r = consumeTokenSmart(b, IMPLEMENTATION_DEFINED_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VARIABLE
  public static boolean variable_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_term")) return false;
    if (!nextTokenIsSmart(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, VARIABLE);
    exit_section_(b, m, VARIABLE_TERM, r);
    return r;
  }

}

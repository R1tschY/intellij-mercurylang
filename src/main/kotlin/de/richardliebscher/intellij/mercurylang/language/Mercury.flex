// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package de.richardliebscher.intellij.mercurylang.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes;

%%

%class MercuryLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE = [\u0020\u0009-\u000D]+

LINE_COMMENT = "%" .*
BLOCK_COMMENT = "/*" ([^*] | \*+[^*/])* (\*+ "/")?

IDENT = [a-z][a-zA-Z_0-9]* | \' ( [^\\\'] | \\[^] | \'\' )* \'?
VARIABLE = [A-Z_][a-zA-Z_0-9]*
IMPLEMENTATION_DEFINED_LITERAL = "$" [a-z][a-zA-Z_0-9]*

STRING = \" ( [^\\\"] | \\[^] | \"\" )* \"?

FLOAT = [0-9]+ ({FRATION_PART} {EXPONENT}? | {EXPONENT})
FRATION_PART = "." [0-9]+
EXPONENT = [Ee] [+-]? [0-9]+

INT_SUFFIX = [iu] ("8" | "16" | "32" | "64")?
INTEGER = ({DEC_LITERAL}
  | {HEX_LITERAL}
  | {OCT_LITERAL}
  | {BIN_LITERAL} ) {INT_SUFFIX}?

DEC_LITERAL = [0-9] [0-9_]*
HEX_LITERAL = "0x" [a-fA-F0-9_]*
OCT_LITERAL = "0o" [0-7_]*
BIN_LITERAL = "0b" [01_]*

%%

<YYINITIAL> {
    "."                                { return MercuryTypes.DOT; } // yfx               10
    "!"                                { return MercuryTypes.EXCLAMATION; } // fx                40
//    "!."                               { return MercuryTypes.NAME; } // fx                40
//    "!:"                               { return MercuryTypes.NAME; } // fx                40
//    "@"                                { return MercuryTypes.NAME; } // xfx               90
//    "^"                                { return MercuryTypes.NAME; } // xfy               99
//    "^"                                { return MercuryTypes.NAME; } // fx                100
//    "event"                            { return MercuryTypes.NAME; } // fx                100
//    ":"                                { return MercuryTypes.NAME; } // yfx               120
//    "`op`"                             { return MercuryTypes.NAME; } // yfx               120
//    "**"                               { return MercuryTypes.NAME; } // xfy               200
//    "-"                                { return MercuryTypes.NAME; } // fx                200
//    "\\"                               { return MercuryTypes.NAME; } // fx                200
    "*"                                { return MercuryTypes.STAR; } // yfx               400
    "/"                                { return MercuryTypes.SLASH; } // yfx               400
    "//"                               { return MercuryTypes.SLASHSLASH; } // yfx               400
    "<<"                               { return MercuryTypes.LEFT_SHIFT; } // yfx               400
    ">>"                               { return MercuryTypes.RIGHT_SHIFT; } // yfx               400
    "div"                              { return MercuryTypes.DIV; } // yfx               400
    "mod"                              { return MercuryTypes.MOD; } // xfx               400
    "rem"                              { return MercuryTypes.REM; } // xfx               400
//    "for"                              { return MercuryTypes.NAME; } // xfx               500
    "+"                                { return MercuryTypes.PLUS; } // fx,yfx                500
    "++"                               { return MercuryTypes.PLUS_PLUS; } // xfy               500
    "-"                                { return MercuryTypes.MINUS; } // fx,yfx               500
    "--"                               { return MercuryTypes.MINUS_MINUS; } // yfx               500
    "/\\"                              { return MercuryTypes.BOOL_AND; } // yfx               500
    "\\/"                              { return MercuryTypes.BOOL_OR; } // yfx               500
//    ".."                               { return MercuryTypes.NAME; } // xfx               550
//    ":="                               { return MercuryTypes.NAME; } // xfx               650
//    "=^"                               { return MercuryTypes.NAME; } // xfx               650
//    "<"                                { return MercuryTypes.NAME; } // xfx               700
    "="                                { return MercuryTypes.EQUAL; } // xfx               700
//    "=.."                              { return MercuryTypes.NAME; } // xfx               700
//    "=:="                              { return MercuryTypes.NAME; } // xfx               700
    "=<"                               { return MercuryTypes.EQUAL_LESS; } // xfx               700
    "=="                               { return MercuryTypes.DOUBLE_EQUAL; } // xfx               700
//    "=\\="                             { return MercuryTypes.NAME; } // xfx               700
//    ">"                                { return MercuryTypes.NAME; } // xfx               700
//    ">="                               { return MercuryTypes.NAME; } // xfx               700
//    "@<"                               { return MercuryTypes.NAME; } // xfx               700
//    "@=<"                              { return MercuryTypes.NAME; } // xfx               700
//    "@>"                               { return MercuryTypes.NAME; } // xfx               700
//    "@>="                              { return MercuryTypes.NAME; } // xfx               700
    "\\="                              { return MercuryTypes.SLASH_EQUAL; } // xfx               700
//    "\\=="                             { return MercuryTypes.NAME; } // xfx               700
//    "~="                               { return MercuryTypes.NAME; } // xfx               700
    "is"                               { return MercuryTypes.IS; } // xfx               701
//    "and"                              { return MercuryTypes.NAME; } // xfy               720
//    "or"                               { return MercuryTypes.NAME; } // xfy               740
//    "func"                             { return MercuryTypes.NAME; } // fx                800
//    "impure"                           { return MercuryTypes.NAME; } // fy                800
    "pred"                             { return MercuryTypes.PRED; } // fx                800
//    "semipure"                         { return MercuryTypes.NAME; } // fy                800
    "\\+"                              { return MercuryTypes.SLASH_PLUS; } // fy                900
    "not"                              { return MercuryTypes.NOT; } // fy                900
//    "when"                             { return MercuryTypes.NAME; } // xfx               900
//    "~"                                { return MercuryTypes.NAME; } // fy                900
    "<="                               { return MercuryTypes.REVERSE_IMPLICATION; } // xfy               920
    "<=>"                              { return MercuryTypes.LOGICAL_EQUIVALENCE; } // xfy               920
    "=>"                               { return MercuryTypes.IMPLICATION; } // xfy               920
//    "all"                              { return MercuryTypes.NAME; } // fxy               950
//    "arbitrary"                        { return MercuryTypes.NAME; } // fxy               950
//    "atomic"                           { return MercuryTypes.NAME; } // fxy               950
//    "disable_warning"                  { return MercuryTypes.NAME; } // fxy               950
//    "disable_warnings"                 { return MercuryTypes.NAME; } // fxy               950
//    "promise_equivalent_solutions"     { return MercuryTypes.NAME; } // fxy               950
//    "promise_equivalent_solution_sets" { return MercuryTypes.NAME; } // fxy              950
//    "promise_exclusive"                { return MercuryTypes.NAME; } // fy                950
//    "promise_exclusive_exhaustive"     { return MercuryTypes.NAME; } // fy                950
//    "promise_exhaustive"               { return MercuryTypes.NAME; } // fy                950
//    "promise_impure"                   { return MercuryTypes.NAME; } // fx                950
//    "promise_pure"                     { return MercuryTypes.NAME; } // fx                950
//    "promise_semipure"                 { return MercuryTypes.NAME; } // fx                950
//    "require_complete_switch"          { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_det"          { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_semidet"      { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_multi"        { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_nondet"       { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_cc_multi"     { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_cc_nondet"    { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_erroneous"    { return MercuryTypes.NAME; } // fxy               950
//    "require_switch_arms_failure"      { return MercuryTypes.NAME; } // fxy               950
//    "require_det"                      { return MercuryTypes.NAME; } // fx                950
//    "require_semidet"                  { return MercuryTypes.NAME; } // fx                950
//    "require_multi"                    { return MercuryTypes.NAME; } // fx                950
//    "require_nondet"                   { return MercuryTypes.NAME; } // fx                950
//    "require_cc_multi"                 { return MercuryTypes.NAME; } // fx                950
//    "require_cc_nondet"                { return MercuryTypes.NAME; } // fx                950
//    "require_erroneous"                { return MercuryTypes.NAME; } // fx                950
//    "require_failure"                  { return MercuryTypes.NAME; } // fx                950
//    "trace"                            { return MercuryTypes.NAME; } // fxy               950
//    "try"                              { return MercuryTypes.NAME; } // fxy               950
//    "some"                             { return MercuryTypes.NAME; } // fxy               950
    ","                                { return MercuryTypes.COMMA; } // xfy               1000
    "&"                                { return MercuryTypes.AND; } // xfy               1025
//    "->"                               { return MercuryTypes.NAME; } // xfy               1050
    ";"                                { return MercuryTypes.SEMICOLON; } // xfy               1100
//    "or_else"                          { return MercuryTypes.NAME; } // xfy               1100
//    "then"                             { return MercuryTypes.NAME; } // xfx               1150
//    "if"                               { return MercuryTypes.NAME; } // fx                1160
//    "else"                             { return MercuryTypes.NAME; } // xfy               1170
    "::"                               { return MercuryTypes.COLONCOLON; } // xfx               1175
//    "==>"                              { return MercuryTypes.NAME; } // xfx               1175
//    "where"                            { return MercuryTypes.NAME; } // xfx               1175
    "--->"                             { return MercuryTypes.THREE_DASH_ARROW; } // xfy               1179
//    "catch"                            { return MercuryTypes.NAME; } // xfy               1180
    "type"                             { return MercuryTypes.TYPE; }   // fx  1180
    "solver"                           { return MercuryTypes.SOLVER; } // fy  1181
//    "catch_any"                        { return MercuryTypes.NAME; } // xfy               1190
    "end_module"                       { return MercuryTypes.END_MODULE; } // fx                1199
    "import_module"                    { return MercuryTypes.IMPORT_MODULE; } // fx                1199
    "include_module"                   { return MercuryTypes.INCLUDE_MODULE; } // fx                1199
    "initialise"                       { return MercuryTypes.INITIALISE; } // fx                1199
//    "initialize"                       { return MercuryTypes.NAME; } // fx                1199
    "finalise"                         { return MercuryTypes.FINALISE; } // fx                1199
//    "finalize"                         { return MercuryTypes.NAME; } // fx                1199
    "inst"                             { return MercuryTypes.INST; } // fx                1199
    "instance"                         { return MercuryTypes.INSTANCE; } // fx                1199
    "mode"                             { return MercuryTypes.MODE; } // fx                1199
    "module"                           { return MercuryTypes.MODULE; } // fx                1199
    "pragma"                           { return MercuryTypes.PRAGMA; } // fx                1199
    "promise"                          { return MercuryTypes.PROMISE; } // fx                1199
//    "rule"                             { return MercuryTypes.NAME; } // fx                1199
    "typeclass"                        { return MercuryTypes.TYPECLASS; } // fx                1199
    "use_module"                       { return MercuryTypes.USE_MODULE; } // fx                1199
    "-->"                              { return MercuryTypes.TWO_DASH_ARROW; } // xfx               1200
    ":-"                               { return MercuryTypes.COLON_MINUS; } // fx/xfx                1200
//    "?-"                               { return MercuryTypes.NAME; } // fx                1200

    // Braces
    "("                                { return MercuryTypes.OPEN; }
    ")"                                { return MercuryTypes.CLOSE; }
    "{"                                { return MercuryTypes.OPEN_CURLY; }
    "}"                                { return MercuryTypes.CLOSE_CURLY; }
    "["                                { return MercuryTypes.OPEN_LIST; }
    "]"                                { return MercuryTypes.CLOSE_LIST; }

    //
    "|"                                { return MercuryTypes.HT_SEP; }
    "." ({WHITE_SPACE} | <<eof>>)      { return MercuryTypes.PERIOD; }
    "true"                             { return MercuryTypes.TRUE; }
    "fail"                             { return MercuryTypes.FAIL; }

    // Decls
    "interface"                        { return MercuryTypes.INTERFACE; }
    "implementation"                   { return MercuryTypes.IMPLEMENTATION; }
    "func"                             { return MercuryTypes.FUNC; }
    "mutable"                          { return MercuryTypes.MUTABLE; }

    // Determinism categories: https://mercurylang.org/information/doc-release/mercury_ref/Determinism-categories.html#Determinism-categories
//    "det"                              { return MercuryTypes.DET; }
//    "semidet"                          { return MercuryTypes.SEMIDET; }
//    "multi"                            { return MercuryTypes.MULTI; }
//    "nondet"                           { return MercuryTypes.NONDET; }
//    "cc_multi"                         { return MercuryTypes.MULTI; }
//    "cc_nondet"                        { return MercuryTypes.NONDET; }
//    "failure"                          { return MercuryTypes.FAILURE; }
//    "erroneous"                        { return MercuryTypes.ERRONEOUS; }

    {IDENT}                            { return MercuryTypes.IDENT; }
    {STRING}                           { return MercuryTypes.STRING; }
    {FLOAT}                            { return MercuryTypes.FLOAT; }
    {INTEGER}                          { return MercuryTypes.INTEGER; }
    {VARIABLE}                         { return MercuryTypes.VARIABLE; }
    {IMPLEMENTATION_DEFINED_LITERAL}   { return MercuryTypes.IMPLEMENTATION_DEFINED_LITERAL; }

    {BLOCK_COMMENT}                    { return MercuryTypes.BLOCK_COMMENT; }
    {LINE_COMMENT}                     { return MercuryTypes.LINE_COMMENT; }

    {WHITE_SPACE}                      { return TokenType.WHITE_SPACE; }
}

[^]                                    { return TokenType.BAD_CHARACTER; }
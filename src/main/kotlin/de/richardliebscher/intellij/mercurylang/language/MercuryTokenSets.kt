package de.richardliebscher.intellij.mercurylang.language

import com.intellij.psi.tree.TokenSet
import de.richardliebscher.intellij.mercurylang.language.psi.MercuryTypes.*


val IDENTIFIERS = TokenSet.create(VARIABLE, IDENT)

val KEYWORDS = TokenSet.create(
    TYPE,
    SOLVER,
    PRED,
    FUNC,
    INST,
    MODE,
    TYPECLASS,
    INSTANCE,
    PRAGMA,
    PROMISE,
    INITIALISE,
    FINALISE,
    MUTABLE,
    MODULE,
    INTERFACE,
    IMPLEMENTATION,
    IMPORT_MODULE,
    USE_MODULE,
    INCLUDE_MODULE,
    END_MODULE)

//val DETERMINISM_CATEGORY = TokenSet.create(DET, SEMIDET, MULTI, NONDET, FAILURE, ERRONEOUS)

val OPERATORS = TokenSet.create(
    HT_SEP, SEMICOLON, DOUBLE_EQUAL, EQUAL_LESS,
    COMMA, HT_SEP, STAR, SLASH, SLASHSLASH, LEFT_SHIFT, RIGHT_SHIFT,
    DIV, MOD, REM, COLON_MINUS, TWO_DASH_ARROW, THREE_DASH_ARROW, COLONCOLON, EXCLAMATION)

val COMMENTS = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT)

val PARENTHESES = TokenSet.create(OPEN, CLOSE)
val BRACES = TokenSet.create(OPEN_CURLY, CLOSE_CURLY)
val BRACKETS = TokenSet.create(OPEN_LIST, CLOSE_LIST)
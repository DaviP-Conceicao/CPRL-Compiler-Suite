/**
 * Gramática léxica da linguagem de mensagens.
 *
 * Desenvolvido por Prof. Dr. David Buzatto
 */
lexer grammar MensagensLexer;

// ============================================================
// Modo padrão (DEFAULT_MODE) — tokenização das mensagens de texto
// ============================================================

NEG_ESQ : '[b]'  ;
NEG_DIR : '[/b]' ;
ITA_ESQ : '[i]'  ;
ITA_DIR : '[/i]' ;
COR_ESQ : '[c ' NUM_HEX ']';
COR_DIR : '[/c]' ;

// tokens de abertura dos comandos de desenho; ao serem reconhecidos,
// o lexer entra em MODO_DESENHO, onde espaços são ignorados e os
// parâmetros são tokenizados individualmente
CMD_PONTO_INI     : '[ponto'     -> pushMode(MODO_DESENHO) ;
CMD_LINHA_INI     : '[linha'     -> pushMode(MODO_DESENHO) ;
CMD_RETANGULO_INI : '[retangulo' -> pushMode(MODO_DESENHO) ;
CMD_CIRCULO_INI   : '[circulo'   -> pushMode(MODO_DESENHO) ;
CMD_COR_INI       : '[cor'       -> pushMode(MODO_DESENHO) ;

STRING : CHAR+ ;
CHAR   : ~["\\\r\n\][] ; // qualquer coisa menos ", \, \r, \n, ] e [

// regras auxiliares (fragment): não produzem tokens por si mesmas; são usadas
// apenas como blocos internos de outras regras léxicas. Sem fragment, o ANTLR
// as trataria como regras capazes de emitir tokens independentes, o que poderia
// interferir na tokenização correta de COR_ESQ.
fragment NUM_HEX : '#' DIG_HEX DIG_HEX DIG_HEX DIG_HEX DIG_HEX DIG_HEX;
fragment DIG_HEX : [0-9A-Fa-f] ;

// ============================================================
// MODO_DESENHO — ativo entre o início e o /] de cada comando;
// neste modo espaços são separadores (ignorados) e os parâmetros
// são tokenizados individualmente, acessíveis na árvore sintática
// ============================================================

mode MODO_DESENHO;

// fecha o comando e retorna ao modo padrão
CMD_FIM     : '/]'        -> popMode ;

// parâmetro inteiro com sinal opcional (coordenadas podem ser negativas)
NUM_INT     : '-'? [0-9]+ ;

// parâmetro de cor no formato #RRGGBB; usa o fragment NUM_HEX do modo padrão,
// pois fragments são compartilhados entre todos os modos
NUM_HEX_TOK : NUM_HEX ;

// espaços são separadores neste modo; ignorados pelo lexer
// (efeito colateral positivo: múltiplos espaços entre parâmetros também são aceitos)
SEP         : ' '         -> skip ;

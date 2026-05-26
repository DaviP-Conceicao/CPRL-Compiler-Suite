/**
 * Gramática da linguagem de mensagens.
 * 
 * Desenvolvido por Prof. Dr. David Buzatto
 */
grammar Mensagens;

// regras do analisador sintático

// mensagem+ permite que a entrada seja composta por múltiplas mensagens
// adjacentes no nível raiz, como [b]olá[/b][i]mundo[/i] ou [b]olá[/b] mundo
inicio   : mensagem+ EOF;

mensagem : NEG_ESQ  mensagem  NEG_DIR   # mensagemNegrito
         | ITA_ESQ  mensagem  ITA_DIR   # mensagemItalico
         | COR_ESQ  mensagem  COR_DIR   # mensagemCor
         | texto    mensagem*           # partes
         ;

texto    : STRING ;

// regras do analisador léxico
NEG_ESQ : '[b]'  ;
NEG_DIR : '[/b]' ;
ITA_ESQ : '[i]'  ;
ITA_DIR : '[/i]' ;
COR_ESQ : '[c ' NUM_HEX ']';
COR_DIR : '[/c]' ;

STRING : CHAR+ ;
CHAR   : ~["\\\r\n\][] ; // qualquer coisa menos ", \, \r, \n, ] e [

// regras auxiliares (fragment): não produzem tokens por si mesmas; são usadas
// apenas como blocos internos de outras regras léxicas. Sem fragment, o ANTLR
// as trataria como regras capazes de emitir tokens independentes, o que poderia
// interferir na tokenização correta de COR_ESQ.
fragment NUM_HEX : '#' DIG_HEX DIG_HEX DIG_HEX DIG_HEX DIG_HEX DIG_HEX;
fragment DIG_HEX : [0-9A-Fa-f] ;

// ignora espaços em branco -> como são mensagens, não vamos ignorar
//WS  : [ \t\r\n]+ -> skip ;
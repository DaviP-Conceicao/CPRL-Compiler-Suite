/**
 * Gramática sintática da linguagem de mensagens.
 *
 * Desenvolvido por Prof. Dr. David Buzatto
 */
parser grammar MensagensParser;

// importa o vocabulário de tokens gerado pela gramática léxica; o ANTLR
// lê o arquivo MensagensLexer.tokens para reconhecer todos os símbolos
// definidos no lexer sem precisar duplicá-los aqui
options { tokenVocab=MensagensLexer; }

// regras do analisador sintático

// mensagem+ permite que a entrada seja composta por múltiplas mensagens
// adjacentes no nível raiz, como [b]olá[/b][i]mundo[/i] ou [b]olá[/b] mundo
inicio   : mensagem+ EOF;

mensagem : NEG_ESQ  mensagem  NEG_DIR   # mensagemNegrito
         | ITA_ESQ  mensagem  ITA_DIR   # mensagemItalico
         | COR_ESQ  mensagem  COR_DIR   # mensagemCor
         | texto    mensagem*           # partes
         | desenho                      # mensagemDesenho
         ;

texto    : STRING ;

// regra intermediária que agrupa os comandos de desenho; cada alternativa
// expõe os parâmetros como tokens individuais acessíveis no visitor/listener
// via ctx.NUM_INT(i) e ctx.NUM_HEX_TOK()
desenho : CMD_PONTO_INI     NUM_INT NUM_INT                 CMD_FIM   # desenhoPonto
        | CMD_LINHA_INI     NUM_INT NUM_INT NUM_INT NUM_INT CMD_FIM   # desenhoLinha
        | CMD_RETANGULO_INI NUM_INT NUM_INT NUM_INT NUM_INT CMD_FIM   # desenhoRetangulo
        | CMD_CIRCULO_INI   NUM_INT NUM_INT NUM_INT         CMD_FIM   # desenhoCirculo
        | CMD_COR_INI       NUM_HEX_TOK                     CMD_FIM   # desenhoCor
        ;

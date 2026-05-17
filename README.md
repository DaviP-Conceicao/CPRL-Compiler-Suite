# 🚀 Compilador Completo CPRL 🛠️



Um sistema compilador completo desenvolvido de forma modular e incremental para a linguagem **CPRL**, traduzindo o código de alto nível para a linguagem Assembly da **CVM (CPRL Virtual Machine)**.

---

## 🗺️ Desenvolvimento Passo a Passo

### 📁 Projeto 01 - Scanner (Análise Léxica) 🔍
*O "Dicionário" do Compilador: Lê o código caractere por caractere e agrupa tudo em palavras válidas (Tokens).*
* ⚡ **Comentários vs Divisão:** Aprendeu a "espiar" (`lookahead`) a próxima barra `/`. Se vir `//`, ignora a linha toda como comentário.
* ⚡ **Identificadores:** Lê palavras inteiras (ex: `minhaVar`) e consulta um dicionário interno para saber se é uma palavra reservada da linguagem (`if`, `while`, `int`).
* ⚡ **Símbolos Duplos:** Identifica operadores compostos como atribuição (`:=`) e menor-ou-igual (`<=`).
* ⚡ **Textos e Letras:** Captura perfeitamente Strings (`"Texto"`) e Chars (`'A'`), tratando caracteres de escape como `\n` e `\t`.

### 📁 Projeto 02 - Parser Inicial (Análise Sintática V1) 📐
*O "Professor de Gramática": Verifica se a ordem das palavras na frase faz sentido segundo as regras do CPRL.*
* ✨ **Descida Recursiva:** Cada regra da gramática virou um método Java que chama a si mesmo recursivamente.
* ✨ **Componentes de Apoio:** * `Source`: O cursor de leitura do ficheiro.
    * `IdTable`: A tabela onde guardamos os nomes de tudo o que foi criado.
    * `ErrorHandler`: O assistente que aponta a linha e a coluna exata de qualquer erro gramatical.

### 📁 Projeto 03 - Parser Avançado (Recuperação de Erros) 🛡️
*O Parser persistente: Ele não desiste no primeiro erro encontrado no código.*
* 🚀 **Conjuntos Follow:** Se o programador errar, o Parser avança até encontrar uma "palavra-âncora" segura para retomar a leitura.
* 🚀 **Análise Multierros:** Consegue listar dezenas de erros sintáticos num único ficheiro de uma só vez, em vez de travar a compilação logo na primeira falha.

### 📁 Projeto 04 - Parser & AST (Árvore Sintática Abstrata) 🌳
*O Construtor de Estruturas: Além de validar a gramática, agora ele desenha o mapa lógico do programa na memória.*
* 🌿 **Nós da Árvore:** Os métodos agora retornam objetos reais (ex: `parseIfStmt` gera um objeto `IfStmt`), limpando pontuações inúteis.
* 🌿 **Validação de Contexto:** A `IdTable` agora avisa se tentar usar uma variável que não existe.
* 🌿 **Regras de Fluxo:** O `LoopContext` proíbe o comando `exit` fora de laços, e o `SubprogramContext` proíbe o `return` fora de funções.

### 📁 Projeto 05 - Análise de Restrições (Análise Semântica) ⚖️
*O Fiscal da Lógica: Garante que o programa faz sentido real antes de virar código de máquina.*
* 🔮 **Método `checkConstraints()`:** Varre a árvore inteira aplicando as regras de negócio.
* 🔮 **Trava de Tipos:** Impede absurdos como misturar `Array` com `Integer`, garante que condições de `if`/`while` sejam estritamente booleanas e que o comando `read` só leia números ou letras.

### 📁 Projeto 06 - Geração de Código Base (CPRL/0) ⚙️
*A Tradução Inicial: Transforma a lógica básica em instruções Assembly escritas num ficheiro `.asm`.*
* 💎 **Arquitetura de Pilha:** Os dados entram e saem da pilha (*Stack*) de forma pós-fixada para realizar contas matematicas.
* 💎 **Emissão de Opcodes:** Escreve automaticamente no ficheiro de saída as instruções nativas de máquina, como `MUL`, `DIV`, `NEG`, `NOT` e `PUTEOL`.

### 📁 Projeto 07 - Geração de Código Avançada (Arrays e Subprogramas) 👑
*A Consolidação Máxima: O compilador ganha superpoderes para lidar com as estruturas mais complexas de memória.*
* 📌 **Indexação de Arrays:** Através da instrução `INDEX`, calcula em tempo real o endereço exato da gaveta do Array (`endereço base + (índice × tamanho)`).
* 📌 **Subprogramas Dinâmicos:** Controla com cirurgia o fluxo de funções e procedimentos recursivos na pilha:
    * `PROC`: Abre espaço local na memória e gera um rótulo (*Label* como `L0:`).
    * `CALL`: Despacha os parâmetros para a pilha e salta para o subprograma.
    * `RET`: Limpa toda a memória usada temporariamente e volta ao ponto de partida, prevenindo vazamentos de memória (*Stack Overflow*).

---

## 🛠️ Tecnologias Utilizadas

* ☕ **Linguagem:** Java 8+
* 🏗️ **Automação/Build:** Apache Ant
* 🧪 **Testes:** JUnit 4 & Suite em Lote (`Corretor.java`)
* 🖥️ **Máquina Alvo:** CVM (CPRL Virtual Machine)

---

## 📈 Como Executar e Testar

1.  **Construir o Projeto:** Execute `Clean and Build` (via Ant no NetBeans/IntelliJ ou Terminal).
2.  **Correr os Testes:** Execute a classe `test.cprl.Corretor` para validar os ficheiros de teste.
3.  **Resultado:** O sistema gera logs automáticos exibindo `### Teste [Nome] ok! ###` e gerando o código binário `.obj` e texto `.asm` correspondentes!

---

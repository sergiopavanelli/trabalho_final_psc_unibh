# Trabalho Final - Programação de Soluções Computacionais

## Sistema de Gerenciamento de Doações

## Alunos:

- Sérgio Pinton Pavanelli – RA 123220202
- Klaus Boger Tolentino Juliani - RA 1232020299

## 1. Proposta de Problema

Criação de um sistema de gerenciamento de doações para ajudar as vítimas de uma enchente no Rio Grande do Sul. O sistema deve ser capaz de realizar as seguintes funções:

- **Receber Doações:** Permitir que os doadores informem os detalhes da doação, como tipo (dinheiro, alimentos, roupas etc.), quantidade e data.
- **Calcular Total de Doações:** Somar todas as doações recebidas e apresentar o total em uma interface fácil de entender.
- **Armazenar Informações de Doações:** Armazenar todas as informações sobre as doações em um banco de dados ou arquivo texto para recuperação e análise posterior.

Este projeto aplica os conhecimentos adquiridos na disciplina de Programação de Soluções Computacionais e contribui para uma causa social importante. A utilização de IA Generativa no desenvolvimento do sistema permite explorar as possibilidades desses softwares no desenvolvimento de sistemas.

## 2. Requisitos Funcionais

1. **Tela de entrada de doações com campos para tipo, quantidade e data.**
2. **Validação de dados de entrada.**
3. **Função para calcular e exibir o total de doações.**
4. **Armazenamento das doações em um banco de dados ou arquivo texto.**
5. **Função para recuperação e exibição de doações armazenadas.**
6. **Tratamento de exceções para garantir a integridade dos dados.**
7. **Interface amigável para visualização e interação com os dados.**

## 3. Crítica à IA

A IA foi fundamental na decomposição do problema em requisitos funcionais. Embora útil na geração de ideias, é necessário analisar criticamente as sugestões para garantir a consistência e a precisão dos requisitos.

Utilizando a bibliografia abaixo, foi possível analisar de forma crítica o uso da IA na resolução deste problema, chegando à conclusão de que a intervenção humana foi crucial para ajustar e refinar o sistema, garantindo que todos os aspectos do projeto fossem abordados de maneira completa e eficaz. 

# Bibliografia: #

- Pressman, R. S. (2014). Software Engineering: A Practitioner's Approach. McGraw-Hill.



## 4. Diagrama de Classes

### Classe: `Doacao`
**Propriedades:**
- `tipo: String` - Tipo de doação (dinheiro, alimentos, roupas, etc.).
- `quantidade: double` - Quantidade doada.
- `data: LocalDateTime` - Data da doação.

**Métodos:**
- `getTipo(): String` - Retorna o tipo de doação.
- `getQuantidade(): double` - Retorna a quantidade da doação.
- `getData(): LocalDateTime` - Retorna a data da doação.
- `setTipo(String tipo)` - Define o tipo de doação.
- `setQuantidade(double quantidade)` - Define a quantidade da doação.
- `setData(LocalDateTime data)` - Define a data da doação.
- `toString(): String` - Retorna uma representação em string da doação.

### Classe: `SistemaDeDoacoes`
**Propriedades:**
- `doacoes: List<Doacao>` - Lista de doações registradas.
- `totalDinheiro: double` - Total de doações em dinheiro.
- `totalAlimentos: double` - Total de doações em alimentos.
- `totalRoupas: double` - Total de doações em roupas.
- `totalOutras: double` - Total de doações em outras categorias.

**Métodos:**
- `adicionarDoacao(Doacao doacao)` - Adiciona uma nova doação à lista.
- `calcularTotalDoacoes(): double` - Calcula o total das doações.
- `salvarDoacoes()` - Salva as doações em um arquivo texto.
- `carregarDoacoes()` - Carrega as doações de um arquivo texto.
- `carregarTotaisArmazenados()` - Carrega os totais acumulados do arquivo de log.
- `exibirDoacoes()` - Exibe as doações registradas.
- `calcularTotaisPorTipo()` - Calcula os totais de doações por tipo.
- `exibirTotaisPorTipo()` - Exibe os totais de doações por tipo.
- `logDoacao(Doacao doacao)` - Registra a doação no log.

### Classe: `EntradaDeDoacoes`
**Métodos:**
- `main(String[] args)` - Método principal que inicializa o sistema e apresenta o menu de opções.
- `obterTipoDoacao(): String` - Obtém o tipo de doação a partir da entrada do usuário.
- `adicionarDoacao()` - Adiciona uma nova doação com base na entrada do usuário.
- `calcularTotalDoacoes()` - Calcula e exibe o total de doações.
- `salvarDoacoes()` - Salva as doações em um arquivo.
- `carregarDoacoes()` - Carrega as doações de um arquivo.

### Classe: `ExceptionHandler`
**Métodos:**
- `handle(Exception e, String message)` - Lida com exceções gerais e imprime uma mensagem.
- `handleNumberFormatException(NumberFormatException e)` - Lida com exceções de formatação numérica.
- `handleIOException(IOException e)` - Lida com exceções de I/O.
- `handleGenericException(Exception e)` - Lida com exceções genéricas.

### Relação entre as Classes
A classe `SistemaDeDoacoes` contém uma lista de objetos da classe `Doacao`. Cada doação registrada é um objeto `Doacao` armazenado dentro do `SistemaDeDoacoes`. O método `adicionarDoacao` permite adicionar novas doações à lista, enquanto `calcularTotalDoacoes` percorre essa lista para somar os valores. Os métodos `salvarDoacoes` e `carregarDoacoes` gerenciam a persistência das doações em arquivos texto, permitindo que os dados sejam armazenados e recuperados conforme necessário. A classe `EntradaDeDoacoes` atua como ponto de entrada do sistema, permitindo a interação do usuário com as funcionalidades de gerenciamento de doações.

## 5. Estratégia de Programação com IA
- A classe `EntradaDeDoacoes` atua como ponto de entrada do sistema, permitindo a interação do usuário com as funcionalidades de gerenciamento de doações. O programa oferece um menu intuitivo que guia o usuário nas opções disponíveis, proporcionando uma experiência amigável e de fácil utilização.
- As funcionalidades de adição, cálculo e exibição de doações são acionadas de forma adequada através do menu, garantindo uma interação fluída e coerente com o sistema.
- A estratégia de programação adotada demonstra eficácia na integração das funcionalidades do sistema com a interface de usuário, proporcionando uma experiência de uso satisfatória.

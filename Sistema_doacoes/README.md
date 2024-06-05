# Trabalho Final - Programação de Soluções Computacionais

## Alunos:
- Sérgio Pinton Pavanelli – RA 123220202
- Klaus Boger Tolentino Juliani - RA 122211902

## 1. Proposta de problema:
Criação de um sistema de gerenciamento de doações. Este sistema seria projetado para ajudar as vítimas de uma enchente no Rio Grande do Sul. O sistema deve ser capaz de realizar as seguintes funções:

a. **Receber Doações:** O sistema deve ter uma tela com entradas onde os doadores possam informar os detalhes da doação, como o tipo de doação (dinheiro, alimentos, roupas etc.), a quantidade e a data da doação.

b. **Calcular Total de Doações:** O sistema deve ser capaz de calcular o total de doações recebidas. Deve haver uma função que some todas as doações e apresente o total em uma interface fácil de entender.

c. **Armazenar Informações de Doações:** Todas as informações sobre as doações devem ser armazenadas em um banco de dados ou arquivo texto. Isso permitirá que as informações sejam recuperadas e analisadas posteriormente.

A implementação deste sistema permitirá que os estudantes apliquem os conhecimentos adquiridos na disciplina de Programação de Soluções Computacionais e contribuirá para uma causa social importante. Além disso, o uso de uma IA Generativa no processo de desenvolvimento do sistema permitirá que os estudantes explorem as possibilidades de uso desses softwares no desenvolvimento de sistemas.

## 2. Requisitos Funcionais:

1. **Tela de entrada de doações com campos para tipo, quantidade e data.**
2. **Validação de dados de entrada.**
3. **Função para calcular e exibir o total de doações.**
4. **Armazenamento das doações em um banco de dados ou arquivo texto.**
5. **Função para recuperação e exibição de doações armazenadas.**
6. **Tratamento de exceções para garantir a integridade dos dados.**
7. **Interface amigável para visualização e interação com os dados.**

## 3. Crítica à IA:
A IA desempenhou um papel fundamental na decomposição do problema em requisitos funcionais. Embora tenha sido útil na geração de ideias, é importante destacar que a análise crítica das sugestões é necessária para garantir a consistência e a precisão dos requisitos identificados.

## 4. Diagrama de Classes:

### Classe: `Doacao`
- **Propriedades:**
  - `tipo: String` - Tipo de doação (dinheiro, alimentos, roupas, etc.).
  - `quantidade: double` - Quantidade doada.
  - `data: LocalDateTime` - Data da doação.

- **Métodos:**
  - `getTipo(): String` - Retorna o tipo de doação.
  - `getQuantidade(): double` - Retorna a quantidade da doação.
  - `getData(): LocalDateTime` - Retorna a data da doação.
  - `setTipo(String tipo)` - Define o tipo de doação.
  - `setQuantidade(double quantidade)` - Define a quantidade da doação.
  - `setData(LocalDateTime data)` - Define a data da doação.

### Classe: `SistemaDeDoacoes`
- **Propriedades:**
  - `doacoes: List<Doacao>` - Lista de doações registradas.

- **Métodos:**
  - `adicionarDoacao(Doacao doacao)` - Adiciona uma nova doação à lista.
  - `calcularTotalDoacoes(): double` - Calcula o total das doações.
  - `salvarDoacoes()` - Salva as doações em um arquivo texto.
  - `carregarDoacoes()` - Carrega as doações de um arquivo texto.
  - `exibirDoacoes()` - Exibe as doações registradas.
  - `calcularTotaisPorTipo()` - Calcula os totais de doações por tipo.
  - `exibirTotaisPorTipo()` - Exibe os totais de doações por tipo.

### Relação entre as Classes:
A classe `SistemaDeDoacoes` contém uma lista de objetos da classe `Doacao`. Cada doação registrada é um objeto `Doacao` armazenado dentro do `SistemaDeDoacoes`. O método `adicionarDoacao` permite adicionar novas doações à lista, enquanto `calcularTotalDoacoes` percorre essa lista para somar os valores. Os métodos `salvarDoacoes` e `carregarDoacoes` gerenciam a persistência das doações em arquivos texto, permitindo que os dados sejam armazenados e recuperados conforme necessário.

## 5. Estratégia de Programação com IA:
- A classe `EntradaDeDoacoes` atua como ponto de entrada do sistema, permitindo a interação do usuário com as funcionalidades de gerenciamento de doações. O programa oferece um menu intuitivo que guia o usuário nas opções disponíveis, proporcionando uma experiência amigável e de fácil utilização.

- As funcionalidades de adição, cálculo e exibição de doações são acionadas de forma adequada através do menu, garantindo uma interação fluída e coerente com o sistema.

- A estratégia de programação adotada demonstra eficácia na integração das funcionalidades do sistema com a interface de usuário, proporcionando uma experiência de uso satisfatória.

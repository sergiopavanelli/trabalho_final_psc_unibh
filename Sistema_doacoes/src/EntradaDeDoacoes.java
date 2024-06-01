import java.util.Scanner;

public class EntradaDeDoacoes {
    private static SistemaDeDoacoes sistema = new SistemaDeDoacoes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Doação");
            System.out.println("2. Calcular Total de Doações");
            System.out.println("3. Salvar Doações");
            System.out.println("4. Carregar Doações");
            System.out.println("5. Exibir Doações");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarDoacao();
                    break;
                case 2:
                    calcularTotalDoacoes();
                    sistema.exibirTotaisPorTipo();
                    break;
                case 3:
                    salvarDoacoes();
                    break;
                case 4:
                    carregarDoacoes();
                    break;
                case 5:
                    sistema.exibirDoacoes();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String obterTipoDoacao() {
        while (true) {
            System.out.println("Escolha o tipo de doação:");
            System.out.println("1. Dinheiro (R$)");
            System.out.println("2. Alimentos (kg)");
            System.out.println("3. Roupas (un.)");
            System.out.println("4. Outras (un.)");
            System.out.print("Digite o número correspondente ao tipo de doação: ");
            String tipo = "";
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    tipo = "dinheiro";
                    break;
                case 2:
                    tipo = "alimentos";
                    break;
                case 3:
                    tipo = "roupas";
                    break;
                case 4:
                    tipo = "outras";
                    break;
                default:
                    System.out.println("Opção inválida! Escolha entre 1, 2, 3 ou 4.");
                    continue;
            }
            return tipo;
        }
    }

    private static void adicionarDoacao() {
        try {
            String tipo = obterTipoDoacao();
            String unidade = "";
            switch (tipo) {
                case "dinheiro":
                    unidade = "R$";
                    break;
                case "alimentos":
                    unidade = "kg";
                    break;
                case "roupas":
                    unidade = "unidades";
                    break;
                case "outras":
                    unidade = "unidades";
                    break;
            
                default:
                    break;
            }

            System.out.print("Digite a quantidade de doação em " + unidade + ": ");
            double quantidade = scanner.nextDouble();
            scanner.nextLine();
            Doacao doacao = new Doacao(tipo, quantidade);
            sistema.adicionarDoacao(doacao);
            System.out.println("Doação adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar doação!");
            e.printStackTrace();
        }
    }

    private static void calcularTotalDoacoes() {
        double total = sistema.calcularTotalDoacoes();
        System.out.println("Total de doações: " + total);
    }

    private static void salvarDoacoes() {
      
            sistema.salvarDoacoes();
            System.out.println("Doações salvas com sucesso!");
    
        }

    private static void carregarDoacoes() {
  
            sistema.carregarDoacoes();
            System.out.println("Doações carregadas com sucesso!");

        }
 
}

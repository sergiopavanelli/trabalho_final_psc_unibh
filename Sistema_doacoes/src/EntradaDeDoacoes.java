import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

// Classe Doacao precisa ser definida antes de compilar e executar este código

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
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    adicionarDoacao();
                    break;
                case 2:
                    calcularTotalDoacoes();
                    break;
                case 3:
                    salvarDoacoes();
                    break;
                case 4:
                    carregarDoacoes();
                    break;
                case 5:
                    exibirDoacoes();
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
            System.out.println("1. Dinheiro");
            System.out.println("2. Alimentos");
            System.out.println("3. Roupas");
            System.out.println("4. Outras");
            System.out.print("Digite o número correspondente ao tipo de doação: ");
            String tipo = "";
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha
    
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
            System.out.print("Digite a quantidade de doação: ");
            double quantidade = scanner.nextDouble();
            scanner.nextLine();  // Consome a nova linha
            System.out.print("Digite a data da doação (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            Doacao doacao = new Doacao(tipo, quantidade, data); // Supondo que Doacao tenha um construtor correspondente
            sistema.adicionarDoacao(doacao);
            sistema.calcularTotaisPorTipo();
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

        try {
            System.out.print("Digite o caminho do arquivo para salvar as doações: ");
            String caminhoArquivo = scanner.nextLine();
            sistema.salvarDoacoes(caminhoArquivo);
            System.out.println("Doações salvas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar doações!");
            e.printStackTrace();
        }
    }

    private static void carregarDoacoes() {
        try {
            System.out.print("Digite o caminho do arquivo para carregar as doações: ");
            String caminhoArquivo = scanner.nextLine();
            sistema.carregarDoacoes(caminhoArquivo);
            System.out.println("Doações carregadas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar doações!");
            e.printStackTrace();
        }
    }

    private static void exibirDoacoes() {
        sistema.exibirDoacoes();
    }
}
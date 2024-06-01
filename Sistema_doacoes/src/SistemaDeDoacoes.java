import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeDoacoes {
    private List<Doacao> doacoes;
    private static final String DATA_FILE = "doacoes.txt";
    private static final String LOG_FILE = "log.txt";
    
    private double totalDinheiro = 0;
    private double totalAlimentos = 0;
    private double totalRoupas = 0;
    private double totalOutras = 0;

    public SistemaDeDoacoes() {
        doacoes = new ArrayList<>();
        carregarDoacoes();
        carregarTotaisArmazenados(); // Carrega os totais acumulados do arquivo ao iniciar
    }

    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
        salvarDoacoes();
        calcularTotaisPorTipo();
        logDoacao(doacao);
    }
    

    public double calcularTotalDoacoes() {
        double total = 0;
        for (Doacao doacao : doacoes) {
            total += doacao.getQuantidade();
        }
        return total;
    }

    public void salvarDoacoes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Doacao doacao : doacoes) {
                writer.write(doacao.getTipo() + "," + doacao.getQuantidade() + "," + doacao.getData().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDoacoes() {
        doacoes.clear(); // Limpa as doações anteriores antes de carregar novas
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                double quantidade = Double.parseDouble(partes[1]);
                doacoes.add(new Doacao(tipo, quantidade));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarTotaisArmazenados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Dinheiro: ")) {
                    totalDinheiro = Double.parseDouble(linha.split(": ")[1]);
                } else if (linha.startsWith("Alimentos: ")) {
                    totalAlimentos = Double.parseDouble(linha.split(": ")[1]);
                } else if (linha.startsWith("Roupas: ")) {
                    totalRoupas = Double.parseDouble(linha.split(": ")[1]);
                } else if (linha.startsWith("Outras: ")) {
                    totalOutras = Double.parseDouble(linha.split(": ")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibirDoacoes() {
        for (Doacao doacao : doacoes) {
            System.out.println(doacao);
        }
    }

    public void calcularTotaisPorTipo() {
        totalDinheiro = 0;
        totalAlimentos = 0;
        totalRoupas = 0;
        totalOutras = 0;

        for (Doacao doacao : doacoes) {
            switch (doacao.getTipo()) {
                case "dinheiro":
                    totalDinheiro += doacao.getQuantidade();
                    break;
                case "alimentos":
                    totalAlimentos += doacao.getQuantidade();
                    break;
                case "roupas":
                    totalRoupas += doacao.getQuantidade();
                    break;
                case "outras":
                    totalOutras += doacao.getQuantidade();
                    break;
            }
        }
    }

    public void exibirTotaisPorTipo() {
        System.out.println("Totais acumulados por tipo de doação:");
        System.out.println("Dinheiro: " + totalDinheiro);
        System.out.println("Alimentos: " + totalAlimentos);
        System.out.println("Roupas: " + totalRoupas);
        System.out.println("Outras: " + totalOutras);
    }

        private void logDoacao(Doacao doacao) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            logWriter.println(doacao.toString());
            logWriter.println("Totais acumulados no momento:");
            logWriter.println("Dinheiro: " + totalDinheiro);
            logWriter.println("Alimentos: " + totalAlimentos);
            logWriter.println("Roupas: " + totalRoupas);
            logWriter.println("Outras: " + totalOutras);
            logWriter.flush();
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo de log: " + e.getMessage());
        }
    }
    

}
    
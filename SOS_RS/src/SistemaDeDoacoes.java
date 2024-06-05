import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;



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
            ExceptionHandler.handleIOException(e);
        }
    }

    public void carregarDoacoes() {
        doacoes.clear(); // Limpa as doações anteriores antes de carregar novas
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                double quantidade = Double.parseDouble(partes[1].replace(",", "."));
                doacoes.add(new Doacao(tipo, quantidade));
            }
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        }
    }

    public void carregarTotaisArmazenados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Dinheiro: ")) {
                    totalDinheiro = Double.parseDouble(linha.split(": ")[1].replace(",", "."));
                } else if (linha.startsWith("Alimentos: ")) {
                    totalAlimentos = Double.parseDouble(linha.split(": ")[1].replace(",", "."));
                } else if (linha.startsWith("Roupas: ")) {
                    totalRoupas = Double.parseDouble(linha.split(": ")[1].replace(",", "."));
                } else if (linha.startsWith("Outras: ")) {
                    totalOutras = Double.parseDouble(linha.split(": ")[1].replace(",", "."));
                }
            }
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
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
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("- Totais acumulados por tipo de doação:");
        System.out.println("Dinheiro: " + df.format(totalDinheiro));
        System.out.println("Alimentos: " + df.format(totalAlimentos));
        System.out.println("Roupas: " + df.format(totalRoupas));
        System.out.println("Outras: " + df.format(totalOutras));
    }

        private void logDoacao(Doacao doacao) {
        DecimalFormat df = new DecimalFormat("0.00");
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            logWriter.println(doacao.toString());
            logWriter.println("Totais acumulados até o momento:");
            logWriter.println("Dinheiro: " + df.format(totalDinheiro));
            logWriter.println("Alimentos: " + df.format(totalAlimentos));
            logWriter.println("Roupas: " + df.format(totalRoupas));
            logWriter.println("Outras: " + df.format(totalOutras));
            logWriter.flush();
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        }
    }    

}
    
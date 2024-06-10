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

    private int countDinheiro = 0;
    private int countAlimentos = 0;
    private int countRoupas = 0;
    private int countOutras = 0;

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
        calcularTotaisPorTipo(); //atualiza os totais por tipo
        int totalDoacoes = countDinheiro + countAlimentos + countRoupas + countOutras;    
        return totalDoacoes;
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
                    String[] parts = linha.split(": ")[1].split(" ");
                    if (parts.length >= 3) {
                        totalDinheiro = Double.parseDouble(parts[0].replace(",", "."));
                        countDinheiro = Integer.parseInt(parts[2].replace("(", "").replace("doações)", ""));
                    }
                } else if (linha.startsWith("Alimentos: ")) {
                    String[] parts = linha.split(": ")[1].split(" ");
                    if (parts.length >= 3) {
                        totalAlimentos = Double.parseDouble(parts[0].replace(",", "."));
                        countAlimentos = Integer.parseInt(parts[2].replace("(", "").replace("doações)", ""));
                    }
                } else if (linha.startsWith("Roupas: ")) {
                    String[] parts = linha.split(": ")[1].split(" ");
                    if (parts.length >= 3) {
                        totalRoupas = Double.parseDouble(parts[0].replace(",", "."));
                        countRoupas = Integer.parseInt(parts[2].replace("(", "").replace("doações)", ""));
                    }
                } else if (linha.startsWith("Outras: ")) {
                    String[] parts = linha.split(": ")[1].split(" ");
                    if (parts.length >= 3) {
                        totalOutras = Double.parseDouble(parts[0].replace(",", "."));
                        countOutras = Integer.parseInt(parts[2].replace("(", "").replace("doações)", ""));
                    }
                }
            }
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleNumberFormatException(e);
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

        countDinheiro = 0;
        countAlimentos = 0;
        countRoupas = 0;
        countOutras = 0;

        for (Doacao doacao : doacoes) {
            switch (doacao.getTipo()) {
                case "dinheiro":
                    totalDinheiro += doacao.getQuantidade();
                    countDinheiro++;
                    break;
                case "alimentos":
                    totalAlimentos += doacao.getQuantidade();
                    countAlimentos++;
                    break;
                case "roupas":
                    totalRoupas += doacao.getQuantidade();
                    countRoupas++;
                    break;
                case "outras":
                    totalOutras += doacao.getQuantidade();
                    countOutras++;
                    break;
            }
        }
    }

    public void exibirTotaisPorTipo() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("- Totais acumulados por tipo de doação:");
        System.out.println("Dinheiro: " + df.format(totalDinheiro) + " (" + countDinheiro + " doações)");
        System.out.println("Alimentos: " + df.format(totalAlimentos) + " (" + countAlimentos + " doações)");
        System.out.println("Roupas: " + df.format(totalRoupas) + " (" + countRoupas + " doações)");
        System.out.println("Outras: " + df.format(totalOutras) + " (" + countOutras + " doações)");
    }
  
    

        private void logDoacao(Doacao doacao) {
        DecimalFormat df = new DecimalFormat("0.00");
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            logWriter.println(doacao.toString());
            logWriter.println("-- Total de doações até o momento: " + calcularTotalDoacoes() + " --");
            logWriter.println("Dinheiro: " + df.format(totalDinheiro) + " (" + countDinheiro + " doações)");
            logWriter.println("Alimentos: " + df.format(totalAlimentos) + " (" + countAlimentos + " doações)");
            logWriter.println("Roupas: " + df.format(totalRoupas) + " (" + countRoupas + " doações)");
            logWriter.println("Outras: " + df.format(totalOutras) + " (" + countOutras + " doações)");
            logWriter.println("------------------------------------------------------------------------------");
            logWriter.flush();
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        }
    }    

}
    
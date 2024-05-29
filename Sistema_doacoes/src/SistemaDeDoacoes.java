import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SistemaDeDoacoes {
    private List<Doacao> doacoes;
    private static final String LOG_FILE = "log.txt";

    // Construtor
    public SistemaDeDoacoes() {
        doacoes = new ArrayList<>();
    }

    // Método para adicionar uma nova doação
    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
        logDoacao(doacao);
        calcularTotaisPorTipo();
    }

    // Método para calcular o total das doações
    public double calcularTotalDoacoes() {
        double total = 0;
        for (Doacao doacao : doacoes) {
            total += doacao.getQuantidade();
        }
        return total;
    }

    // Método para salvar doações em um arquivo
    public void salvarDoacoes(String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Doacao doacao : doacoes) {
                writer.write(doacao.toString());
                writer.newLine();
            }
        }
    }

    // Método para carregar doações de um arquivo
    public void carregarDoacoes(String caminhoArquivo) throws IOException {
        doacoes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String tipo = dados[0].split("=")[1];
                double quantidade = Double.parseDouble(dados[1].split("=")[1]);
                Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dados[2].split("=")[1].replace("]", ""));
                doacoes.add(new Doacao(tipo, quantidade, data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para exibir todas as doações
    public void exibirDoacoes() {
        for (Doacao doacao : doacoes) {
            System.out.println(doacao);
        }
    }


        // Método para registrar doações no log
        private void logDoacao(Doacao doacao) {
            try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, true))) {
                logWriter.println(doacao.toString());
            } catch (IOException e) {
                System.err.println("Erro ao gravar no arquivo de log: " + e.getMessage());
            }
        }

    

public void calcularTotaisPorTipo() {
    double totalDinheiro = 0;
    double totalAlimentos = 0;
    double totalRoupas = 0;
    double totalOutras = 0;

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

    System.out.println("Totais acumulados por tipo de doação:");
    System.out.println("Dinheiro: " + totalDinheiro);
    System.out.println("Alimentos: " + totalAlimentos);
    System.out.println("Roupas: " + totalRoupas);
    System.out.println("Outras: " + totalOutras);
}

    
}
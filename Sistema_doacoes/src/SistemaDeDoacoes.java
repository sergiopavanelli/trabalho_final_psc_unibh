import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SistemaDeDoacoes {
    private List<Doacao> doacoes;
    private static final String LOG_FILE = "log.txt";
    private double totalDinheiro = 0;
    private double totalAlimentos = 0;
    private double totalRoupas = 0;
    private double totalOutras = 0;

    public SistemaDeDoacoes() {
        doacoes = new ArrayList<>();
    }

    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
        logDoacao(doacao);
        calcularTotaisPorTipo();
    }

    public double calcularTotalDoacoes() {
        double total = 0;
        for (Doacao doacao : doacoes) {
            total += doacao.getQuantidade();
        }
        return total;
    }

    public void salvarDoacoes(String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Doacao doacao : doacoes) {
                writer.write(doacao.toString());
                writer.newLine();
            }
        }
    }

    public void carregarDoacoes(String caminhoArquivo) throws IOException {
        doacoes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String tipo = dados[0].split("=")[1];
                double quantidade = Double.parseDouble(dados[1].split("=")[1]);
                Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dados[2].split("=")[1].replace("]", ""));
                doacoes.add(new Doacao(tipo, quantidade));
            }
        } catch (Exception e) {
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
        calcularTotaisPorTipo();
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

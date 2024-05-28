import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class SistemaDeDoacoes {
    private List<Doacao> doacoes;

    // Construtor
    public SistemaDeDoacoes() {
        doacoes = new ArrayList<>();
    }

    // Método para adicionar uma nova doação
    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
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
}

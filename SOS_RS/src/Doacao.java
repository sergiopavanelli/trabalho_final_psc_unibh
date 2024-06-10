import java.io.Serializable;
import java.time.LocalDateTime;
import java.text.DecimalFormat;


public class Doacao implements Serializable {
    private String tipo;
    private double quantidade;
    private LocalDateTime data;
    private String nome;
    private String email;

    public Doacao(String tipo, double quantidade, String nome, String email) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
        this.nome = nome;
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "-- Tipo: " + tipo + ", Quantidade: " + df.format(quantidade) + ", Data: " + data.toString() + ", Doador: " + nome + ", e-mail: " + email + " --" ;
    }
}
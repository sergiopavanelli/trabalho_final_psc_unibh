import java.io.Serializable;
import java.time.LocalDateTime;


public class Doacao implements Serializable {
    private String tipo;
    private double quantidade;
    private LocalDateTime data;

    public Doacao(String tipo, double quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
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

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Quantidade: " + quantidade + ", Data: " + data.toString();
    }
}
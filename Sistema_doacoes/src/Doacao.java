import java.util.Date;

public class Doacao {
    private String tipo;
    private double quantidade;
    private Date data;
    

    // Construtor
    public Doacao(String tipo, double quantidade, Date data) {
        
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    // Getters e Setters
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  

    @Override
    public String toString() {
        return "Doacao [tipo=" + tipo + ", quantidade=" + quantidade + ", data=" + data + "]";
    }
}

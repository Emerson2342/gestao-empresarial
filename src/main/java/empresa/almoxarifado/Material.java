package main.java.empresa.almoxarifado;

public class Material {
    private String cod;
    private String tipo;
    private String nome;
    private double valor;

    public Material(String cod, String tipo, String nome, double valor){
        this.cod = cod;
        this.tipo = tipo;
        this.nome = nome;
        this.valor = valor;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Código: " + cod + "; \n" +
                "Nome: " + nome + "; \n" +
                "Tipo: " + tipo + "; \n" +
                "Valor: " + valor + "; \n";
    }
}

package main.java.empresa.departamento_pessoal;

public class Cargo{
    private int cod;
    private String cargo;
    private String departamento;
    private double salario;

    public Cargo(int codigo, String departamento,String cargo,double salario) {
        this.cod = codigo;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int codigo) {
        this.cod = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Código: " + cod + "; \n" +
                "Departamento: " + departamento + "; \n" +
                "Cargo: " + cargo + "; \n" +
                "Salário: " + salario + "; \n";
    }

}

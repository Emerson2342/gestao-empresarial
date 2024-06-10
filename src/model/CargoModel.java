package model;

public class CargoModel {
    private String cbo;
    private String cargo;
    private String departamento;
    private String salario;

    public CargoModel(String cbo, String departamento, String cargo, String salario) {
        this.cbo = cbo;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCodigo(String cbo) {
        this.cbo = cbo;
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

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }


}

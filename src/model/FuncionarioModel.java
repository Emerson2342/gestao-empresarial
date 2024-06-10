package model;

public class FuncionarioModel {

    private String admissao;
    private int matricula;
    private String nome;
    private String departamento;
    private String cargo;
    private String telefone;
    private String cpf;
    private String dataNascimento;
    private String salario;
    private String endereco;

    //construtor add novo funcionário
    public FuncionarioModel(String admissao, int matricula, String nome, String cpf, String departamento, String cargo, String dataNascimento, String salario, String telefone, String endereco) {
        this.admissao = admissao;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.departamento = departamento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    public FuncionarioModel() {

    }

    public String getAdmissao() {
        return admissao;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSalario() {
        return salario;
    }

    public String getEndereco() {
        return endereco;
    }
}

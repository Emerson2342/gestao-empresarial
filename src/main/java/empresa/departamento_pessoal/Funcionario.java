package main.java.empresa.departamento_pessoal;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    private static int contadorMatricula = 1;
    private int matricula = 500;
    private LocalDate admissao;
    private String nome;
    private String departamento;
    private String cargo;
    private String telefone;
    private String cpf;
    private String dataNascimento;
    private double salario;
    private String endereco;

    //construtor add novo funcionário
    public Funcionario(String nome, String cpf, String departamento, String cargo, String dataNascimento, double salario, String telefone, String endereco) {
        matricula = contadorMatricula++;
        this.admissao = LocalDate.now();
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
        int formattedMat = Integer.parseInt(String.format("%05d", matricula));
        return formattedMat;
    }

    public Funcionario() {

    }

    public LocalDate getAdmissao() {
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

    public double getSalario() {
        return salario;
    }

    public String getEndereco() {
        return endereco;
    }
}

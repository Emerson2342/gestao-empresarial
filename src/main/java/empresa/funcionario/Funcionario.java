package main.java.empresa.funcionario;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario {
    private static int contadorMatricula = 1;
    private int matricula;
    private LocalDate admissao;
    private String nome;
    private String departamento;
    private String cargo;
    private String telefone;
    private long cpf;
    private int dataNascimento;
    private double salario;


    public Funcionario(LocalDate admissao, String nome, long cpf, String cargo, int dataNascimento, double salario) {
        matricula = contadorMatricula++;
        this.admissao = admissao;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public String getMatricula() {
        return String.format("%05d", matricula);
    }


    @Override
    public String toString() {
        return "Matricula: " + getMatricula() + "; \n" +
                "Admissao: " + admissao + "; \n" +
                "Nome: " + nome + "; \n" +
                "Departamento: " + departamento + "; \n" +
                "Cargo: " + cargo + "; \n" +
                "Telefone: " + telefone + "; \n" +
                "CPF: " + cpf + "; \n" +
                "Data de Nascimento: " + dataNascimento + "; \n" +
                "Salário: " + salario;
    }
}

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


    public Funcionario(LocalDate admissao, String nome, String cpf, String departamento, String cargo, String dataNascimento, double salario, String telefone) {
        matricula = contadorMatricula++;
        this.admissao = admissao;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.departamento = departamento;
        this.telefone = telefone;
    }

    public String getMatricula() {
        return String.format("%05d", matricula);
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String admissaoFormatada = admissao.format(formatter);

        String cpfFormatado = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

        String nascimentoFormatado = dataNascimento.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");

        DecimalFormat df = new DecimalFormat("#,##0.00");
        String salarioFormatado = "R$" + df.format(salario);

        return "Matricula: " + getMatricula() + "; \n" +
                "Admissao: " + admissaoFormatada + "; \n" +
                "Nome: " + nome + "; \n" +
                "Departamento: " + departamento + "; \n" +
                "Cargo: " + cargo + "; \n" +
                "Telefone: " + telefone + "; \n" +
                "CPF: " + cpfFormatado + "; \n" +
                "Data de Nascimento: " + nascimentoFormatado + "; \n" +
                "Salário: " + salarioFormatado;
    }
}

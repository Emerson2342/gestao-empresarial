package main.java.empresa.portaria;

import main.java.empresa.departamento_pessoal.ControleDePonto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visitante {
    private int matricula;
    private String nome;
    private String cpf;
    private LocalDateTime entrada;
    // private LocalDateTime saida;

    //construtor entrada de visitantes
    public Visitante(int matricula, String nome, String cpf, LocalDateTime entrada) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.entrada = entrada;

    }

    public Visitante() {

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String entradaFormatada = entrada.format(formato);
        String cpfFormatado = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return "Matricula: " + matricula + "; \n" +
                "Nome: " + nome + "; \n" +
                "CPF: " + cpfFormatado + "; \n" +
                "Entrada: " + entradaFormatada;
    }
}
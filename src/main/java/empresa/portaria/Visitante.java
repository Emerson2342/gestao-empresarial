package main.java.empresa.portaria;

import main.java.empresa.departamento_pessoal.ControleDePonto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visitante {
    private int matricula;
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    //construtor entrada de visitantes
    public Visitante(int matricula, String nome, String cpf, String telefone, LocalDateTime entrada) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.entrada = entrada;
    }
    //construtor saída de visitantes
    public Visitante(int matricula, String nome, String cpf, String telefone, LocalDateTime entrada, LocalDateTime saida) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.entrada = entrada;
        this.saida = saida;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
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

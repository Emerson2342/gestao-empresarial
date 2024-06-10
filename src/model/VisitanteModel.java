package model;

import java.time.LocalDateTime;

public class VisitanteModel {
    private int matricula;
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    //construtor entrada de visitantes
    public VisitanteModel(int matricula, String nome, String cpf, String telefone, LocalDateTime entrada) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.entrada = entrada;
    }
    //construtor saída de visitantes
    public VisitanteModel(int matricula, String nome, String cpf, String telefone, LocalDateTime entrada, LocalDateTime saida) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.entrada = entrada;
        this.saida = saida;
    }

    public VisitanteModel() {
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

 }

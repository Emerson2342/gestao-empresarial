package main.java.empresa.funcionario;

import java.util.Date;

public class Funcionario {
    private static int contadorMatricula = 1;
    private int matricula;
    private String nome;
    private String departamento;
    private String funcao;
    private String telefone;
    private long cpf;
    private String endereco;
    private Date dataNascimento;

    public Funcionario(String nome, long cpf){
       matricula = contadorMatricula++;
       this.nome = nome;
       this.cpf = cpf;
    }

    public String getMatricula() {
        return String.format("%05d", matricula);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String funcionarioCadastrado(){
        return "Matrícula: " + getMatricula() + "\n"+
                "Nome: " + nome+"\n"+
                "CPF: " + cpf;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + getMatricula() +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}

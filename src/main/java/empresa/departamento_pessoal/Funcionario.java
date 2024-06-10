package main.java.empresa.departamento_pessoal;

import model.FuncionarioModel;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends FuncionarioModel {
    private static Funcionario instance;
    //atributo da Classse
    private List<FuncionarioModel> funcionarioList;

    public Funcionario() {
        this.funcionarioList = new ArrayList<>();
    }

    public static Funcionario getInstance() {
        if (instance == null) {
            instance = new Funcionario();
        }
        return instance;
    }

    public void adicionarFuncionario( String admissao,int matricula, String nome, String cpf, String departamento, String cargo, String dataNascimento, String salario, String telefone, String endereco) {
        funcionarioList.add(new FuncionarioModel( admissao,matricula,nome, cpf, departamento, cargo, dataNascimento, salario, telefone, endereco));
    }

    public List<FuncionarioModel> listaFuncionario() {
        for (FuncionarioModel f : funcionarioList) {
            System.out.println(f);
            System.out.println("**************************");
        }
        return funcionarioList;
    }

}

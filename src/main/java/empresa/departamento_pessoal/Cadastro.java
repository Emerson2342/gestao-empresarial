package main.java.empresa.departamento_pessoal;

import DAO.CadastroFuncionarioDAO;
import main.java.empresa.portaria.Visitante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cadastro extends Funcionario {
    private static Cadastro instance;
    //atributo da Classse
    private List<Funcionario> funcionarioList;

    public Cadastro() {
        this.funcionarioList = new ArrayList<>();
    }

    public static Cadastro getInstance() {
        if (instance == null) {
            instance = new Cadastro();
        }
        return instance;
    }

    public void adicionarFuncionario( String nome, String cpf, String departamento, String cargo, String dataNascimento, double salario, String telefone, String endereco) {
        funcionarioList.add(new Funcionario( nome, cpf, departamento, cargo, dataNascimento, salario, telefone, endereco));
    }

    public List<Funcionario> listaFuncionario() {
        for (Funcionario f : funcionarioList) {
            System.out.println(f);
            System.out.println("**************************");
        }
        return funcionarioList;
    }

}

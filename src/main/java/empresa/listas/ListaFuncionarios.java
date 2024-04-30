package main.java.empresa.listas;

import main.java.empresa.classes.Funcionario;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ListaFuncionarios {
    //atributo
    private Set<Funcionario> funcionarioList;

    public ListaFuncionarios() {
        this.funcionarioList = new HashSet<>();
    }

    public void adicionarFuncionario(LocalDate admissao, String nome, String cpf,String departamento, String cargo, String dataNascimento, double salario, String telefone){
        funcionarioList.add(new Funcionario( admissao, nome, cpf, departamento,cargo, dataNascimento, salario, telefone));
    }

    public Set<Funcionario> listaFuncionarios(){
        for(Funcionario f : funcionarioList){
            System.out.println(f);
        }
        return funcionarioList;
    }


}

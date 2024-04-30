package main.java.empresa.funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaFuncionarios {
    //atributo
    private List<Funcionario> funcionarioList;

    public ListaFuncionarios() {
        this.funcionarioList = new ArrayList<>();
    }

    public void adicionarFuncionario(LocalDate admissao, String nome, long cpf, String cargo, int dataNascimento, double salario){
        funcionarioList.add(new Funcionario( admissao, nome,  cpf, cargo, dataNascimento, salario));
    }

    public  List<Funcionario> listaFuncionarios(){
        for(Funcionario f : funcionarioList){
            System.out.println(f);
        }
        return funcionarioList;
    }


}

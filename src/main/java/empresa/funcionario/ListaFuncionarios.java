package main.java.empresa.funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {
    //atributo
    private List<Funcionario> funcionarioList;

    public ListaFuncionarios() {
        this.funcionarioList = new ArrayList<>();
    }

    public void adicionarFuncionario(String nome, long cpf){
        funcionarioList.add(new Funcionario( nome,  cpf));
    }

    public  List<Funcionario> listaFuncionarios(){
        for(Funcionario f : funcionarioList){
            System.out.println(f);
        }
        return funcionarioList;
    }


}

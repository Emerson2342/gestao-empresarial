package main.java.empresa.departamento_pessoal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ListaFuncionarios {
    private static ListaFuncionarios instssance;
    //atributo
    private Set<Funcionario> funcionarioList;

    private ListaFuncionarios() {
        this.funcionarioList = new HashSet<>();
    }

    public static ListaFuncionarios getInssstance(){
        if (instssance == null){
            instssance = new ListaFuncionarios();
        }
        return instssance;
    }

    public void adicionarFuncionario(LocalDate admissao, String nome, String cpf,String departamento, String cargo, String dataNascimento, double salario, String telefone){
        funcionarioList.add(new Funcionario( admissao, nome, cpf, departamento,cargo, dataNascimento, salario, telefone));
    }

    public Set<Funcionario> listaFuncionarios(){
        for(Funcionario f : funcionarioList){
            System.out.println(f);
            System.out.println("****************************");
        }
        return funcionarioList;
    }
}

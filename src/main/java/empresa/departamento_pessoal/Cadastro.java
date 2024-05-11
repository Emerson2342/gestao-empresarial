package main.java.empresa.departamento_pessoal;
import java.time.LocalDate;

public class Cadastro {
    public Cadastro() {
        LocalDate admissao = LocalDate.now();

        ListaFuncionarios novoFuncionario = ListaFuncionarios.getInssstance();

        String nome = "Emerson Ribeiro da Cunha";
        String cpf = "02970248174";
        String dataNascimento = "22091990";
        String telefone = "61 99835-4398";

        //opção de cargo, departamento e salário
        int opcao = 1;

        String cargo = ListaCargo.buscarCargoPorCodigo(opcao);
        String departamento = ListaCargo.buscarDepartamentoPorCodigo(opcao);
        double salario = ListaCargo.buscarSalarioPorCodigo(opcao);

        //criando novo funcionário
        novoFuncionario.adicionarFuncionario(admissao, nome, cpf, departamento, cargo, dataNascimento, salario, telefone);
        //mostrar a lista de funcionários
//        novoFuncionario.listaFuncionarios();
    }
}

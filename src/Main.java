import main.java.empresa.listas.ListaCargo;
import main.java.empresa.listas.ListaFuncionarios;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCargo.carregarCargos();

        LocalDate admissao = LocalDate.now();
        ListaFuncionarios novoFuncionario = new ListaFuncionarios();

        String nome = "Emerson";
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
        System.out.println("Funcionário cadastrado com sucesso!");

        //mostrar a lista de funcionários
        novoFuncionario.listaFuncionarios();


        scanner.close();
    }
}

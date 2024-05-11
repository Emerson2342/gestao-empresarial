import main.java.empresa.departamento_pessoal.Cadastro;
import main.java.empresa.departamento_pessoal.FolhaDePagamento;
import main.java.empresa.departamento_pessoal.ListaCargo;
import main.java.empresa.departamento_pessoal.ListaFuncionarios;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCargo.carregarCargos();

        //cadastrando funcionário
        Cadastro novoFuncionario1 = new Cadastro();
        Cadastro novoFuncionario2 = new Cadastro();
        Cadastro novoFuncionario3 = new Cadastro();
        //exibindo a lista de funcionários
        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();

        folhaDePagamento.ListaFuncionarios();
        ListaCargo.listaCargos();

        scanner.close();
    }
}

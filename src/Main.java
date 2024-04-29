import main.java.empresa.funcionario.ListaFuncionarios;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaFuncionarios novoFuncionario = new ListaFuncionarios();
        int opcao = -1;
        System.out.println("*********Cadastro de funcionários***********");
        System.out.println("Opções");
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Cadastrar novo funcionário.");
        System.out.println("2 - Alterar dados do funcionário.");
        System.out.println("3 - Exibir lista de funcionários.");
        System.out.println("4 - Apagar funcionário.");
        System.out.println("0 - Sair.");

        while (opcao != 0) {

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do input

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do funcionário");
                    String nome = scanner.next();
                    scanner.nextLine(); // Limpa o buffer do input

                    System.out.println("Digite o CPF do funcionário");
                    long cpf = scanner.nextLong();

                    novoFuncionario.adicionarFuncionario(nome, cpf);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Lista de Funcionários:");
                    novoFuncionario.listaFuncionarios();
                    break;
                case 4:

                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida!");
            }
        }
        scanner.close();
    }
}

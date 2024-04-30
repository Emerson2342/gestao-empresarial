import main.java.empresa.funcionario.Funcionario;
import main.java.empresa.funcionario.ListaFuncionarios;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate admissao = LocalDate.now();

        ListaFuncionarios novoFuncionario = new ListaFuncionarios();
        int opcao = -1;
        System.out.println("*********Cadastro de funcionários***********");
        System.out.println("Opções");


        while (opcao != 0) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Cadastrar novo funcionário.");
            System.out.println("2 - Alterar dados do funcionário.");
            System.out.println("3 - Exibir lista de funcionários.");
            System.out.println("4 - Apagar funcionário.");
            System.out.println("0 - Sair.");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do input

            switch (opcao) {
                case 1:

                    System.out.println("Digite o nome do funcionário");
                    String nome = scanner.next();
                    scanner.nextLine(); // Limpa o buffer do input

                    System.out.println("Digite o CPF do funcionário:");
                    long cpf = scanner.nextLong();

                    System.out.println("Selecione o cargo:");
                    System.out.println(" 1-Diretor,\n" +
                            "2-Administrador,\n" +
                            "3-Tesoureiro,\n" +
                            "4-Gerente,\n" +
                            "5-Assistente Administrativo Nível 1,\n" +
                            "6-Assistente Administrativo Nível 1,\n" +
                            "7-Assistente Jurídico,\n" +
                            "8-Supervisor Operacional,\n" +
                            "9-Almoxarife,\n" +
                            "10-Encarregado,\n" +
                            "11-Servente,\n" +
                            "12-Porteiro,\n" +
                            "13-Brigadista,\n" +
                            "14-Vigilante");
                    int opcaoCargo = scanner.nextInt();
                    String cargo = "";
                    switch (opcaoCargo) {
                        case 1:
                            cargo = "Diretor";
                            break;
                        case 2:
                            cargo = "Administrador";
                            break;
                        case 3:
                            cargo = "Tesoureiro";
                            break;
                        case 4:
                            cargo = "Gerente";
                            break;
                        case 5:
                            cargo = "Assistente Administrativo Nível 1";
                            break;
                        case 6:
                            cargo = "Assistente Administrativo Nível 2";
                            break;
                        case 7:
                            cargo = "Assistente Jurídico";
                            break;
                        case 8:
                            cargo = "Supervisor Operacional";
                            break;
                        case 9:
                            cargo = "Almoxarire";
                            break;
                        case 10:
                            cargo = "Encarregado";
                            break;
                        case 11:
                            cargo = "Servente";
                            break;
                        case 12:
                            cargo = "Porteiro";
                            break;
                        case 13:
                            cargo = "Brigadista";
                            break;
                        case 14:
                            cargo = "Vigilante";
                            break;
                    }
                    scanner.nextLine(); // Limpa o buffer do input

                    System.out.println("Digite a data de nascimento no formato DDMMAAAA:");
                    int dataNascimento = scanner.nextInt();

                    System.out.println("Digite o valor do salário:");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();// Limpa o buffer do input

                    novoFuncionario.adicionarFuncionario(admissao, nome, cpf, cargo, dataNascimento, salario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 2:
                    break;

                case 3:
                    JFrame janela = new JFrame();
                    JLabel label = new JLabel(String.valueOf(novoFuncionario.listaFuncionarios()), JLabel.CENTER);
                    janela.setSize(1500,700);
                    janela.getContentPane().setBackground(new Color(0,150,250) );
                    janela.add(label);
                    janela.setVisible(true);
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

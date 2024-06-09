package main.java.empresa.portaria;

import DAO.PortariaDAO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Portaria extends Visitante {
    private static Portaria instssance;
    //atributo
    private Set<Visitante> visitanteList;

    private Portaria() {
        this.visitanteList = new HashSet<>();
    }

    public static Portaria getInssstance() {
        if (instssance == null) {
            instssance = new Portaria();
        }
        return instssance;
    }

    public void adicionarVisitante(int matricula, String nome, String cpf,String telefone, LocalDateTime entrada) {
        visitanteList.add(new Visitante( matricula, nome, cpf,telefone, entrada));
    }


    public Set<Visitante> listaVisitante() {
        for (Visitante v : visitanteList) {
            System.out.println(v);
            System.out.println("**************************");
        }
        return visitanteList;
    }

//    public String permanenciaNaInstalação() {
//        setSaida(LocalDateTime.now());
//        calcularHoras();
//
//        int segundosTrabalhados = getSegundosTrabalhados();
//        int horas = segundosTrabalhados / 3600;
//        int minutos = (segundosTrabalhados % 3600) / 60;
//        int segundos = segundosTrabalhados % 60;
//
//        registrarSaida(LocalDateTime.now());
//
//        return "Tempo de permanência nas instalações: " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos.";
//    }

    public static void main(String[] args) {
        //  Scanner scanner = new Scanner(System.in);





//        System.out.println("Digite a matrícula");
//        int matricula = scanner.nextInt();
//
//        Portaria portaria = new Portaria(matricula, LocalDateTime.now());
//
//
//        System.out.println("Digite para registrar a saída");
//        scanner.next();
//
//        System.out.println(portaria.permanenciaNaInstalação());
    }


}

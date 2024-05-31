package main.java.empresa.departamento_pessoal;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Portaria extends ControleDePonto {
    private int matricula;

    public Portaria(int matricula, LocalDateTime entrada) {
        this.matricula = matricula;
        setEntrada(entrada);
           }

    public LocalDateTime registrarEntrada(LocalDateTime entrada) {
        setEntrada(entrada);
        return getEntrada();
    }

    public LocalDateTime registrarSaida(LocalDateTime saida) {
        setSaida(saida);
        return getSaida();
    }

    public String permanenciaNaInstalação() {
        setSaida(LocalDateTime.now());
        calcularHoras();

        int segundosTrabalhados = getSegundosTrabalhados();
        int horas = segundosTrabalhados / 3600;
        int minutos = (segundosTrabalhados % 3600) / 60;
        int segundos = segundosTrabalhados % 60;

        registrarSaida(LocalDateTime.now());

        return "Tempo de permanência nas instalações: " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Portaria portaria = new Portaria(2342, LocalDateTime.now());
        System.out.println("Digite para registrar a saída");
        scanner.next();

        System.out.println(portaria.permanenciaNaInstalação());
    }


}

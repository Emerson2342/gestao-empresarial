package main.java.empresa.departamento_pessoal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControleDePonto {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private int segundosTrabalhados;

    public LocalDateTime entrada() {
        return entrada = LocalDateTime.now();
    }

    public LocalDateTime saida() {
        return saida = LocalDateTime.now();
    }

    private void calcularHoras() {
        int horaEntrada = entrada.getHour() * 3600;
        int minEntrada = entrada.getMinute() * 60;
        int secEntrada = entrada.getSecond();
        int horaSaida = saida.getHour() * 3600;
        int minSaida = saida.getMinute() * 60;
        int secSaida = saida.getSecond();

        segundosTrabalhados = (horaSaida - horaEntrada) +
                (minSaida - minEntrada) +
                (secSaida - secEntrada);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String entradaFormatada = entrada.format(formato);
        String saidaFormatada = saida.format(formato);
        int horas = segundosTrabalhados / 3600;
        int minutos = (segundosTrabalhados % 3600) / 60;
        int segundos = segundosTrabalhados % 60;

        String horasFormatadas = String.format("%02d", horas);
        String minutosFormatados = String.format("%02d", minutos);
        String segundosFormatados = String.format("%02d", segundos);

        return "Controle De Ponto" + "\n" +
                "Entrada: " + entradaFormatada + "\n" +
                "Saida: " + saidaFormatada + "\n" +
                "Horas Trabalhadas: " + horasFormatadas + "h:" + minutosFormatados+ "m:" + segundosFormatados+"s";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ControleDePonto pessoa = new ControleDePonto();

        pessoa.entrada();
        System.out.println("Digite para registrar a saída");
        String sair = scanner.next();

        pessoa.saida();
        pessoa.calcularHoras();
        System.out.println(pessoa);
    }


}

package main.java.empresa.portaria;

import model.VisitanteModel;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Portaria{
    private static Portaria instssance;
    //atributo
    private Set<VisitanteModel> visitanteList;

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
        visitanteList.add(new VisitanteModel( matricula, nome, cpf,telefone, entrada));
    }


    public Set<VisitanteModel> listaVisitante() {
        for (VisitanteModel v : visitanteList) {
            System.out.println(v);
            System.out.println("**************************");
        }
        return visitanteList;
    }

}

package main.java.empresa.listas;
import main.java.empresa.classes.Cargo;
import java.util.HashSet;
import java.util.Set;

public class ListaCargo {
    private static Set<Cargo> cargosList = new HashSet<>();


    private static void cargosSalvos() {
        adicionarCargo(1, "Pessoal", "Assistente", 4500);
        adicionarCargo(2, "Operacional", "Assistente", 3500);
        adicionarCargo(3, "Almoxarifado", "Assistente", 3000);
        adicionarCargo(4, "Gerência", "Assistente", 2500);
        adicionarCargo(5, "Saúde", "Médico", 8900);
    }
    public static void carregarCargos() {
        cargosSalvos();
    }


    public static void adicionarCargo(int codigo, String departamento, String cargo, double salario) {
        cargosList.add(new Cargo(codigo,departamento, cargo, salario ));
    }

    public static String buscarCargoPorCodigo(int codigo){
        for(Cargo c: cargosList){
            if(c.getCodigo() == codigo){
                return c.getCargo();
            }
        }
        return null;
    }

    public static String buscarDepartamentoPorCodigo(int codigo){
        for(Cargo c : cargosList){
            if(c.getCodigo() == codigo){
                return c.getDepartamento();
            }
        }
        return null;
    }

    public static double buscarSalarioPorCodigo(int codigo){
        for(Cargo c : cargosList){
            if(c.getCodigo() == codigo){
                return c.getSalario();
            }
        }
        return 0;
    }



    public static Set<Cargo> listaCargos() {
        for (Cargo c : cargosList) {
            System.out.println(c);
        }
        return cargosList;
    }
}

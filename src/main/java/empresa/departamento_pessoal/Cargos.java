package main.java.empresa.departamento_pessoal;

import model.CargoModel;

import java.util.ArrayList;
import java.util.List;

public class Cargos {
    private static Cargos instance;

    private List<CargoModel> cargosList;

    private Cargos() {
        this.cargosList = new ArrayList<>();
    }

    public static Cargos getInstance() {
        if (instance == null) {
            instance = new Cargos();
        }
        return instance;
    }

    public void adicionarCargo(String CBO, String departamento, String cargo, String salario) {
        cargosList.add(new CargoModel(CBO, departamento, cargo, salario));
    }

    public List<CargoModel> listaCargos(){
       return cargosList;
    }


}

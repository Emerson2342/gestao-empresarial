package DAO;

import conexao.Conexao;
import model.CargoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CargoDAO {

    public int cadastrarCargo(CargoModel cargo) {

        String sql = "INSERT INTO DEPARTAMENTOPESSOAL.CARGOS (CBO, CARGO, DEPARTAMENTO, SALARIO) VALUES (?,?,?,?)";
        int generatedId = -1;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cargo.getCbo());
            ps.setString(2, cargo.getCargo());
            ps.setString(3, cargo.getDepartamento());
            ps.setString(4, cargo.getSalario());

            ps.execute();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    public CargoModel selecionarCargo(String cargoParametro) {
        String sql = "SELECT * FROM DEPARTAMENTOPESSOAL.CARGOS WHERE Cargo = ?";

        CargoModel cargoSelecionado = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cargoParametro);//parâmetro do cargo selecionado

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String cbo = rs.getString("CBO");
                    String cargo = rs.getString("CARGO");
                    String departamento = rs.getString("DEPARTAMENTO");
                    String salario = rs.getString("SALARIO");

                    cargoSelecionado = new CargoModel(cbo, departamento, cargo, salario);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoSelecionado;
    }


    public List<String> buscarCargos() {
        List<String> cargos = new ArrayList<>();
        String sql = "SELECT cargo FROM DEPARTAMENTOPESSOAL.CARGOS";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String cargo = rs.getString("cargo");
                    cargos.add(cargo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargos;
    }

    public List<CargoModel> listarCargos() {
        String sql = "SELECT * FROM departamentopessoal.cargos;";
        List<CargoModel> cargos = new ArrayList<>();

        try (
                Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String cbo = rs.getString("CBO");
                String cargoo = rs.getString("CARGO");
                String departamento = rs.getString("DEPARTAMENTO");
                String salario = rs.getString("SALARIO");

                CargoModel cargo = new CargoModel(cbo, departamento, cargoo, salario);
                cargos.add(cargo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cargos;

    }


}

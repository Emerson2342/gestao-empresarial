package DAO;

import conexao.Conexao;
import model.VisitanteModel;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PortariaDAO {

    public int resgistrarEntrada(VisitanteModel visitante) {
        String sql = "INSERT INTO CONTROLEPORTARIA.REGISTRO (MATRICULA, NOME, CPF, TELEFONE, ENTRADA, SAIDA) VALUES (?,?,?,?,?,?)";
        int generatedId = -1;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, visitante.getMatricula());
            ps.setString(2, visitante.getNome());
            ps.setString(3, visitante.getCpf());
            ps.setString(4, visitante.getTelefone());
            ps.setObject(5, visitante.getEntrada());
            ps.setObject(6, visitante.getSaida());

            ps.execute();
            //  ps.close();

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


    public boolean registrarSaida(int matricula) {
        String sql = "UPDATE controleportaria.registro SET saida = NOW() WHERE id = (SELECT id FROM(SELECT id FROM controleportaria.registro WHERE matricula = ? ORDER BY entrada DESC LIMIT 1) AS subquery)";
        boolean sucesso = false;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, matricula);
            int rowsAffected = ps.executeUpdate();
            sucesso = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public VisitanteModel selecionarVisitante(int matricula) {
        String sql = "SELECT * FROM controleportaria.registro WHERE matricula = ? ORDER BY entrada DESC LIMIT 1";

        VisitanteModel visitanteSelecionado = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, matricula);//parâmetro matrícula

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("NOME");
                    String cpf = rs.getString("CPF");
                    String telefone = rs.getString("TELEFONE");
                    LocalDateTime entrada = rs.getTimestamp("ENTRADA").toLocalDateTime();
                    LocalDateTime saida = rs.getTimestamp("SAIDA") != null ? rs.getTimestamp("SAIDA").toLocalDateTime() : null;
                    visitanteSelecionado = new VisitanteModel(matricula, nome, cpf, telefone, entrada, saida);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitanteSelecionado;
    }


    public List<VisitanteModel> listarVisitantes() {
        String sql = "SELECT * FROM CONTROLEPORTARIA.REGISTRO";
        List<VisitanteModel> visitantes = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int matricula = rs.getInt("MATRICULA");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String telefone = rs.getString("TELEFONE");
                LocalDateTime entrada = rs.getTimestamp("ENTRADA").toLocalDateTime();
                LocalDateTime saida = rs.getTimestamp("SAIDA") != null ? rs.getTimestamp("SAIDA").toLocalDateTime() : null;

                VisitanteModel visitante = new VisitanteModel(matricula, nome, cpf, telefone, entrada, saida);
                //visitante.setSaida(saida);
                visitantes.add(visitante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visitantes;
    }

}

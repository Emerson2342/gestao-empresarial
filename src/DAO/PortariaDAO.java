package DAO;

import conexao.Conexao;
import main.java.empresa.portaria.Visitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PortariaDAO {

    public void resgistrarEntrada(Visitante visitante) {
        String sql = "INSERT INTO REGISTRO (MATRICULA, NOME, CPF, ENTRADA, SAIDA) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, visitante.getMatricula());
            ps.setString(2, visitante.getNome());
            ps.setString(3, visitante.getCpf());
            ps.setObject(4, visitante.getEntrada());
            ps.setObject(5, visitante.getSaida());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       // return List.of();
    }

        public List<Visitante> listarVisitantes(){
           String sql = "SELECT * FROM REGISTRO";
            List<Visitante> visitantes = new ArrayList<>();

            try (Connection conn = Conexao.getConexao();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int matricula = rs.getInt("MATRICULA");
                    String nome = rs.getString("NOME");
                    String cpf = rs.getString("CPF");
                    LocalDateTime entrada = rs.getTimestamp("ENTRADA").toLocalDateTime();
                    LocalDateTime saida = rs.getTimestamp("SAIDA") != null ? rs.getTimestamp("SAIDA").toLocalDateTime() : null;

                    Visitante visitante = new Visitante(matricula, nome, cpf, entrada);
                    visitante.setSaida(saida);
                    visitantes.add(visitante);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return visitantes;
        }

}

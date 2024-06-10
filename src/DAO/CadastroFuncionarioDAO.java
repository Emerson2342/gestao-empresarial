package DAO;

import conexao.Conexao;
import model.CargoModel;
import model.FuncionarioModel;
import model.VisitanteModel;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarioDAO {

    public int cadastrarFuncionario(FuncionarioModel funcionario) {
        String sql = "INSERT INTO DEPARTAMENTOPESSOAL.REGISTROFUNCIONARIO (ADMISSAO, MATRICULA, NOME, CPF, DEPARTAMENTO, CARGO, NASCIMENTO, SALARIO, TELEFONE, ENDERECO) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int generetedId = -1;


        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, funcionario.getAdmissao());
            ps.setInt(2, funcionario.getMatricula());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, funcionario.getDepartamento());
            ps.setString(6, funcionario.getCargo());
            ps.setString(7, funcionario.getDataNascimento());
            ps.setString(8, funcionario.getSalario());
            ps.setString(9, funcionario.getTelefone());
            ps.setString(10, funcionario.getEndereco());

            ps.execute();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generetedId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generetedId;
    }




}

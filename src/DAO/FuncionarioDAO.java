package DAO;

import conexao.Conexao;
import model.FuncionarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

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


    public List<FuncionarioModel> listarFuncionarios() {
        String sql = "SELECT * FROM departamentopessoal.registrofuncionario;";
        List<FuncionarioModel> funcionarios = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String admissao = rs.getString("ADMISSAO");
                int matricula = rs.getInt("MATRICULA");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String departamento = rs.getString("DEPARTAMENTO");
                String cargo = rs.getString("CARGO");
                String nascimento = rs.getString("NASCIMENTO");
                String salario = rs.getString("SALARIO");
                String telefone = rs.getString("TELEFONE");
                String endereco = rs.getString("ENDERECO");


                FuncionarioModel funcionario = new FuncionarioModel(admissao, matricula, nome, cpf, departamento, cargo, nascimento, salario, telefone, endereco);
                funcionarios.add(funcionario);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }


}

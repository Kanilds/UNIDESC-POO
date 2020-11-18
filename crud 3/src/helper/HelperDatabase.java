package helper;

import factory.DatabaseConnection;
import modal.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelperDatabase {

    private static HelperDatabase inst = null;

    private HelperDatabase() {

    }

    public static HelperDatabase getInst() {

        if (inst == null)
            inst = new HelperDatabase();
        return inst;
    }

    public void criaAluno(Aluno aluno) {
        PreparedStatement comandoSql;

        try {
            comandoSql = DatabaseConnection.getInstance().preparedStatement(
                    "insert into aluno values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            comandoSql.setString(1, aluno.getNome());
            comandoSql.setString(2, aluno.getCurso());
            comandoSql.setString(3, aluno.getCpf());
            comandoSql.setString(4, aluno.getMatricula());
            comandoSql.executeUpdate();
            comandoSql.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Aluno> buscaAluno() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "SELECT * FROM aluno";
        Connection conn = DatabaseConnection.getConnection();

        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rset = statement.executeQuery(sql);
            while (rset.next()) {
                Aluno aluno = new Aluno();
                aluno.setNome(rset.getString("nome"));

                aluno.setCurso(rset.getString("curso"));

                aluno.setCpf(rset.getString("cpf"));

                aluno.setMatricula(rset.getString("matricula"));

                alunos.add(aluno);
            }
        } catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }
        return alunos;
    }

    public void atualizaAluno(String cpf, String nome, String curso) {
        PreparedStatement comandoSql;

        try {
            comandoSql = DatabaseConnection.getInstance().preparedStatement(
                    "update aluno set nome = ?, curso = ? where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            comandoSql.setString(1, nome);
            comandoSql.setString(2, curso);
            comandoSql.setString(3, cpf);
            comandoSql.executeUpdate();
            comandoSql.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean deletaAluno(String cpf) {
        PreparedStatement comandoSql;

        try {
            comandoSql = DatabaseConnection.getInstance().preparedStatement(
                    "delete from aluno where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            comandoSql.setString(1, cpf);
            comandoSql.execute();
            comandoSql.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}

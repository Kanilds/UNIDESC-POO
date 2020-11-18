package controller;

import helper.HelperDB;
import controller.interfaces.IAluno;
import entidades.Aluno;

public class AlunoController implements IAluno {

    @Override
    public void criaAluno(Aluno aluno) {

        aluno.setMatricula();

        HelperDB helperDB = HelperDB.getInstance();
        helperDB.criarAluno(aluno);
    }

    @Override
    public String buscaAluno(String cpf) {

        HelperDB helperDB = HelperDB.getInstance();
        return helperDB.buscaAluno(cpf);
    }

    @Override
    public void atualizaAluno(String cpf, String nome, String curso) {

        HelperDB helperDB = HelperDB.getInstance();
        helperDB.atualizaAluno(cpf, nome, curso);
    }

    @Override
    public void deletaAluno(String cpf) {

        HelperDB helperDB = HelperDB.getInstance();
        helperDB.deletarAluno(cpf);
    }
}

package controller;

import controller.inteface.IAluno;
import helper.HelperDatabase;
import modal.Aluno;

import java.util.List;

public class AlunoController implements IAluno {


    @Override
    public void criaAluno(Aluno aluno) {

        aluno.criaMatricula();
        HelperDatabase databaseHelper = HelperDatabase.getInst();
        databaseHelper.criaAluno(aluno);


    }

    @Override
    public List<Aluno> buscaAluno() {

        HelperDatabase databaseHelper = HelperDatabase.getInst();
        return databaseHelper.buscaAluno();


    }

    @Override
    public void atualizaAluno(String cpf, String nome, String curso) {
        HelperDatabase databaseHelper = HelperDatabase.getInst();
        databaseHelper.atualizaAluno(cpf, nome, curso);

        System.out.println("\nAluno atualizado com sucesso!\n");

    }

    @Override
    public boolean deletaAluno(String cpf) {


        HelperDatabase databaseHelper = HelperDatabase.getInst();
        return databaseHelper.deletaAluno(cpf);

    }
}

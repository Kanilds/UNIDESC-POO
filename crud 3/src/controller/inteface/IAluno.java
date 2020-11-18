package controller.inteface;

import modal.Aluno;

import java.util.List;

public interface IAluno {


    void criaAluno(Aluno aluno);
    List<Aluno> buscaAluno();
    void atualizaAluno(String cpf, String nome, String curso);
    boolean deletaAluno(String cpf);
}


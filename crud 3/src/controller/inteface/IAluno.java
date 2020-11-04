package controller.inteface;

import modal.Aluno;

public interface IAluno {


    void criaAluno(Aluno aluno);
    Object buscaAluno(String cpf);
    void atualizaAluno(Aluno aluno);
    boolean deletaAluno(Aluno aluno);
}


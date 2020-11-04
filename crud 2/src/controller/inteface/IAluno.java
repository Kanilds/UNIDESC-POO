package controller.inteface;

import modal.Aluno;

public interface IAluno {


    String criaAluno(Aluno aluno);
    Object buscaAluno(String cpf);
    void atualizaAluno(Aluno aluno);
    void deletaAluno(Aluno aluno);
}


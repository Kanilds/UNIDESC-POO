package controller.interfaces;

import entidades.Aluno;

public interface IAluno {

    void criaAluno(Aluno aluno);
    String buscaAluno(String cpf);
    void atualizaAluno(String cpf, String nome, String curso);
    void deletaAluno(String cpf);
}

package controller;

import controller.inteface.IAluno;
import modal.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController implements IAluno{


    private final List<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public String criaAluno(Aluno aluno) {

        aluno.setMatricula();

        alunos.add(aluno);

        return null;
    }

    @Override
    public Aluno buscaAluno(String cpf) {

        for (Aluno aluno : alunos) {
            if (cpf.equals(aluno.getCpf())) {
                return aluno;
            }
        }
        return null;



    }

    @Override
    public void atualizaAluno(Aluno aluno ) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Novo Nome do Aluno: ");
            aluno.setNome(scan.nextLine());
            System.out.println("Novo Curso do Aluno: ");
            aluno.setCurso(scan.nextLine());

            System.out.println("\nAluno atualizado com sucesso!\n");

    }

    @Override
    public void deletaAluno(Aluno aluno) {
        alunos.remove(aluno);

        System.out.println("\n Aluno deletado com sucesso!\n");
    }
}

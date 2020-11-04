package controller;

import helper.Helper;
import controller.inteface.IAluno;
import modal.Aluno;

import java.util.Scanner;

public class AlunoController implements IAluno{

    private final String ARQUIVO_CSV = "aluno.csv";
    private final String separador = ",";


    @Override
    public void criaAluno(Aluno aluno) {

        aluno.setMatricula();
        Helper helper = Helper.getInst();
        helper.armazenarCSV(aluno);


    }

    @Override
    public String buscaAluno(String cpf) {

        Helper helper = Helper.getInst();
        return helper.lerArquivoCSV();



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
    public boolean deletaAluno(Aluno aluno) {
        Helper helper = Helper.getInst();
        return helper.deletarCSV();
    }
}

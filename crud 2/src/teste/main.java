package teste;

import controller.AlunoController;
import modal.Aluno;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        int qtdAluno;
        String opcaoMenu, qtd;

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        do {
            System.out.println("\n====MENU DE OPÇÕES====\n");
            System.out.println("1) Adicionar novo aluno!");
            System.out.println("2) Buscar aluno!");
            System.out.println("3) Atualizar aluno!");
            System.out.println("4) Deletar aluno!");
            System.out.println("0) Sair!");
            opcaoMenu = scanner.nextLine();

            switch (opcaoMenu) {
                case "0":
                    System.out.println("\nEncerrando\n");
                    break;
                case "1":
                    System.out.println("Números de Alunos a adicionar?");

                    qtd = scanner.nextLine();
                    qtdAluno = Integer.parseInt(qtd);

                    for (int i = 0; i < qtdAluno; i++) {
                        Aluno novoAluno = new Aluno();

                        System.out.println("Nome do Aluno: ");
                        novoAluno.setNome(scanner.nextLine());
                        System.out.println("CPF do Aluno: ");
                        novoAluno.setCpf(scanner.nextLine());
                        System.out.println("Curso do Aluno: ");
                        novoAluno.setCurso(scanner.nextLine());

                        alunoController.criaAluno(novoAluno);
                    }
                    break;
                case "2":
                    System.out.println("CPF do aluno a buscar: ");
                    aluno = alunoController.buscaAluno(scanner.nextLine());
                    if (aluno != null) {
                        System.out.println("\nAluno encontrado: \n");
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("CPF: " + aluno.getCpf());
                        System.out.println("Curso: " + aluno.getCurso());
                        System.out.println("Matricula: " + aluno.getMatricula());
                    } else {
                        System.out.println("\nCPF invalido!\n");
                    }
                    break;
                case "3":
                    System.out.println("Insira o CPF do aluno desejado: ");
                    aluno = alunoController.buscaAluno(scanner.nextLine());
                    if (aluno != null) {
                        alunoController.atualizaAluno(aluno);
                    } else {
                        System.out.println("\nCPF invalido!\n");
                    }
                    break;
                case "4":
                    System.out.println("Insira o CPF do aluno desejado: ");
                    aluno = alunoController.buscaAluno(scanner.nextLine());
                    if (aluno != null) {
                        alunoController.deletaAluno(aluno);
                    } else {
                        System.out.println("\nCPF invalido!\n");
                    }
                    break;
                default:
                    System.out.println("\nOpção invalida!\n");
            }
        } while (!opcaoMenu.equals("0"));
    }
}

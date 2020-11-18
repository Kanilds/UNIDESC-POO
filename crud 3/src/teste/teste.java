package teste;

import controller.AlunoController;
import modal.Aluno;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {

        int qtdAluno;
        String opcaoMenu, qtd, cont;

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        do {
            System.out.println("\n====MENU DE OPÇÕES====\n");
            System.out.println("1) Adicionar novo aluno!");
            System.out.println("2) Listar aluno!");
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
                    for(Aluno a: alunoController.buscaAluno()){
                        System.out.println(a.getNome() + " " + a.getCpf());
                    }
                    break;
                case "3":
                    System.out.println("Insira o CPF do aluno: ");
                    String cpf = scanner.nextLine();
                    if (alunoController.buscaAluno() != null) {

                        System.out.println("Informe o novo Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o novo Curso: ");
                        String curso = scanner.nextLine();
                        alunoController.atualizaAluno(cpf, nome, curso);

                        System.out.println("\n\nAluno Atualizado\n\n");
                    } else
                        System.out.println("\n\nAluno não encontrado ou CPF inválido\n\n");
                    break;

                case "4":
                    System.out.println("Insira o CPF do aluno: ");
                    cpf = scanner.nextLine();
                    if (alunoController.buscaAluno() != null) {
                        alunoController.deletaAluno(cpf);
                        System.out.println("\n\nAluno deletado com sucesso!\n\n");
                    }
                    else
                        System.out.println("\n\nAluno não encontrado ou CPF inválido\n\n");

                    break;

                default:
                    System.out.println("\nOpção invalida!\n");
            }
        } while (!opcaoMenu.equals("0"));
    }
}

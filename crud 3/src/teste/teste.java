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
                    cont = alunoController.buscaAluno(aluno.getCpf());
                    if (cont != null) {
                        System.out.println("\n\nArquivo encontrado com sucesso:\n\n");
                        System.out.println(cont);
                    } else
                        System.out.println("\n\narquivo não existente\n\n");
                    break;
                case "3":
                    if (alunoController.buscaAluno(aluno.getCpf()) != null) {
                        alunoController.deletaAluno(aluno);

                        System.out.println("Quantos novos alunos deseja adicionar? ");
                        qtd = scanner.nextLine();
                        qtdAluno = Integer.parseInt(qtd);

                        for (int i = 0; i < qtdAluno; i++) {
                            aluno = new Aluno();

                            System.out.println("Informe o Nome: ");
                            aluno.setNome(scanner.nextLine());
                            System.out.println("Informe o CPF: ");
                            aluno.setCpf(scanner.nextLine());
                            System.out.println("Informe o Curso: ");
                            aluno.setCurso(scanner.nextLine());
                            alunoController.atualizaAluno(aluno);
                            System.out.println("\n\nAluno adicionado com sucesso!\n\n");
                        }
                        System.out.println("\n\nArquivo 'alunos' alterado com sucesso!\n\n");
                    } else
                        System.out.println("\n\nERROR arquivo não existente\n\n");
                    break;
                case "4":
                    if (alunoController.deletaAluno(aluno))
                        System.out.println("\n\nArquivo 'alunos' deletado com sucesso!\n\n");
                    else
                        System.out.println("\n\nERROR arquivo não existente\n\n");
                    break;
                default:
                    System.out.println("\nOpção invalida!\n");
            }
        } while (!opcaoMenu.equals("0"));
    }
}

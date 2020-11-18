package teste;

import controller.AlunoController;
import entidades.Aluno;

import java.util.Scanner;

public class testAluno {

    public static void main(String[] args) {

        int qntAluno;
        String opcao, temp, cont;

        Aluno aluno;
        Scanner scan = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        do {
            System.out.println("\n====MENU DE OPÇÕES====\n");
            System.out.println("1) Adicionar novos alunos!");
            System.out.println("2) Buscar aluno!");
            System.out.println("3) Atualizar alunos!");
            System.out.println("4) Deletar alunos!");
            System.out.println("0) Sair!");
            opcao = scan.nextLine();

            switch (opcao) {
                case "0":
                    System.out.println("\n\nENCERRANDO\n\n");
                    break;
                case "1":
                    System.out.println("Quantos alunos deseja adicionar? ");
                    temp = scan.nextLine();
                    qntAluno = Integer.parseInt(temp);

                    for (int i = 0; i < qntAluno; i++) {
                        aluno = new Aluno();

                        System.out.println("Informe o Nome: ");
                        aluno.setNome(scan.nextLine());
                        System.out.println("Informe o CPF: ");
                        aluno.setCpf(scan.nextLine());
                        System.out.println("Informe o Curso: ");
                        aluno.setCurso(scan.nextLine());

                        alunoController.criaAluno(aluno);

                        System.out.println("\n\nAdicionado com sucesso!\n\n");
                    }
                    break;
                case "2":
                    System.out.println("Informe o CPF do aluno deseja buscar: ");
                    cont = alunoController.buscaAluno(scan.nextLine());
                    if (cont != null) {
                        System.out.println("\n\nEncontrado com sucesso:\n\n");
                        System.out.println(cont);
                    } else
                        System.out.println("\n\nAluno não encontrado ou CPF inválido\n\n");
                    break;
                case "3":
                    System.out.println("Informe o CPF do aluno deseja atualizar: ");
                    String cpf = scan.nextLine();
                    if (alunoController.buscaAluno(cpf) != null) {
                        System.out.println("Informe o novo Nome: ");
                        String nome = scan.nextLine();
                        System.out.println("Informe o novo Curso: ");
                        String curso = scan.nextLine();

                        alunoController.atualizaAluno(cpf, nome, curso);

                        System.out.println("\n\nAluno atualizado com sucesso!\n\n");
                    } else
                        System.out.println("\n\nAluno não encontrado ou CPF inválido\n\n");
                    break;
                //Deletar alunos!
                case "4":
                    System.out.println("Informe o CPF do aluno deseja atualizar: ");
                    cpf = scan.nextLine();
                    //Verificando se existe algum aluno com este CPF
                    if (alunoController.buscaAluno(cpf) != null) {
                        //Chamada do metodo DELETE
                        alunoController.deletaAluno(cpf);
                        System.out.println("\n\nAluno deletado com sucesso!\n\n");
                    } else {
                        //Mensagem de erro
                        System.out.println("\n\nAluno não encontrado ou CPF inválido\n\n");
                    }
                    break;
                //Nenhuma das opções
                default:
                    //Mensagem de erro
                    System.out.println("\n\nOpção invalida!\n\n");
            }
            //Verificação se a opção "Sair" foi selecionada
        } while (!opcao.equals("0"));
    }
}

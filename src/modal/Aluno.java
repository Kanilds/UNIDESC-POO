package modal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Aluno {

    private String cpf;
    private String nome;
    private String matricula;
    private String curso;

    //MÉTODO DE CRIAÇÃO DA MATRICULA
    public void criaMatricula(){
        Date date = new Date();

        DateFormat formatData = new SimpleDateFormat("YYYYMMddHHmmss");
        String dataDaMatricula = formatData.format(date);

        Random random = new Random();

        Integer matricula = random.nextInt((100 - 1) + 1) + 1;

        String id = String.format("%02d", matricula);

        matricula = random.nextInt((2 - 1) + 1) + 1;

        String semetre = String.format("%02d", matricula);

        this.matricula = dataDaMatricula + "-" + id + "-" + semetre;

    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula() {
        criaMatricula();
    }
}

package modal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

        DateFormat formatData = new SimpleDateFormat("yyyyMMddHHmmss");
        String dataDaMatricula = formatData.format(date);

        Random random = new Random();

        int matricula = random.nextInt((100 - 1) + 1) + 1;

        String id = String.format("%02d", matricula);
        LocalDateTime dateTime = LocalDateTime.now();
        int mes = dateTime.getMonthValue();
        String semestre = "01";
        if (mes > 6)
            semestre = "02";

        this.matricula = dataDaMatricula + "-" + id + "-" + semestre;
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

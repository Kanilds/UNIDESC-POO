package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Aluno {

    private String cpf;
    private String nome;
    private String curso;
    private String matricula;

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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula() {

        Date date = new Date();

        DateFormat formatador = new SimpleDateFormat("yyyyMMddHHmmss");
        String dataMatricula = formatador.format(date);

        Random random = new Random();

        Integer aleatorio = random.nextInt((99 - 1) + 1) + 1;

        String codigo = String.format("%02d", aleatorio);

        LocalDateTime dateTime = LocalDateTime.now();
        int mes = dateTime.getMonthValue();

        String semestre = "01";

        if (mes > 6)
            semestre = "02";

        this.matricula = dataMatricula + "-" + codigo + "-" + semestre;
    }
}

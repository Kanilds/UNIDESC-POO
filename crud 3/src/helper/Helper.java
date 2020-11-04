package helper;

import modal.Aluno;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Helper {
    private final String cam = "alunos.csv";
    private static Helper inst = null;


    public static Helper getInst() {

        if (inst == null)
            inst = new Helper();
        return inst;
    }

    public void armazenarCSV(Aluno aluno) {

        StringBuilder bd = new StringBuilder();
        String separador = ",";
        bd.append(aluno.getNome())
                .append(separador)
                .append(aluno.getCpf())
                .append(separador)
                .append(aluno.getCurso())
                .append(separador)
                .append(aluno.getMatricula());

        try {
            FileWriter fw = new FileWriter(cam, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(bd.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerArquivoCSV() {

        File file = new File(cam);

        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (FileNotFoundException exception) {
            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public boolean deletarCSV() {

        File file = new File(cam);
        return file.delete();
    }
}

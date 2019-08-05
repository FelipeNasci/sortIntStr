package infra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TXT implements CRUD {

    public String diretorio = "src/files/originals/";

    private TXT() {
    }

    public static TXT txt = null;

    public static TXT getInstance() {

        if (txt == null) {
            txt = new TXT();
        }
        return txt;
    }

    @Override
    public boolean criar(String nomeArquivo, String content) {


            try {

                FileWriter path = new FileWriter("src/files/modified/" + nomeArquivo + ".txt");
                BufferedWriter buff = new BufferedWriter(path);

                buff.write(content);
                //buff.newLine();

                buff.close();

            } catch (IOException e) {
                System.err.println("Erro ao gravar arquivo:" + " - " + nomeArquivo + "em: " + diretorio);
            }

     

        return true;
    }

    
    @Override
    public String ler(String path) {
        try {

            Path caminho = Paths.get(path);

            byte[] text = Files.readAllBytes(caminho);

            String str = new String(text);

            text.clone();

            return str;

        } catch (FileNotFoundException fnfex) {
        } catch (IOException ioex) {
        }
        return null;

    }
    

    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package infra;

public interface CRUD {

    public boolean criar(String nomeArquivo, String content);

    public String ler(String nomeArquivo);

    public boolean atualizar();

    public boolean excluir();
}

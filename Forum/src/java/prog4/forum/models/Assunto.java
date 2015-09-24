package prog4.forum.models;

import java.util.List;

/**
 *
 * @author Manu
 */
public class Assunto {
    private String nome;
    private List<Topico> topicos;
    private int id;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}

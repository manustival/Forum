package prog4.forum.models;

import java.sql.Date;

/**
 *
 * @author Manu
 */
public class Topico {
    private int id;
    private String nome;
    private String assunto;
    private String autor;
    private int qntTopicos;
    private int qntMensagem;
    private Date dataMensagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQntTopicos() {
        return qntTopicos;
    }

    public void setQntTopicos(int qntTopicos) {
        this.qntTopicos = qntTopicos;
    }

    public int getQntMensagem() {
        return qntMensagem;
    }

    public void setQntMensagem(int qntMensagem) {
        this.qntMensagem = qntMensagem;
    }

    public Date getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Date dataMensagem) {
        this.dataMensagem = dataMensagem;
    }
    
    
    
    
    
    
}

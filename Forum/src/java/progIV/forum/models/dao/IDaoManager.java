package progIV.forum.models.dao;

public interface IDaoManager {
  
    void iniciar() throws DaoException;
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    
    
    UsuarioDAO getUsuarioDAO();
    TopicoDAO getTopicoDAO();
    AssuntoDAO getAssuntoDAO();

}

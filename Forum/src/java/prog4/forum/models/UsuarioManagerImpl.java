package prog4.forum.models;

import progIV.forum.models.dao.IDaoManager;
import progIV.forum.models.dao.JdbcDaoManager;
import progIV.forum.models.dao.UsuarioDAO;

/**
 *
 * @author Manu
 */
public class UsuarioManagerImpl implements UsuarioManager{

    @Override
    public Usuario cadastrar(Usuario usuario) {
        IDaoManager manager;
        manager = new JdbcDaoManager();
        try{
            manager.iniciar();
            UsuarioDAO dao = manager.getUsuarioDAO();
            Usuario user;
            user = dao.inserir(usuario);
            manager.confirmarTransação();
            manager.encerrar();
            return user;
            
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
        
    }


    
    
}

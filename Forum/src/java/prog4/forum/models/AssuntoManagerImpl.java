package prog4.forum.models;

import progIV.forum.models.dao.AssuntoDAO;
import progIV.forum.models.dao.IDaoManager;
import progIV.forum.models.dao.JdbcDaoManager;

public class AssuntoManagerImpl implements AssuntoManager {
    
    @Override
    public Assunto inserir(Assunto assunto) {
        IDaoManager manager;
        manager = new JdbcDaoManager();
        
        try{
            manager.iniciar();
            AssuntoDAO dao = manager.getAssuntoDAO();
            Assunto a;
            a = dao.inserir(assunto);
            manager.confirmarTransação();
            manager.encerrar();
            
            return a;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
}

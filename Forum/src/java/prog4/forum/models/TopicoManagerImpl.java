
package prog4.forum.models;

import progIV.forum.models.dao.IDaoManager;
import progIV.forum.models.dao.JdbcDaoManager;
import progIV.forum.models.dao.TopicoDAO;


public class TopicoManagerImpl implements TopicoManager{

    @Override
    public Topico inserir(Topico topico) {
        IDaoManager manager;
        manager = new JdbcDaoManager();
        
        try{
            manager.iniciar();
            TopicoDAO dao = manager.getTopicoDAO();
            Topico t;
            t = dao.inserir(topico);
            manager.confirmarTransação();
            manager.encerrar();
            return t;
            
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
        
    }
    
}

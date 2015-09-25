
package progIV.forum.models.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcDaoManager implements IDaoManager{
    private Connection conexao;
    private JdbcUsuarioDAO usuarioDAO;
    private JdbcTopicoDAO topicoDAO;
    private JdbcAssuntoDAO assuntoDAO;
    
    public JdbcDaoManager()//ver se precisa instanciar aqui mesmo
    {
        usuarioDAO = new JdbcUsuarioDAO();
        topicoDAO = new JdbcTopicoDAO();
        assuntoDAO = new JdbcAssuntoDAO();
    }
    
    @Override
    public void iniciar() throws DaoException {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/";
            //conexao = DriverManager.getConnection(url, "root", ""); //ver o erro da linha
            conexao.setAutoCommit(false);
            
            
        }
        catch( Exception ex )
        {
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }    
    }

    @Override
    public void confirmarTransação() {
        try{
            conexao.commit();
        } catch (SQLException ex){
            throw new DaoException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public void abortarTransação() {
        try{
            conexao.rollback();
        } catch (SQLException ex){
            throw new DaoException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
    
    public TopicoDAO getTopicoDAO(){
        return topicoDAO;
    }
    
    public AssuntoDAO getAssuntoDAO(){
        return assuntoDAO;
    }
    
    
}

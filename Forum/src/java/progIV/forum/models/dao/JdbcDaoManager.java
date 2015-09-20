
package progIV.forum.models.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcDaoManager implements IDaoManager{
    private Connection conexao;
    private JdbcUsuarioDAO usuarioDAO;
    
    public JdbcDaoManager()
    {
        usuarioDAO = new JdbcUsuarioDAO();
    }
    
    @Override
    public void iniciar() throws DaoException {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/";
            //conexao = DriverManager.getConnection(url, "root", "root");
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
    
}

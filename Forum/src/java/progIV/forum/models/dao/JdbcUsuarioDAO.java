package progIV.forum.models.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import prog4.forum.models.Usuario;

/**
 *
 * @author Manu
 */
public class JdbcUsuarioDAO implements UsuarioDAO{

    private Connection conexão;
    
    public void setConexão(Connection conexão)
    {
        this.conexão = conexão;
    }
    
    @Override
    public Usuario inserir(Usuario usuario) {
        String sql;
        sql= "INSERT INTO usuario ("
                + "nome,"
                + "senha)"
                + "VALUES (?,?)";
        
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) conexão.prepareStatement(sql); //ver esta linha
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.executeUpdate();
            
            return usuario; 
        }catch (SQLException ex)
        {
            throw new DaoException("Ocorreu um erro ao inserir uma Usuario" + ex.getMessage());
        }
        
    }
    
}

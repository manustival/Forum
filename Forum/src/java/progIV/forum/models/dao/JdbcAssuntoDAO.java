package progIV.forum.models.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import prog4.forum.models.Assunto;


public class JdbcAssuntoDAO implements AssuntoDAO {
    private Connection conexão;
    
    public void setConexão(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public Assunto inserir(Assunto assunto) {
        String sql;
        sql = "INSERT INTO assunto ("
                + "nome)"
                + "VALUES (?)";
        
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) conexão.prepareStatement(sql);
            ps.setString(1, assunto.getNome());
            ps.executeQuery();
            
            return assunto;
                 
        }catch(SQLException ex){
            throw new DaoException("Ocorreu um erro ao inserir um Assunto" + ex.getMessage());
        }
    }
    
}

package progIV.forum.models.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import prog4.forum.models.Topico;


public class JdbcTopicoDAO implements TopicoDAO{
    private Connection conexão;
    
    public void setConexão(Connection conexão)
    {
        this.conexão = conexão;
    }
    
    @Override
    public Topico inserir(Topico topico) {
        String sql;
        sql = "INSERT INTO topico ("
                + "nome,"
                + "assunto,"
                + "autor)"
                + "VALUES (?,?,?)";
        
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) conexão.prepareStatement(sql);
            ps.setString(1, topico.getNome());
            ps.setString(2, topico.getAssunto());
            ps.setString(3, topico.getAutor());
            ps.executeQuery();
            
            return topico;
        }catch(SQLException ex){
            throw new DaoException("Ocorreu um erro ao inserir um Topico" + ex.getMessage());
        }
    }
    
}

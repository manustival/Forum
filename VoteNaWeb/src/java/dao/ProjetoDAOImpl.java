/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Projeto;

/**
 *
 * @author machado.alves
 */
public class ProjetoDAOImpl implements ProjetoDAO{
    private Connection conn;
    
    public ProjetoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Projeto editar(Projeto projeto) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE projeto SET votos_sim = (?), votos_nao = (?) WHERE id = (?)");
            stmt.setInt(1, projeto.getVotosSim());
            stmt.setInt(2, projeto.getVotosNao());
            stmt.setInt(3, projeto.getId());
            stmt.executeUpdate();
            return projeto;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao editar Projeto" );
        }
    }
    @Override
    public Projeto findById(int id) {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conn.prepareStatement("SELECT * FROM projeto WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Projeto p = null;
            while (rs.next()) {
                p = populateObject(rs);
            }
            return p;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar o ID " + id + " em Projeto");
        }
    }

    @Override
    public List<Projeto> findAll() {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conn.prepareStatement("SELECT * FROM projeto");
            rs = stmt.executeQuery();
            List<Projeto> projetos = new ArrayList<Projeto>();
            Projeto p = null;
            while (rs.next()) {
                p = populateObject(rs);
                projetos.add(p);
            }
            return projetos;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar em Projeto");
        }
    }
    
    private Projeto populateObject(ResultSet rs) throws SQLException {
        Projeto projeto = new Projeto();
        projeto.setId(rs.getInt("id"));
        projeto.setTitulo(rs.getString("titulo"));
        projeto.setDescricao(rs.getString("descricao"));
        projeto.setVotosSim(rs.getInt("votos_sim"));
        projeto.setVotosNao(rs.getInt("votos_nao"));

        return projeto;
    }

}

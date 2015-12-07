/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import dao.ProjetoDAO;
import dao.ProjetoDAOImpl;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author caroline
 */
public class DAOManagerImpl implements DAOManager {

    private Connection conn;
    private ProjetoDAO projetoDao;

    @Override
    public void iniciar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/projeto";
            conn = DriverManager.getConnection(url, "root", "root");
            conn.setAutoCommit(false);
            //instanciar DAOs das Models
            projetoDao = new ProjetoDAOImpl(conn);
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao conectar ao banco de dados:" + ex.getMessage());
        }
    }

    @Override
    public void encerrar() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {

        }
    }

    @Override
    public void confirmarTransação() {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new DAOException("Ocorreu um erro ao confirmar a transação");
        }
    }

    @Override
    public void abortarTransação() {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            throw new DAOException("Ocorreu um erro ao abordar a transição");
        }
    }

    //criar metodos das DAOs models
    @Override
    public ProjetoDAO getProjetoDAO() {
        return projetoDao;
    }
}

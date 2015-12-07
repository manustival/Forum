/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import dao.ProjetoDAO;

/**
 *
 * @author caroline
 */
public interface DAOManager {
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    
    //criar metodos das DAOs models
    ProjetoDAO getProjetoDAO();
}

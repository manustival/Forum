/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.manager;

import dao.ProjetoDAO;
import dao.utils.DAOManager;
import dao.utils.DAOManagerImpl;
import java.util.List;
import models.Projeto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author machado.alves
 */
@Repository
public class ProjetoManagerImpl implements ProjetoManager{
    @Override
    public Projeto editar(Projeto projeto) {
        DAOManager manager = new DAOManagerImpl();
        try{
            manager.iniciar();
            ProjetoDAO pd = manager.getProjetoDAO();
            pd.editar(projeto);
            manager.confirmarTransação();
            manager.encerrar();
            return projeto;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
    @Override
    public Projeto findById(int id) {
        DAOManager manager = new DAOManagerImpl();
        try{
            manager.iniciar();
            ProjetoDAO pd = manager.getProjetoDAO();
            Projeto projeto = pd.findById(id);
            manager.confirmarTransação();
            manager.encerrar();
            return projeto;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
    @Override
    public List<Projeto> findAll(){
        DAOManager manager = new DAOManagerImpl();
        try{
            manager.iniciar();
            ProjetoDAO pd = manager.getProjetoDAO();
            List<Projeto> projetos = pd.findAll();
            manager.confirmarTransação();
            manager.encerrar();
            return projetos;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
}

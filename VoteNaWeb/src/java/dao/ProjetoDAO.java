/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Projeto;

/**
 *
 * @author machado.alves
 */
public interface ProjetoDAO {
    public Projeto editar(Projeto projeto);
    public Projeto findById(int id);
    public List<Projeto> findAll();
}

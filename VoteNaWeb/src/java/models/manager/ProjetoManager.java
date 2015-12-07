/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.manager;

import java.util.List;
import models.Projeto;

/**
 *
 * @author machado.alves
 */
public interface ProjetoManager {
    public Projeto editar(Projeto projeto);
    public Projeto findById(int id);
    public List<Projeto> findAll();
}

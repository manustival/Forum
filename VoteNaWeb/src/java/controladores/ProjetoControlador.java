/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import models.Projeto;
import models.manager.ProjetoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author machado.alves
 */
@Controller
public class ProjetoControlador {
    @Autowired
    private ProjetoManager repositorio;
    
    @RequestMapping("/projetos")
    public ModelAndView listarProjetos(){
        ModelAndView mav;
        mav = new ModelAndView("listar-projetos");
        
        List<Projeto> projetos;
        projetos = repositorio.findAll();
        
        mav.addObject("projetos", projetos); // igual o request.setAttribute
        
        return mav;
    }
    
    @RequestMapping("/projeto/{id}")
    public String obterProjeto(@PathVariable("id") int id, Model model){
        Projeto projeto = repositorio.findById(id);
        model.addAttribute("votarProjeto", projeto);
        return "projeto";
    }
    
    @RequestMapping("/votar/{id}/{valor}")
    public String votarProjeto(@PathVariable("id") int id, @PathVariable("valor") int valor){
        Projeto projeto = repositorio.findById(id);
        
        int votosSim = projeto.getVotosSim();
        int votosNao = projeto.getVotosNao();
        
        //voto sim
        if(valor == 1){
            projeto.setVotosSim(votosSim+1);
            projeto.setVotosNao(votosNao);
        }
        
        //voto não
        if(valor == 2){
            projeto.setVotosNao(votosNao+1);
            projeto.setVotosSim(votosSim);
        }
        
        repositorio.editar(projeto);
        
        return "redirect:/projetos";
    }
    
}

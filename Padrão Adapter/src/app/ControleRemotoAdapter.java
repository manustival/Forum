/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author machado.alves
 */
public class ControleRemotoAdapter implements ControleDecoder {
    
    private ControleRemoto controle;
    
    public ControleRemotoAdapter (ControleRemoto controle){
        this.controle = controle;
    }
    
    @Override
    public void ativar() {
        controle.on();
    }
    
}

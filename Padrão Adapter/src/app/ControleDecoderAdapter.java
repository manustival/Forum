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
public class ControleDecoderAdapter implements ControleRemoto{
    private ControleDecoder controle;
    
    public ControleDecoderAdapter (ControleDecoder controle){
        this.controle = controle;
    }
    
    @Override
    public void on() {
        controle.ativar();
    }
    
}

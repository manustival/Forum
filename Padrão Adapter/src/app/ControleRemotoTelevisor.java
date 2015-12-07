package app;


public class ControleRemotoTelevisor implements ControleRemoto{

    @Override
    public void on() {
        System.out.println("Ligou com o controle do televisor");
    }
}

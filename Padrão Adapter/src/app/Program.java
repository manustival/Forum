package app;
public class Program {

    public static void main(String[] args) {
        Telespectador usu;
        usu = new Telespectador();
        usu.ligar(new ControleRemotoTelevisor());
    }
}

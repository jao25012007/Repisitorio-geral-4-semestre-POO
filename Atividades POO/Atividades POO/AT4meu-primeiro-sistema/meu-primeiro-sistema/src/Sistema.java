public class Sistema {
    public static void main(String[] args) {
        Carro meuCarro = new Carro();

        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");
        meuCarro.setVelocidade(-500);

        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Cor: " + meuCarro.getCor());
        System.out.println("Velocidade: " + meuCarro.getVelocidade() + " km/h");
    }
}

public class Cliente extends Pessoa {
    private double saldo;

    public Cliente(String nome, int idade, double saldo) {
        // construtor da classe base (Super classe = Pessoa)
        super(nome, idade); 
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    // void = nada, sem retorno
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

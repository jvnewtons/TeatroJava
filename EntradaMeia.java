class EntradaMeia extends Entrada {
    public EntradaMeia(int numeroDoAssento) {
        super(numeroDoAssento);
    }

    public double calculaValor(double preco) {
        return preco / 2;
    }
}
class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroDoAssento) {
        super(numeroDoAssento);
    }

    public double calculaValor(double preco) {
        return preco * 0.4;
    }
}

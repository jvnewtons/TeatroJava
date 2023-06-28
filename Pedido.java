import java.util.List;
import java.util.ArrayList;

class Pedido {
    private List<Entrada> entradas;

    public Pedido() {
        this.entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public double calculaValorTotal(double preco) {
        double valorTotal = 0;
        for (Entrada entrada : entradas) {
            valorTotal += entrada.calculaValor(preco);
        }
        return valorTotal;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }
}

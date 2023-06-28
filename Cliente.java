import java.util.List;
import java.util.ArrayList;

class Cliente {
    private String nome;
    private String cpf;
    private List<Entrada> entradas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.entradas = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionaPedido(Pedido pedido) {
        entradas.addAll(pedido.getEntradas());
    }
}
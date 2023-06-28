import java.util.List;
import java.util.ArrayList;

public class Teatro {
    private List<Cliente> clientes;
    private List<Espetaculo> espetaculos;
    private Pedido carrinho;
    private Espetaculo espetaculoSelecionado;

    public Teatro() {
        clientes = new ArrayList<>();
        espetaculos = new ArrayList<>();
        carrinho = null;
        espetaculoSelecionado = null;
    }

    public void cadastrarEspetaculo(Espetaculo espetaculo) {
        espetaculos.add(espetaculo);
        System.out.println("Espetáculo cadastrado com sucesso!");
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void apresentaEspetaculos() {
        System.out.println("* ESPETÁCULOS DISPONÍVEIS *");
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.println((i + 1) + ") " + espetaculos.get(i));
        }
    }

    public void selecionaEspetaculo(int numero) {
        if (numero > 0 && numero <= espetaculos.size()) {
            espetaculoSelecionado = espetaculos.get(numero - 1);
            espetaculoSelecionado.apresentaAssentos();
        } else {
            System.out.println("Escolha inválida!");
        }
    }

    public Espetaculo getEspetaculoSelecionado() {
        return espetaculoSelecionado;
    }

    public void novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado != null) {
            Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);
            carrinho.adicionaEntrada(entrada);
        } else {
            System.out.println("Nenhum espetáculo selecionado!");
        }
    }

    public double finalizaCompra(String cpf) {
        if (carrinho != null && espetaculoSelecionado != null) {
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getCpf().equals(cpf)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                cliente.adicionaPedido(carrinho);
                double valorTotal = carrinho.calculaValorTotal(espetaculoSelecionado.getPreco());
                carrinho = null;
                espetaculoSelecionado = null;
                return valorTotal;
            } else {
                System.out.println("Cliente não encontrado!");
            }
        } else {
            System.out.println("Nenhuma compra em andamento!");
        }
        return 0.0;
    }
}
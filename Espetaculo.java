class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[][] assentos;

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[5][10];
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (!assentos[i][j]) {
                    System.out.print("XX ");
                } else {
                    System.out.print((i + 1) + "" + (j + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        marcarAssento(assento);
        return new Entrada(assento);
    }

    public double getPreco() {
        return preco;
    }

    public void marcarAssento(int assento) {
        int row = (assento - 1) / 10;
        int col = (assento - 1) % 10;
        assentos[row][col] = false;
    }

    
    public String toString() {
        return nome + " " + data + " " + hora + " R$ " + preco;
    }
}
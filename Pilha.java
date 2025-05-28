public class Pilha {
    private int topo;
    private Documento[] dados;

    public Pilha() {
        this(10);
    }
    
    public Pilha(int capacidade) {
        topo = 0;
        dados = new Documento[capacidade];
    }

    public boolean pilhaVazia() {
        return topo == 0;
    }

    public boolean pilhaCheia() {
        return topo == dados.length;
    }

    public boolean push(Documento elemento) {
        if (pilhaCheia()) return false;
        dados[topo++] = elemento;
        return true;
    }

    public Documento pop() {
        if (pilhaVazia()) return null;
        return dados[--topo];
    }

    public Documento peek() {
        if (pilhaVazia()) return null;
        return dados[topo - 1];
    }

    public void acharArquivo(String s) {
        boolean encontrado = false;
        for (int i = topo - 1; i >= 0; i--) {
            if (dados[i].getNomeA().equals(s)) {
                int posicaoAPartirDoTopo = topo - i;
                System.out.println("\nArquivo encontrado na posição " + posicaoAPartirDoTopo + " a partir do topo da pilha.");
                encontrado = true;
                System.out.println("\nO arquivo foi adcionado a pilha as: "+dados[i].getHorarioInicio()+" e ja esta esperando a "+dados[i].tempoPassado()+" segundos");
            

            }
        }
        if (!encontrado) {
            System.out.println("\nArquivo não encontrado na pilha.");
        }
    }


    @Override
    public String toString() {
        if (pilhaVazia()) return "Pilha vazia";
        StringBuilder sb = new StringBuilder();
        for (int i = topo - 1; i >= 0; i--) {
            sb.append(dados[i]).append("\n");
        }
        return sb.toString();
    }
}

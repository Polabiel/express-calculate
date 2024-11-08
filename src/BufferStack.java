public class BufferStack<X> {
    private class No {
        private X dado;
        private No proximo;

        public No(X dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private No topo = null;
    private final int tamanhoInicial;
    private int ultimo = -1; // vazio

    public BufferStack(int tamanhoInicial) throws Exception {
        if (tamanhoInicial <= 0)
            throw new Exception("Tamanho inválido");

        this.tamanhoInicial = tamanhoInicial;
    }

    public BufferStack() {
        this.tamanhoInicial = 20;
    }

    public void guardeUmItem(X x) throws Exception {
        if (x == null)
            throw new Exception("Falta o que guardar");

        if (isCheia())
            throw new Exception("Ops, encheu");

        No novoNo = new No(x);
        novoNo.proximo = this.topo;
        this.topo = novoNo;
        this.ultimo++;
    }

    public X recupereUmItem() throws Exception {
        if (isVazia())
            throw new Exception("Nada a recuperar");

        return this.topo.dado;
    }

    public void removaUmItem() throws Exception {
        if (isVazia())
            throw new Exception("Nada a remover");

        this.topo = this.topo.proximo;
        this.ultimo--;
    }

    public boolean isCheia() {
        return (this.ultimo + 1) == this.tamanhoInicial;
    }

    public boolean isVazia() {
        return this.topo == null;
    }

    public String toString() {
        String ret = (this.ultimo + 1) + " elemento(s)";

        if (this.topo != null)
            ret += ", sendo o topo " + this.topo.dado;

        return ret;
    }
}

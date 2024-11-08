public class Pilha<X> {
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
    private int ultimo = -1; //vazio

    public Pilha(int tamanhoInicial) throws PilhaException {
        if (tamanhoInicial <= 0)
            throw new PilhaException("Tamanho inválido");

        this.tamanhoInicial = tamanhoInicial;
    }

    public Pilha() {
        this.tamanhoInicial = 20;
    }

    public void guardeUmItem(X x) throws PilhaException {
        if (x == null)
            throw new PilhaException("Falta o que guardar");

        if (isCheia())
            throw new PilhaException("Ops, encheu");

        No novoNo = new No(x);
        novoNo.proximo = this.topo;
        this.topo = novoNo;
        this.ultimo++;
    }

    public X recupereUmItem() throws PilhaException {
        if (isVazia())
            throw new PilhaException("Nada a recuperar");

        return this.topo.dado;
    }

    public void removaUmItem() throws PilhaException {
        if (isVazia())
            throw new PilhaException("Nada a remover");

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

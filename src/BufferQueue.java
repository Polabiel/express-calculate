import java.util.EmptyStackException;

public class BufferQueue<X> {

    private class No {
        private X dado;
        private No proximo;

        public No(X dado) {
            this.dado = dado;
            this.proximo = null;
        }

        @Override
        public String toString() {
            return String.format("No [dado = '%s'\n%s", dado.toString(), proximo);
        }
    }

    private No elemento;
    private No fim;
    private final int tamanhoInicial;
    private int ultimo = -1; // vazio

    public BufferQueue(int tamanhoInicial) throws Exception {
        if (tamanhoInicial <= 0)
            throw new Exception("Tamanho inválido");

        this.tamanhoInicial = tamanhoInicial;
    }

    public BufferQueue() {
        this.tamanhoInicial = 20;
    }

    public void guardeUmItem(X x) throws Exception {
        if (x == null)
            throw new Exception("Falta o que guardar");

        if (isCheia())
            throw new Exception("Ops, encheu");

        No novoNo = new No(x);

        if (this.elemento == null) {

            this.elemento = novoNo;
            this.fim = novoNo;
        } else {

            this.fim.proximo = novoNo;
            this.fim = novoNo;
        }

        this.ultimo++;
    }

    public X recupereUmItem() throws EmptyStackException {
        if (isVazia())
            throw new EmptyStackException();

        return this.elemento.dado;
    }

    public void removaUmItem() throws EmptyStackException {
        if (isVazia())
            throw new EmptyStackException();

        this.elemento = this.elemento.proximo;
        this.ultimo--;

        if (this.elemento == null) {
            this.fim = null;
        }
    }

    private boolean isCheia() {
        return (this.ultimo + 1) == this.tamanhoInicial;
    }

    private boolean isVazia() {
        return this.elemento == null;
    }

    @Override
    public String toString() {
        return "BufferQueue [" + elemento + "]";
    }

}

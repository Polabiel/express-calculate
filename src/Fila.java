package express-calculate;

public class Fila<X> {

    private class No {
        private X dado;
        private No proximo;

        public No(X dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private No elemento;              
    private No fim;                    
    private final int tamanhoInicial;  
    private int ultimo = -1;       //vazio    
    
    public Fila(int tamanhoInicial) throws InvalidSizeException 
    {
        if (tamanhoInicial <= 0)
            throw new InvalidSizeException("Tamanho inválido");

        this.tamanhoInicial = tamanhoInicial;
    }

   
    public Fila() {
        this.tamanhoInicial = 20;
    }
 
    public void guardeUmItem(X x) throws InvalidItemException, FullQueueException  
    {
        if (x == null)
            throw new InvalidItemException("Falta o que guardar");

        if (isCheia())
            throw new FullQueueException("Ops, encheu");

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

    public X recupereUmItem() throws EmptyQueueException  
    {
        if (isVazia())
            throw new EmptyQueueException("Nada a recuperar");

        return this.elemento.dado;
    }


    public void removaUmItem() throws EmptyQueueException  
    {
        if (isVazia())
            throw new EmptyQueueException("Nada a remover");

   
        this.elemento = this.elemento.proximo;
        this.ultimo--;

   
        if (this.elemento == null) {
            this.fim = null;
        }
    }

    public boolean isCheia() 
    {
        return (this.ultimo + 1) == this.tamanhoInicial;
    }


    public boolean isVazia()
     {
        return this.elemento == null;
    }

    public String toString() 
    {
        String ret = (this.ultimo + 1) + " elemento(s)";

        if (this.fim != null)
            ret += ", sendo o último " + this.fim.dado;

        return ret;
    }
}

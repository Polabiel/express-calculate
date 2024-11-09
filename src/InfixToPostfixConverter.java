import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

class InfixToPostfixConverter {

  private StringTokenizer data;
  private BufferQueue<String> queue;
  private BufferStack<String> stack;

  public InfixToPostfixConverter(StringTokenizer tokens) throws Exception {

    if (tokens == null) {
      throw new Exception("token is not valid!");
    }

    this.data = tokens;
    this.stack = new BufferStack<>();
    this.queue = new BufferQueue<>();

  }

  public void processTokens() {

    boolean isparameter = false;

    while (data.hasMoreTokens()) {
      String token = data.nextToken();

      try {

        // ! Não quero dizer nada não, mas pelo o que eu entendi. temos que verificar se tem mais de 2 operadores dentro do () e caso realmente tenha dai sim você coloca na fila e dessa forma, você vai conseguir fazer um sucesso muito foda. foi o que ela disse
        String[] operators = { "+", "-", "*", "/", "^", "(", ")" };

        if (!Arrays.asList(operators).contains(token)) {
          queue.guardeUmItem(token);
        } else {
          stack.guardeUmItem(token);
          // ? A pergunta que não quer me calar, como CARALHOS eu vou conseguir definir o que está dentro de () e ainda por cima mesclar isso com o fato dos operadores sem dessa forma, acho que tenho que olhar para o que realmente pode entrar de acordo com aquela planilha do professor.
          if (Arrays.asList("(", ")").contains(token)) {
            isparameter = !isparameter;

          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }

    System.out.println(queue.toString() + "\n\n" + stack.toString());
  }

  public BufferQueue<String> getQueue() {
    return this.queue;
  }

  public void setQueue(BufferQueue<String> queue) {
    this.queue = queue;
  }

  public BufferStack<String> getStack() {
    return this.stack;
  }

  public void setStack(BufferStack<String> stack) {
    this.stack = stack;
  }

  public StringTokenizer getData() {
    return data;
  }

  public void setData(StringTokenizer data) {
    this.data = data;
  }

  @Override
  public int hashCode() {
    int hash = 13;
    hash = 29 * hash + Objects.hashCode(this.data);
    hash = 29 * hash + Objects.hashCode(this.queue);
    hash = 29 * hash + Objects.hashCode(this.stack);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final InfixToPostfixConverter other = (InfixToPostfixConverter) obj;
    if (!Objects.equals(this.data, other.data)) {
      return false;
    }
    if (!Objects.equals(this.queue, other.queue)) {
      return false;
    }
    return Objects.equals(this.stack, other.stack);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("InfixToPostfixConverter{");
    sb.append("data=").append(data);
    sb.append(", queue=").append(queue);
    sb.append(", stack=").append(stack);
    sb.append('}');
    return sb.toString();
  }

}
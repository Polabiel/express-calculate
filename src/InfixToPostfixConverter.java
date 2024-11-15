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

  private int precedence(String operator) {
    return switch (operator) {
      case "^" -> 3;
      case "*", "/" -> 2;
      case "+", "-" -> 1;
      case "(", ")" -> 0; // Parênteses não afetam diretamente a precedência
      default -> -1;
    };
  }

  private void handleOperator(String token) throws Exception {
    while (!stack.isVazia() && precedence(stack.recupereUmItem()) >= precedence(token)) {
      String top = stack.removaUmItem();
      if (top.equals("(")) {
        stack.guardeUmItem(top); // Não removemos '(' para não perder contexto
        break;
      }
      queue.guardeUmItem(top);
    }
    stack.guardeUmItem(token);
  }

  public void convertToPostfix() throws Exception {
    while (data.hasMoreTokens()) {
      String token = data.nextToken();
      if (token.equals("(")) {
        stack.guardeUmItem(token);
      } else if (token.equals(")")) {
        while (!stack.isVazia() && !stack.recupereUmItem().equals("(")) {
          queue.guardeUmItem(stack.removaUmItem());
        }
        stack.removaUmItem(); // Remove o parêntese de abertura
      } else if (isOperator(token)) {
        handleOperator(token);
      } else {
        queue.guardeUmItem(token); // Se for um operando, coloca diretamente na fila
      }
    }

    // Desempilha todos os operadores restantes na pilha
    while (!stack.isVazia()) {
      try {
        queue.guardeUmItem(stack.removaUmItem());
      } catch (Exception e) {
      }
    }

    System.out.println(queue.toString());
  }

  private boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
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
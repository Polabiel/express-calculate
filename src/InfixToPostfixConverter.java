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

  public void processTokens() {
    while (data.hasMoreTokens()) {
      String token = data.nextToken();
      try {
        String[] operators = { "+", "-", "*", "/", "^", "(", ")" };

        // Verifica se é um operando
        if (!Arrays.asList(operators).contains(token)) {
          queue.guardeUmItem(token); // Se for um operando, coloca diretamente na fila
        }
        // Se for um parêntese de abertura
        else if (token.equals("(")) {
          stack.guardeUmItem(token); // Empilha o parêntese de abertura
        }
        // Se for um parêntese de fechamento
        else if (token.equals(")")) {
          // Desempilha até encontrar o parêntese de abertura
          while (!stack.isVazia() && !stack.recupereUmItem().equals("(")) {
            queue.guardeUmItem(stack.removaUmItem());
          }
          stack.removaUmItem(); // Remove o parêntese de abertura
        }
        // Caso seja um operador
        else {
          handleOperator(token); // Lida com o operador considerando a precedência
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Esvazia a pilha restante
    while (!stack.isVazia()) {
      try {
        queue.guardeUmItem(stack.removaUmItem());
      } catch (Exception e) {

      }
    }

    // Exibe a fila e a pilha final para verificação
    System.out.println("Expressão Pós-Fixa: " + queue.toString());
    System.out.println("Pilha Final: " + stack.toString());
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
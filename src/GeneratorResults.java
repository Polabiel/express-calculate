
import java.util.Objects;

class GeneratorResults {
  BufferQueue<String> queue;
  BufferStack<String> stack;
  float v1 = 0;
  float v2 = 0;
  String op = "a";

  public GeneratorResults(BufferQueue<String> queue, BufferStack<String> stack) throws Exception {

    this.queue = queue;
    this.stack = stack;
    Float resultado;

    while (!queue.isVazia()) {
      String removido = queue.recupereUmItem();
      if (removido.equals("+") || removido.equals("*") || removido.equals("-") || removido.equals("/")
          || removido.equals("^")) {
        op = removido;
      } else {
        stack.guardeUmItem(removido);
      }
      queue.removaUmItem();
      if (!"a".equals(op) && op != null) {
        v1 = Float.parseFloat(stack.recupereUmItem());
        stack.removaUmItem();
        v2 = Float.parseFloat(stack.recupereUmItem());
        stack.removaUmItem();
        switch (op) {
          case "-" -> {
            resultado = (v1 - v2);
            stack.guardeUmItem(String.valueOf(resultado));
          }
          case "+" -> {
            resultado = (v1 + v2);
            stack.guardeUmItem(String.valueOf(resultado));
          }
          case "*" -> {
            resultado = (v1 * v2);
            stack.guardeUmItem(String.valueOf(resultado));
          }
          case "/" -> {
            resultado = (v1 / v2);
            stack.guardeUmItem(String.valueOf(resultado));
          }
          case "^" -> {
            resultado = (float) (Math.pow(v2, v1));
            stack.guardeUmItem(String.valueOf(resultado));
          }
          default -> throw new IllegalStateException("Unexpected value: " + op);
        }
        op = null;
      }
    }
    if (queue.isVazia()) {
      System.out.println("Queue vazia, o resultado da operação é:");
      System.out.println(stack.recupereUmItem());
    }
    else {
      throw new Exception("Queue não está vazia"); 
    }
  }

  public GeneratorResults() {
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.queue);
    hash = 83 * hash + Objects.hashCode(this.stack);
    hash = 83 * hash + Float.floatToIntBits(this.v1);
    hash = 83 * hash + Float.floatToIntBits(this.v2);
    hash = 83 * hash + Objects.hashCode(this.op);
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
    final GeneratorResults other = (GeneratorResults) obj;
    if (Float.floatToIntBits(this.v1) != Float.floatToIntBits(other.v1)) {
      return false;
    }
    if (Float.floatToIntBits(this.v2) != Float.floatToIntBits(other.v2)) {
      return false;
    }
    if (!Objects.equals(this.op, other.op)) {
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
    sb.append("GeneratorResults{");
    sb.append("queue=").append(queue);
    sb.append(", stack=").append(stack);
    sb.append(", v1=").append(v1);
    sb.append(", v2=").append(v2);
    sb.append(", op=").append(op);
    sb.append('}');
    return sb.toString();
  }

  public BufferQueue<String> getQueue() {
    return queue;
  }

  public void setQueue(BufferQueue<String> queue) {
    this.queue = queue;
  }

  public BufferStack<String> getStack() {
    return stack;
  }

  public void setStack(BufferStack<String> stack) {
    this.stack = stack;
  }

  public float getV1() {
    return v1;
  }

  public void setV1(float v1) {
    this.v1 = v1;
  }

  public float getV2() {
    return v2;
  }

  public void setV2(float v2) {
    this.v2 = v2;
  }

  public String getOp() {
    return op;
  }

  public void setOp(String op) {
    this.op = op;
  }

}
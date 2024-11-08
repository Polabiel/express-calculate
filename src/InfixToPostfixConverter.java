import java.util.Objects;
import java.util.StringTokenizer;

class InfixToPostfixConverter {

  private StringTokenizer data;
  private BufferQueue queue;
  private BufferStack stack;

  public InfixToPostfixConverter(StringTokenizer tokens) throws Exception {

    if (tokens == null) {
      throw new Exception("token is not valid!");
    }

    this.data = tokens;
    this.stack = new BufferStack<String>();
    this.queue = new BufferQueue<String>();

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
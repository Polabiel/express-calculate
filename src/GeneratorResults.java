class GeneratorResults {
  BufferQueue<String> queue;
  BufferStack<String> stack;
  float v1 = 0;
  float v2 = 0;
  String op = "a";

  public GeneratorResults(BufferQueue<String> queue, BufferStack<String> stack) throws Exception {
    System.out.println("inserindo variaveis");
    queue.guardeUmItem("10");
    queue.guardeUmItem("2");
    queue.guardeUmItem("3");
    queue.guardeUmItem("*");
    queue.guardeUmItem("4");
    queue.guardeUmItem("-");
    queue.guardeUmItem("2");
    queue.guardeUmItem("^");
    queue.guardeUmItem("4");
    queue.guardeUmItem("/");
    queue.guardeUmItem("+");
    queue.guardeUmItem("6");
    queue.guardeUmItem("2");
    queue.guardeUmItem("*");
    queue.guardeUmItem("+");

    this.queue = queue;
    this.stack = stack;
    Float resultado;

    while(!queue.isVazia()){
      String removido = queue.recupereUmItem(); 
      if (removido == "+" || removido =="*" || removido == "-" || removido =="/" || removido == "^"){
        op = removido;
      }
      else{
        stack.guardeUmItem(removido);
      }
      queue.removaUmItem();
      if (op != "a" && op != null){
        v1 = Float.parseFloat(stack.recupereUmItem());
        stack.removaUmItem();
        v2 = Float.parseFloat(stack.recupereUmItem());
        stack.removaUmItem();
        switch (op) {
          case "-":
            resultado = (v1 - v2);
            stack.guardeUmItem(String.valueOf(resultado));
            break;       
          case "+":
            resultado = (v1 + v2);
            stack.guardeUmItem(String.valueOf(resultado));
            break;
          case "*":
            resultado = (v1 * v2);
            stack.guardeUmItem(String.valueOf(resultado));
            break;        
          case "/":
            resultado = (v1 / v2);
            stack.guardeUmItem(String.valueOf(resultado));
            break;
          case "^":
            resultado = (float) (Math.pow(v2, v1));
            stack.guardeUmItem(String.valueOf(resultado));
            break;
        }
        op = null;
      }
    }
    if (queue.isVazia()){
      System.out.println("Queue vazia, o resultado da operação é:");
      System.out.println(stack.recupereUmItem());
    }
  }

}
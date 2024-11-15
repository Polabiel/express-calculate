class GeneratorResults {
  BufferQueue<String> queue;
  BufferStack<String> stack;

  public GeneratorResults(BufferQueue<String> queue, BufferStack<String> stack) throws Exception {

    queue.guardeUmItem("10");
    queue.guardeUmItem("2");
    queue.guardeUmItem("3");
    queue.guardeUmItem("*");
    queue.guardeUmItem("4");
    queue.guardeUmItem("-");
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
  }

}
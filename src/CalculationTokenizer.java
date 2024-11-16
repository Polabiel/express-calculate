import java.util.StringTokenizer;

public class CalculationTokenizer {
    public static String removeWhitespaces(String input) {
        return input.replace(" ", "");
    }

    public static void main(String[] args) throws Exception {

        //deixei a main comentada temporariamente para poder tester o generateResults
        // ! Resultado esperado dessa operação é 23
        String expression = "10 + (2 * 3- 4) ^ 2/4 + 6 * 2";
        String cleanedExpression = removeWhitespaces(expression);
        StringTokenizer tokenizer = new StringTokenizer(cleanedExpression, "+-*/^()", true);

        InfixToPostfixConverter object = new InfixToPostfixConverter(tokenizer);

        object.convertToPostfix();

        //essas 3 linhas foi pra testar o GeneratorResults

        BufferQueue<String> queue = object.getQueue();
        BufferStack<String> stack = object.getStack();

        GeneratorResults a = new GeneratorResults(queue, stack);

    }
}

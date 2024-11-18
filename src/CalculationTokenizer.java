import java.util.StringTokenizer;

public class CalculationTokenizer {
    public static String removeWhitespaces(String input) {
        return input.replace(" ", "");
    }

    public static boolean isValidExpression(String expression) throws Exception {
        // Clone the tokens
        StringTokenizer clonedTokens = new StringTokenizer(expression, "+-*/^()", true);

        int numberCount = 0;
        int operatorCount = 0;
        String operators = "+-*/^";

        while (clonedTokens.hasMoreTokens()) {
            String token = clonedTokens.nextToken();
            if (operators.contains(token)) {
                operatorCount++;
            } else {
                try {
                    Double.valueOf(token);
                    numberCount++;
                } catch (NumberFormatException e) {
                }
            }
        }

        // There should be exactly one less operator than numbers
        System.out.println("Number count: " + numberCount);
        System.out.println("Operator count: " + operatorCount);
        System.out.println("Expression is valid: " + (operatorCount == numberCount - 1));
        return operatorCount == numberCount - 1;
    }

    public static void main(String[] args) throws Exception {

        // deixei a main comentada temporariamente para poder tester o generateResults
        // ! Resultado esperado dessa operação é 23
        String expression = "10 + (2 * 3- 4) ^ 2/4 + 6 * 2";
        String cleanedExpression = removeWhitespaces(expression);
        StringTokenizer tokenizer = new StringTokenizer(cleanedExpression, "+-*/^()", true);

        if (!isValidExpression(expression)) {
            throw new Exception("Invalid expression");
        }

        InfixToPostfixConverter object = new InfixToPostfixConverter(tokenizer);

        object.convertToPostfix();

        BufferQueue<String> queue = object.getQueue();
        BufferStack<String> stack = object.getStack();

        GeneratorResults a = new GeneratorResults(queue, stack);

    }
}

import java.util.StringTokenizer;

public class CalculationTokenizer {
    public static String removeWhitespaces(String input) {
        return input.replace(" ", "");
    }

    public static void main(String[] args) throws Exception {
        String expressionInput = "45   + 7^2 * 3/76 -4 + (5   * 8)";
        String trimmedExpression = removeWhitespaces(expressionInput);
        StringTokenizer tokenizer = new StringTokenizer(trimmedExpression, "+-*/^()", true);

        InfixToPostfixConverter object = new InfixToPostfixConverter(tokenizer);

        System.out.println(object);
    }
}

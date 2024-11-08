import java.util.StringTokenizer;

public class CalculationTokenizer {
    public static String removeWhitespaces(String input) {
        return input.replace(" ", "");
    }

    public static void main(String[] args) throws Exception {
        // String expressionInput = "45 + 7^2 * 3/76 -4 + (5 * 8) + 1";
        String testeString = "10 + (2 * 3- 4) ^ 2/4 + 6 * 2";
        String trimmedExpression = removeWhitespaces(testeString);
        StringTokenizer tokenizer = new StringTokenizer(trimmedExpression, "+-*/^()", true);

        InfixToPostfixConverter object = new InfixToPostfixConverter(tokenizer);

        object.processTokens();
    }
}

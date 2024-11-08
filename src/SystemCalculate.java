import java.util.StringTokenizer;
import java.util.logging.Logger;

private static final Logger logger = Logger.getLogger(QuebraEPrinta.class.getName());

public static String removerEspacos(String input) {
    return input.replaceAll("\\s+", "");
}

public static void main(String[] args) {
    logger.info("iniciando");
    String exp = removerEspacos(entrada);
    StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
    System.out.println("iniciando");
    System.out.println(exp);
    while(quebrador.hasMoreTokens()==true){
        System.out.println(quebrador.nextToken());
    }
}

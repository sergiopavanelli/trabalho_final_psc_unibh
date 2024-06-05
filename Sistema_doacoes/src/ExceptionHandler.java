import java.io.IOException;


public class ExceptionHandler {

    public static void handle(Exception e, String message) {

        System.out.println("Ocorreu um erro: " + e.getMessage());
        System.out.println(message);

        e.printStackTrace();

    }

    public static void handleNumberFormatException (NumberFormatException e) {

        handle (e, "Quantidade Inválida. Por favor, digite um valor numérico.");

    }

    public static void handleIOException (IOException e) {

        handle (e, "Erro ao acessar o arquivo.");

    }

    public static void handleGenericException (Exception e) {

        handle (e, "Ocorreu um erro inesperado. Por favor, tente novamente.");

    }

}

public class ClasseCriptografica {
    private static String SOROLL_PARELL = "XxX";
    private static String SOROLL_IMPAR = "xXx";

    private static int convertirClau(String clau){
        if (clau == null || clau.isEmpty()) {
            throw new IllegalArgumentException("La clau no pot ser nul·la ni buida");
        }
        try {
            return Integer.parseInt(clau);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La clau ha de ser un número vàlid");
        }
    }

    public static String Encripta(String missatge, String clau) {
        int clauNum = convertirClau(clau);
        String resultat = "";
        for (int i = 0; i < missatge.length(); i++){
            int posicio = i + 1;
            int valor = (int) missatge.charAt(i) + posicio + clauNum;
            if (valor % 2 == 0) {
                resultat += SOROLL_PARELL;
            } else {
                resultat += SOROLL_IMPAR;
            }
            resultat += valor;
        }
        return resultat;
    }

    public static String Desencripta(String missatge, String clau) {
        int clauNum = convertirClau(clau);
        String resultat = "";
        String[] numeros = missatge.split("[^0-9]+");
        int posicio = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].isEmpty()) {
                continue;
            }
            posicio++;
            int codi = Integer.parseInt(numeros[i]) - clauNum - posicio;
            if (codi >= 0 && codi <= 65535) {
                resultat += (char) codi;
            } else {
                resultat += '?';
            }
        }
        return resultat;
    }
}

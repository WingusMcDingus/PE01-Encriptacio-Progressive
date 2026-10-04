public class ProgramaPrincipalAES {
    public static void main(String[] args) {
        String missatge = "Aquest és un missatge secret.";
        String clau = "1234567890123456"; // Clau de 16 bytes per AES

        // Programa principal: original -> xifrat -> recuperat
        System.out.println("++ Programa principal AES");
        System.out.println("Missatge original: " + missatge);
        String xifrat = ClassesAES.encripta(missatge, clau);
        System.out.println("Missatge xifrat: " + xifrat);
        String recuperat = ClassesAES.desencripta(xifrat, clau);
        System.out.println("Missatge recuperat: " + recuperat);
        System.out.println();

        // Prova 1: Clau correcta
        System.out.println("++ Prova 1: Clau correcta");
        System.out.println("Són iguals? " + missatge.equals(recuperat));
        System.out.println();

        // Prova 2: Clau diferent (també de 16 bytes)
        System.out.println("++ Prova 2: Clau diferent");
        try {
            String resultat = ClassesAES.desencripta(xifrat, "6543210987654321");
            System.out.println("Missatge desencriptat: " + resultat);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Prova 3: Missatge diferent
        System.out.println("++ Prova 3: Missatge diferent");
        String missatge2 = "HOLA MÓN, COM ESTÀS? ESPERO QUE BÉ.";
        String xifrat2 = ClassesAES.encripta(missatge2, clau);
        String recuperat2 = ClassesAES.desencripta(xifrat2, clau);
        System.out.println("Missatge original: " + missatge2);
        System.out.println("Missatge xifrat: " + xifrat2);
        System.out.println("Missatge recuperat: " + recuperat2);
        System.out.println("Són iguals? " + missatge2.equals(recuperat2));
        System.out.println();

        // Prova 4: Clau de longitud incorrecta
        System.out.println("++ Prova 4: Clau de longitud incorrecta");
        try {
            ClassesAES.encripta(missatge, "clauCurta");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}
import java.util.Scanner;

public class ProgramaPrincipal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String clau = "3";

        // Test 1: Missatge curt -> HOLA
        provarPrimerTests("Test 1: Missatge curt -> HOLA", "HOLA", clau);
        System.out.println();

        // Test 2: Missatge amb espais -> HOLA MÓN
        provarPrimerTests("Test 2: Missatge amb espais -> HOLA MÓN", "HOLA MÓN", clau);
        System.out.println();

        // Test 3: Missatge més llarg (30 caracters) -> HOLA MÓN, COM ESTÀS? ESPERO QUE BÉ.
        provarPrimerTests("Test 3: Missatge més llarg (30 caracters)", "HOLA MÓN, COM ESTÀS? ESPERO QUE BÉ.", clau);
        System.out.println();

        // Test 4: clau diferent i comprovar que canvi el missatge -> HOLA
        System.out.println("++ Test 4: clau diferent i comprovar que canvi el missatge -> HOLA");
        String xif1 = ClasseCriptografica.Encripta("HOLA", clau);
        String xif2 = ClasseCriptografica.Encripta("HOLA", "7");
        System.out.println("HOLA + clau 3 -> " + xif1);
        System.out.println("HOLA + clau 7 -> " + xif2);
        System.out.println("Són diferents? " + !xif1.equals(xif2));
        System.out.println();

        // Test 5: Encrypt & Decrypt -> HOLA
        System.out.println("++ Test 5: Encrypt & Decrypt -> HOLA");
        String pOriginal = "HOLA";
        String pRecuperat = ClasseCriptografica.Desencripta(ClasseCriptografica.Encripta(pOriginal, clau), clau);
        System.out.println("Primer missatge: " + pOriginal);
        System.out.println("Missatge recuperat: " + pRecuperat);
        System.out.println("Són iguals? " + pOriginal.equals(pRecuperat));
        System.out.println();

        // Test 6: Desencriptar amb clau incorrecta -> HOLA
        System.out.println("++ Test 6: Desencriptar amb clau incorrecta -> HOLA");
        String xifrat = ClasseCriptografica.Encripta("HOLA", clau);
        System.out.println("xifrat amb clau 3 -> " + xifrat);
        System.out.println("desencriptat amb clau 7 -> " + ClasseCriptografica.Desencripta(xifrat, "7"));
        System.out.println("desencriptat amb clau 3 -> " + ClasseCriptografica.Desencripta(xifrat, clau));
        System.out.println();

    }
    public static void provarPrimerTests(String nomTest, String missatge, String clau){
        System.out.println("++ " + nomTest);
        String xifrat = ClasseCriptografica.Encripta(missatge, clau);
        String recuperat = ClasseCriptografica.Desencripta(xifrat, clau);
        System.out.println("Missatge original: " + missatge);
        System.out.println("Missatge xifrat: " + xifrat);
        System.out.println("Missatge recuperat: " + recuperat);
        System.out.println("Tot correcte? " + missatge.equals(recuperat));

    }
}

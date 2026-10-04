import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ClassesAES {
    private static final String TRANSFORMACIO = "AES/ECB/PKCS5Padding";

    private static SecretKeySpec convertirClau(String clau) {
        if (clau == null || clau.isEmpty()) {
            throw new IllegalArgumentException("La clau no pot ser nul·la ni buida");
        }
        // La clau es converteix a bytes perquè AES la pugui utilitzar
        return new SecretKeySpec(clau.getBytes(StandardCharsets.UTF_8), "AES");
    }

    public static String encripta(String missatge, String clau) {
        try {
            SecretKeySpec clauSecreta = convertirClau(clau);

            Cipher cipher = Cipher.getInstance(TRANSFORMACIO);
            cipher.init(Cipher.ENCRYPT_MODE, clauSecreta);

            byte[] missatgeBytes = missatge.getBytes(StandardCharsets.UTF_8);
            byte[] xifrat = cipher.doFinal(missatgeBytes);

            return Base64.getEncoder().encodeToString(xifrat);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error en encriptar: " + e.getMessage(), e);
        }
    }

    public static String desencripta(String missatgeXifrat, String clau) {
        try {
            SecretKeySpec clauSecreta = convertirClau(clau);

            Cipher cipher = Cipher.getInstance(TRANSFORMACIO);
            cipher.init(Cipher.DECRYPT_MODE, clauSecreta);

            byte[] xifrat = Base64.getDecoder().decode(missatgeXifrat);
            byte[] original = cipher.doFinal(xifrat);

            return new String(original, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error en desencriptar: " + e.getMessage(), e);
        }
    }
}
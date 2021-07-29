import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class GenerateRandomString {

    private final static Random RANDOM = new SecureRandom();
    private final static String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        // String with dashes
        System.out.println(generateRandomString(true));

        // Remove dashes
        System.out.println(generateRandomString(false));

        // with specific length
        String randomString = generateRandomString(30);
        System.out.println(randomString);
    }

    private static String generateRandomString(boolean withDashes) {
        String uuid = UUID.randomUUID().toString();
        if (withDashes) {
            String newString = uuid.replaceAll("-", "");
            System.out.println(newString);
            return newString;
        } else {
            System.out.println(uuid);
            return uuid;
        }
    }

    private static String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}

package encryptdecrypt;

public class UnicodeAlgorithm extends AbstractClass{
    private final String text;
    private final int key;
    private final String letters = "abcdefghijklmnopqrstuvwxyz";

    public UnicodeAlgorithm(String text, int key) {
        this.text = text;
        this.key = key;
    }

    public String encryption() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int val = text.charAt(i) + key;
            result.append((char) val);
        }
        return result.toString();
    }

    public String decryption() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int val = text.charAt(i) - key;
            result.append((char) val);
        }
        return result.toString();
    }
}

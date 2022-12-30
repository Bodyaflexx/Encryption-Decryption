package encryptdecrypt;

public class ShiftAlgorithm extends AbstractClass{
    private final String text;
    private final int key;
    private final String letters = "abcdefghijklmnopqrstuvwxyz";

    public ShiftAlgorithm(String text, int key) {
        this.text = text;
        this.key = key;
    }

    @Override
    public String encryption() {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 97 && c <= 122) {
                c = c + key > 122 ?
                        (char) (c + key - 26) :
                        (char) (c + key);
            }
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String decryption() {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 97 && c <= 122) {
                c = c - key < 97 ?
                        (char) (c - key + 26) :
                        (char) (c - key);
            }
            result.append(c);
        }
        return result.toString();
    }
}

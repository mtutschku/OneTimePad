package src;

public class Bit {

    private int value;

    public Bit(int value) {
        this.value = clamp(value);
    }

    public Bit() {
        this(0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = clamp(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private int clamp(int value) {
        if (value != 0 && value != 1) {
            System.out.println("[WARNUNG @ Bit.clamp] Ungültiger Wert (" + value + ") wurde gekappt");
        }

        return value <= 0 ? 0 : 1;
    }

    public static void printBits(Bit[] bits) {
        for (Bit bit : bits) {
            System.out.print(bit.toString());
        }
        System.out.println("");
    }

    public static void printHex(Bit[] bits) {
        if (bits.length < 8 || bits.length % 8 != 0) {
            System.out.println("[FEHLER @ Bit.printHex]");
            System.exit(1);
        }

        String str = "";
        for (Bit bit : bits) {
            str += String.valueOf(bit.getValue());
        }

        String hex = "";
        String tmp = "";
        for (int i = 0; i < str.length(); i += 4) {
            tmp = "";
            for (int j = 0; j < 4; j++) {
                tmp += str.charAt(i + j);
            }
            int bin = Integer.parseInt(tmp, 2);
            hex += Integer.toHexString(bin);
        }
        
        System.out.println(hex);
    }

}

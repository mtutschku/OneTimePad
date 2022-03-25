

/** Class representing a Bit object.
 * 
 * Message and Key objects use Bit-arrays to store text/data.
 * Consists of a single member variable (being the state of the bit).
 * Provides static methods for printing Bit-Arrays.
 */
public class Bit {

    /** state of the bit */
    private int value;

    /** Constructor
     * 
     * @param value initializing state of Bit (0 or 1)
     */
    public Bit(int value) {
        this.value = clamp(value);
    }

    /** Construtor
     * 
     * When no value is given, the Bit is initialized with 0.
     */
    public Bit() {
        this(0);
    }

    /** Getter for value
     * 
     * @return value
     */
    public int getValue() {
        return value;
    }

    /** Setter for value
     * 
     * @param value 
     */
    public void setValue(int value) {
        this.value = clamp(value);
    }

    /** Method for visually displaying a Bit object
     * 
     * @return String containing value of Bit
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /** Clamps any given integer either to 0 or 1 to ensure valid Bit state
     * 
     * @param value value
     * @return 0 when value is less or equal 0, otherwise 1
     */
    private int clamp(int value) {
        if (value != 0 && value != 1) {
            System.out.println("[WARNING @ Bit.clamp] Invalid value for bit (" + value + ") has been clamped");
        }

        return value <= 0 ? 0 : 1;
    }

    /** Prints a Bit array to the console
     * 
     * @param bits Bit array
     * @param newLine if true, a new line will also be printed
     */
    public static void printBits(Bit[] bits, boolean newLine) {
        for (Bit bit : bits) {
            System.out.print(bit.toString());
        }
        System.out.print(" ");
        if(newLine) System.out.println("");
    }
    
    /** Prints a Bit array without a new line to the console
     * 
     * @param bits Bit array 
     */
    public static void printBits(Bit[] bits){
        printBits(bits, true);
    }

    /** Converts a Bit array to hexadecimal values and prints them to console
     * 
     * @param bits Bit array
     * @param newLine if true, a new line will also be printed
     */
    public static void printHex(Bit[] bits, boolean newLine) {
        if (bits.length < 8 || bits.length % 8 != 0) {
            System.out.println("[ERROR @ Bit.printHex] Invalid length of bits");
            System.exit(1);
        }

        String str = "";
        for (Bit bit : bits) {
            str += String.valueOf(bit.getValue());
        }

        String hex = "";
        String tmp;
        for (int i = 0; i < str.length(); i += 4) {
            tmp = "";
            for (int j = 0; j < 4; j++) {
                tmp += str.charAt(i + j);
            }
            int bin = Integer.parseInt(tmp, 2);
            hex += Integer.toHexString(bin);
        }
        
        if(newLine){
            System.out.println(hex);
        } else {
            System.out.print(hex + " ");
        }
    }
    
    /** Same as above, but without new line
     * 
     * @param bits Bit array
     */
    public static void printHex(Bit[] bits){
        printHex(bits, true);
    }

}

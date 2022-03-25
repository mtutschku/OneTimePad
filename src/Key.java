

import java.util.Random;

/** Class representing the key used to encrypt or decrypt text/data.
 * 
 * The Key object consists of a Bit array with pseudorandom values.
 */
public class Key {

    /** Bit array holding random-value Bit objects */
    private Bit[] bits;
    
    /** Constructor
     * 
     * Initializes the Bit array with random-valued Bit objects.
     * Message and Key are the same length.
     * 
     * @param m Message object to determine length of Bit array
     */
    public Key(Message m) {
        int bitsLength = m.getBits().length;
        bits = new Bit[bitsLength];
        Random r = new Random();
        for(int i = 0; i < bitsLength; i++){
            int value = r.nextInt(2);
            bits[i] = new Bit(value);
        }
    }

    /** Getter of bits
     * 
     * @return Bit array
     */
    public Bit[] getBits() {
        return bits;
    }
    
    
}

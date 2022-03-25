package src;

/** Class for encrypting or decrypting text/data.
 * 
 *  Due to the symmetry of one-time pad, encryption and decryption are the same.
 */
public class Crypter {

    /** Encrypts text from a Message object and returns encrypted Bits
     * 
     * @param m Message object
     * @param k Key object
     * @return encrypted Bit array
     */
    public static Bit[] encrypt(Message m, Key k){
        Bit[] bits = new Bit[m.getBits().length];
        if(m.getBits().length != k.getBits().length){
            System.out.println("[ERROR @ Crypter.encrypt] Message and Key are of different length");
            System.exit(1);
        } else {
            for(int i = 0; i < bits.length; i++){
                bits[i] = new Bit(m.getBits()[i].getValue() ^ k.getBits()[i].getValue());
            }
        }
        
        return bits;
    }
    
    /** Decrypts text from a Message object and returns decrypted Bits
     * 
     * @param m Message object
     * @param k Key object
     * @return decrypted Bit array
     */
    public static Bit[] decrypt(Message m, Key k){
        return encrypt(m, k);
    }
    
}

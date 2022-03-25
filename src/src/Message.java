package src;

/** Class representing the message.
 * 
 *  Contains a Bit array which hold text/data in form of binary ASCII values.
 */
public class Message {

    /** Bit array representing text/data */
    private Bit[] bits;
    
    /** Constructor
     * 
     * Initializes the Bit array with values corresponding to the chars of the text.
     * If text is empty, the Bit array is initialized with 8 zeroed Bits.
     * 
     * @param text text
     */
    public Message(String text) {
        if(text.isEmpty()){
            System.out.println("[WARNING @ Message.Message] Empty text. Initializing with 8 bits, all zero");
            bits = new Bit[8];
            for(int i = 0; i < bits.length; i++){
                bits[i] = new Bit();
            }
        } else {
            initBits(text);
        }
    }
    
    /** Constructor
     * 
     * Second way to initialize the Message object is by providing an already defined Bit array.
     * Bit array has to be at least length 8 and must be divisible by 8.
     * 
     * @param bits Bit array
     */
    public Message(Bit[] bits){
        if(bits.length < 8 || bits.length % 8 != 0){
            System.out.println("[ERROR @ Message.Message] Invalid length for bits");
            System.exit(1);
        } else {
            this.bits = bits;
        }
    }
    
    /** Initialization of the Bit array
     * 
     * Every char of the given text/data is being converted to an 8-bit ASCII value.
     * Values in the Bit array are initialized accordingly.
     * 
     * @param text text
     */
    private void initBits(String text){
        int length = text.length();
        bits = new Bit[8 * length];
        String full = "";
        for(int i = 0; i < text.length(); i++){
            int ch = (int) text.charAt(i);
            String bitString = Integer.toBinaryString(ch);
            String str8 = "";
            if(bitString.length() > 8){
                System.out.println("[ERROR @ Message.initBits] bitString.length > 8. Text maybe contains invalid chars");
                System.exit(1);
            } else if(bitString.length() == 8){
                // nichts muss geändert werden
                str8 = bitString;
            } else {
                int leading = 8 - bitString.length();
                for(int j = 0; j < leading; j++){
                    str8 += "0";
                }
                str8 += bitString;
            }
            
            full += str8;
        }
        
        if(bits.length != full.length()){
            System.out.println("[ERROR @ Message.initBits] bits.length != full.length");
            System.exit(1);
        }
        
        for(int i = 0; i < bits.length; i++){
            int value = full.charAt(i) - 48;
            if(value != 0 && value != 1){
                System.out.println("[ERROR @ Message.initBits] Invalid char value");
                System.exit(1);
            }
            bits[i] = new Bit(value);
        }
        
    }

    /** Getter for bits
     * 
     * @return Bit array
     */
    public Bit[] getBits() {
        return bits;
    }

}

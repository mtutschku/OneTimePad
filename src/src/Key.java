package src;

import java.util.Random;

public class Key {

    private Bit[] bits;
    
    public Key(Message m) {
        int bitsLength = m.getBits().length;
        bits = new Bit[bitsLength];
        Random r = new Random();
        for(int i = 0; i < bitsLength; i++){
            int value = r.nextInt(2);
            bits[i] = new Bit(value);
        }
    }

    public Bit[] getBits() {
        return bits;
    }
    
    
}

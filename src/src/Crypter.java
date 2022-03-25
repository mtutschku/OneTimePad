package src;

public class Crypter {

    public static Bit[] encrypt(Message m, Key k){
        Bit[] bits = new Bit[m.getBits().length];
        if(m.getBits().length != k.getBits().length){
            System.out.println("[FEHLER @ Crypter.encrypt] Message und Key haben unterschiedliche Länge");
            System.exit(1);
        } else {
            for(int i = 0; i < bits.length; i++){
                bits[i] = new Bit(m.getBits()[i].getValue() ^ k.getBits()[i].getValue());
            }
        }
        
        return bits;
    }
    
    public static Bit[] decrypt(Message m, Key k){
        return encrypt(m, k);
    }
    
}

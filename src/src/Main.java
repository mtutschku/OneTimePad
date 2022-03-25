package src;

public class Main {
    public static void main(String[] args) {
        Message m = new Message("Test");
        Key k = new Key(m);
        
        Bit.printBits(m.getBits());
        Bit.printBits(k.getBits());
        for(int i = 0; i < m.getBits().length; i++){
            System.out.print("-");
        }
        System.out.println("");
        Bit.printBits(Crypter.encrypt(m, k));
        System.out.println("");
        
        Message encrypted = new Message(Crypter.encrypt(m, k));
        
        Bit.printBits(encrypted.getBits());
        Bit.printBits(k.getBits());
        for(int i = 0; i < encrypted.getBits().length; i++){
            System.out.print("-");
        }
        System.out.println("");
        Bit.printBits(Crypter.decrypt(encrypted, k));
        
        System.out.println("\n");
        Bit.printHex(k.getBits());
    }
}

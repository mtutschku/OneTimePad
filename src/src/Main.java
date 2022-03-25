package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Text: ");
        String text = scanner.nextLine();
        System.out.println("");
        
        Message msg = new Message(text);
        Key key = new Key(msg);
        
        System.out.println("Encryption:");
        Bit.printBits(msg.getBits(), false);
        System.out.println("Plain text in ASCII");
        Bit.printBits(key.getBits(), false);
        System.out.println("Key");
        for(int i = 0; i < msg.getBits().length; i++){
            System.out.print("-");
        }
        System.out.println("");
        Bit.printBits(Crypter.encrypt(msg, key), false);
        System.out.println("Encrypted text\n");
        
        Message encrypted = new Message(Crypter.encrypt(msg, key));
        
        System.out.println("Decryption:");
        Bit.printBits(encrypted.getBits(), false);
        System.out.println("Encrypted text in ASCII");
        Bit.printBits(key.getBits(), false);
        System.out.println("Key");
        for(int i = 0; i < encrypted.getBits().length; i++){
            System.out.print("-");
        }
        System.out.println("");
        Bit.printBits(Crypter.decrypt(encrypted, key), false);
        System.out.println("Decrypted text in ASCII");
        
        System.out.println("\n");
    }
}

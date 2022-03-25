package src;

public class Message {

    private Bit[] bits;
    
    public Message(String text) {
        if(text.isEmpty()){
            System.out.println("[WARNUNG @ Message.Message] Kein Text vorhanden. 8 Bits werden auf 0 gesetzt");
            bits = new Bit[8];
            for(int i = 0; i < bits.length; i++){
                bits[i] = new Bit();
            }
        } else {
            initBits(text);
        }
    }
    
    public Message(Bit[] bits){
        if(bits.length < 8 || bits.length % 8 != 0){
            System.out.println("[FEHLER @ Message.Message] bits hat eine ungültige Länge");
            System.exit(1);
        } else {
            this.bits = bits;
        }
    }
    
    private void initBits(String text){
        int length = text.length();
        bits = new Bit[8 * length];
        String full = "";
        for(int i = 0; i < text.length(); i++){
            int ch = (int) text.charAt(i);
            String bitString = Integer.toBinaryString(ch);
            String str8 = "";
            if(bitString.length() > 8){
                System.out.println("[FEHLER @ Message.initBits] bitString.length > 8.");
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
            System.out.println("[FEHLER @ Message.initBits] bits.length != full.length");
            System.exit(1);
        }
        
        for(int i = 0; i < bits.length; i++){
            int value = full.charAt(i) - 48;
            if(value != 0 && value != 1){
                System.out.println("[FEHLER @ Message.initBits] Ungültiger Wert für value");
                System.exit(1);
            }
            bits[i] = new Bit(value);
        }
        
    }

    public Bit[] getBits() {
        return bits;
    }

}

package encryption.impl;

import encryption.interfaces.IEncryptionTool;

import java.util.ArrayList;

public class EncryptionTool implements IEncryptionTool {
    @Override
    public String encrypt(String p_string) {
        ArrayList<Character> charArrayListOut = new ArrayList<>();

        for(char a : p_string.toCharArray()){
            charArrayListOut.add((char)(a + 2));
        }

        StringBuilder sb = new StringBuilder();
        for(char a : charArrayListOut) {
            sb.append(a);
        }

        return sb.toString();
    }

    @Override
    public String decrypt(String p_string) {

        ArrayList<Character> charArrayListOut = new ArrayList<>();

        for(char a : p_string.toCharArray()){
            charArrayListOut.add((char)(a - 2));
        }

        StringBuilder sb = new StringBuilder();
        for(char a : charArrayListOut) {
            sb.append(a);
        }

        return sb.toString();

    }

    @Override
    public String antiCheatEncrypt(String p_string) {
        ArrayList<Character> charArrayListOut = new ArrayList<>();
        String inputString = p_string;
        String inputString2 = encrypt(p_string);
        inputString = inputString2 + "-" + inputString;

       String output = encrypt(inputString);

       return output;

    }

    //@Override
   public String antiCheatDecrypt(String p_string) throws Exception {

        String stringToProcess = p_string.replace("1", "-");
        stringToProcess = stringToProcess.replace("/", "-");
        System.out.println(stringToProcess);
        String[] split = stringToProcess.split("-");
        String checkedString1 = split[0] + "11" + split[1] + "11" + split[2] + "11" + split[3] + "11" + split[4] + "11" + split[5] + "11" + split[6] + "11" + split[7];
        String decryptedString1 = decrypt(checkedString1);
        String checkedString2 = split[8] + "//" + split[9] + "//" + split[10] + "//" + split[11] + "//" + split[12] + "//" + split[13] + "//" + split[14] + "//" + split[15];
        String decryptedString2 = decrypt(checkedString2);
        System.out.println(decryptedString2);


        ArrayList<Character> charArrayListOut = new ArrayList<>();

        if(isFraudulent(p_string)){
            throw new Exception("Cheat Detected. Abandonning");
        }

        for(char a : p_string.toCharArray()){
            charArrayListOut.add((char)(a - 2));
        }

        StringBuilder sb = new StringBuilder();
        for(char a : charArrayListOut) {
            sb.append(a);
        }



        return sb.toString();
    }

    //@Override
    boolean isFraudulent(String p_encryptedString){
        boolean outBoolean = false;
        String stringToProcess = p_encryptedString.replace("1", "-");
        stringToProcess = stringToProcess.replace("/", "-");
        System.out.println(stringToProcess);
        String[] split = stringToProcess.split("-");
        String checkedString1 = split[0] + "11" + split[1] + "11" + split[2] + "11" + split[3] + "11" + split[4] + "11" + split[5] + "11" + split[6] + "11" + split[7];
        String decryptedString1 = decrypt(checkedString1);
        String checkedString2 = split[8] + "//" + split[9] + "//" + split[10] + "//" + split[11] + "//" + split[12] + "//" + split[13] + "//" + split[14] + "//" + split[15];
        //String decryptedString2 = decrypt(checkedString2);
        System.out.println(checkedString1);
        System.out.println(checkedString2);
        System.out.println(decryptedString1);

        if(decryptedString1.equals(checkedString2)){
            return false;
        }
        return true;
    }
}

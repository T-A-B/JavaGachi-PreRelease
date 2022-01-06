package encryption.impl;

import org.junit.jupiter.api.Test;

class EncryptionToolTest {

    @Test
    void encrypt() {
        String s = "Tyler";
        EncryptionTool e = new EncryptionTool();

        String output = e.encrypt(s);

        System.out.println(output);

    }

    @Test
    void decrypt() {

        String s = "V{ngt";
        EncryptionTool e = new EncryptionTool();

        String output = e.decrypt(s);

        System.out.println(output);

    }

    @Test
    void testEncrypt() {
    }

    @Test
    void testDecrypt() {
    }

    @Test
    void antiCheatEncrypt() {
        String s = "Tyler--360--255--255--255--255--255--255";
        EncryptionTool e = new EncryptionTool();

        String output = e.antiCheatEncrypt(s);

        System.out.println(output);

    }

    @Test
    void antiCheatDecrypt() throws Exception {
        EncryptionTool e = new EncryptionTool();
        String s = "HiqsKeglm16841951951699169915461546/FgoqIcejk/462/73/73/477/477/324/324";
        System.out.println(e.antiCheatDecrypt(s));
    }

    @Test
    void isFraudulent() throws Exception {
        String s = "Tyler-360-255-255-255-255-255-255";
        EncryptionTool e = new EncryptionTool();
        s = e.antiCheatEncrypt(s);
        System.out.println("S NEXT LINE");
        System.out.println(s);
        System.out.println(e.antiCheatDecrypt(s));
    }
}
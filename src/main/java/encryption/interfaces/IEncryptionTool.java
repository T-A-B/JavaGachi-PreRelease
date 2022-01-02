package encryption.interfaces;

public interface IEncryptionTool {
    String encrypt(String p_string);
    String decrypt(String p_string);
    String antiCheatEncrypt(String p_string);

}

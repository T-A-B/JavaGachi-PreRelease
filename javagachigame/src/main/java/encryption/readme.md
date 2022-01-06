<b> Encryption Notes: </b>
A simple attempt to keep players from defeating the Export JavaGachi code functionality.  An observant individual may be able to detect the simple +2 character shift
but it will be much harder to detect through observation the other part to the encryption process.

Algorithmic Idea:

String encrypt(String p_string) ->  Shift all characters to char value +2
String decrypt(String p_string) ->  Shift all characters to char value -2

antiCheatEncrypt() -> encrypt(encrypt(javaGachiExportCode).concatenate(javaGachiExportCode))

antiCheatDecrypt() -> verify that the encrypted String has a matching first half and a matching second half.  Then, decrypt() the second half of the string and return.

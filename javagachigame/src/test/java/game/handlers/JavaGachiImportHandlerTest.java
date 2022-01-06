package game.handlers;

import org.junit.jupiter.api.Test;

class JavaGachiImportHandlerTest {

    @Test
    void loadJavaGachiFromEncryptedCode() {
        JavaGachiImportHandler i = new JavaGachiImportHandler();

        String s = "X}piv17:4169916991699169916991699/V{ngt/582/477/477/477/477/477/477";
        i.loadJavaGachiFromEncryptedCode(s);

    }
}
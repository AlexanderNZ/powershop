import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import static sun.security.pkcs11.wrapper.Functions.toBinaryString;

public class Main {

    public static void main(String a[]) {

        String bytesEncoded = "zjY29k4EpuaGzq6Gzg==";

        // Try Catch to decode Value
        byte[] valueDecoded = new byte[0];
        try {
            valueDecoded = Base64.decode(bytesEncoded);
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        }
        System.out.println("Decoded value is " + new String(valueDecoded));

        String binaryString = toBinaryString(valueDecoded);
        System.out.println(binaryString);

        String reversedString = new StringBuilder(binaryString).reverse().toString();
        System.out.println(reversedString);

        String resultString = "";
        char nextChar;

        for(int i = 0; i <= reversedString.length()-8; i += 8)
        {
            nextChar = (char)Integer.parseInt(reversedString.substring(i, i+8), 2);
            resultString += nextChar;
        }

        System.out.print(resultString);

    }
}
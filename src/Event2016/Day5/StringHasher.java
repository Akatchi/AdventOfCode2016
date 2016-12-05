package Event2016.Day5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHasher
{
    public String getMD5HashFromInput(String input)
    {
        String hashedInput = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("Md5");
            byte[] hashedBytes = messageDigest.digest(input.getBytes("UTF-8"));

            hashedInput = convertByteArrayToHexString(hashedBytes);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return hashedInput;
    }

    private String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte arrayByte : arrayBytes) {
            stringBuilder.append(Integer.toString((arrayByte & 0xff) + 0x100, 16).substring(1));
        }

        return stringBuilder.toString();
    }
}

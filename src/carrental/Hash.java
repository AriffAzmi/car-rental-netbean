/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ariffazmi
 */

public class Hash {
    private static final byte[] SALT = "zaq1xsw2cde3".getBytes(StandardCharsets.UTF_8);

    public static byte[] getHash(String input) {
        SecretKeySpec saltSpec = new SecretKeySpec(SALT, "HmacSHA512");
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA512");
            mac.init(saltSpec);
            return mac.doFinal(input.getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}

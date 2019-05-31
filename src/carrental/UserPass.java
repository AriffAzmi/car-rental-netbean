/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ariffazmi
 */
public class UserPass {
    private static final Map<String, byte[]> USER_PASS = new HashMap<>();

    static {
        try {
            USER_PASS.put("hello", Hash.getHash("world"));
            USER_PASS.put("abc", Hash.getHash("123"));
            USER_PASS.put("ayam", Hash.getHash("goreng"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean match(String user, byte[] passHash) {
        byte[] account = USER_PASS.get(user);
        return account != null && Arrays.equals(account, passHash);
    }
}


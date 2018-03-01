package CRUD.controller;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/hash")
public class HashController {

    @GetMapping()
    public String getHash(@RequestParam(name = "text") String hash) {
        String hashh = generateHash(hash);
        System.out.println(hashh);
        return hashh;
    }

    private String generateHash(String text) {
        MessageDigest SHA2 = null;
        try {
            SHA2 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] hashedTextBytes = SHA2.digest(textBytes);
        return new String(HexBin.encode(hashedTextBytes));
    }
}

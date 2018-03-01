package CRUD.controller;

import CRUD.entity.Hash;
import CRUD.service.HashService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DatabaseController {
    @Autowired
    private HashService hashService;


    public String getAllHash() {
        return parseListToString();
    }

    private String parseListToString() {
        List<Hash> hashList = hashService.getHashes();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(hashList.get(0));
            System.out.println("JSON:"+json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (hashList.isEmpty())
            return "";
        String text = "";
        for (Hash hash : hashList) {
            text += parseHashToString(hash);
            text += ':';
            text += hash.getId();
            text += ":";
        }
        text = text.substring(0, text.length() - 1);
        System.out.println("Test|" + text);
        return text;
    }

    private String parseHashToString(Hash hash) {
        return hash.getHash();
    }

    @GetMapping()
    public String getHash(@RequestParam("id") String id) {
        if (id != "")
            return hashService.getHash(Integer.parseInt(id)).getHash();
        else
            return getAllHash();
    }

    @PostMapping()
    public String saveHash(@RequestParam("hash") String hash) {
        //Hash temp = new Hash(hash,hashService.hashCounter());
        Hash hash1 = new Hash();
        hash1.setHash(hash);
        hashService.saveHash(hash1);
        return "ok";
    }

    @DeleteMapping()
    public String deleteHash(@RequestParam("id") int id) {
        hashService.deleteHash(id);
        return "Ok";
    }


}

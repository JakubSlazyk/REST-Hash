package CRUD.controller;

import CRUD.entity.Hash;
import CRUD.service.HashService;
import CRUD.service.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hash")
public class MainController {

    @Autowired
    private Parser parser;

    @GetMapping("/list")
    public String listHashes(Model theModel) {


        theModel.addAttribute("hashes", parser.parseStringToList(getHashesFromDatabase("")));

        return "list-hash";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam(name = "text") String text, Model model) {
        String hash = getHash(text);
        model.addAttribute("hash", hash);
        return "hash-form";
    }

    @PostMapping("/saveHash")
    public String saveHash(@RequestParam("hash") String hash) {
        saveHashRest(hash);
        return "redirect:/hash/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("hashId") int theId) {
        deleteHashRest(theId);
        return "redirect:/hash/list";
    }

    private String getHash(String text) {
        String uri = "http://localhost:8080/hash?text=" + text;
        RestTemplate restTemplate = new RestTemplate();
        String hash = restTemplate.getForObject(uri, String.class);
        return hash;
    }

    private void saveHashRest(String text) {
        String uri = "http://localhost:8080/db?hash=" + text;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(uri, text);
    }

    private void deleteHashRest(int id) {
        String uri = "http://localhost:8080/db?id=" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
    }

    private String getHashesFromDatabase(String text) {
        List<Hash> list = new ArrayList<Hash>();
        String uri = "http://localhost:8080/db?id=";
        RestTemplate restTemplate = new RestTemplate();
        String hash = restTemplate.getForObject(uri, String.class);

        return hash;
    }


}

package CRUD.service;

import CRUD.entity.Hash;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class Parser {
    public List<Hash> parseStringToList(String text) {
        List<Hash> list = new LinkedList<Hash>();
        if (text == null)
            return list;
        String[] tab = text.split(":");

        for (int i = 0; i < tab.length; i += 2)
            list.add(new Hash(tab[i], Integer.parseInt(tab[i + 1])));
        return list;
    }
}

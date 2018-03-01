package CRUD.service;

import CRUD.dao.HashDAO;
import CRUD.entity.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HashServiceImpl implements HashService {

    @Autowired
    private HashDAO hashDAO;

    @Override
    @Transactional
    public List<Hash> getHashes() {
        return hashDAO.getHashes();
    }

    @Override
    @Transactional
    public void saveHash(Hash hash) {
        hashDAO.saveHash(hash);
    }

    @Override
    @Transactional
    public Hash getHash(int theId) {

        return hashDAO.getHash(theId);
    }

    @Override
    @Transactional
    public void deleteHash(int theId) {

        hashDAO.deleteHash(theId);
    }

    public int hashCounter() {
        return hashDAO.hashCounter();
    }

}

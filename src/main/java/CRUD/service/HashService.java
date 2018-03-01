package CRUD.service;



import CRUD.entity.Hash;

import java.util.List;

public interface HashService {

    public List<Hash> getHashes();

    public void saveHash(Hash hash);

    public Hash getHash(int theId);

    public void deleteHash(int theId);

    public int hashCounter();
}

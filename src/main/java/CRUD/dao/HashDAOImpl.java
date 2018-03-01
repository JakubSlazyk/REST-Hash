package CRUD.dao;

import CRUD.entity.Hash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HashDAOImpl implements HashDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Hash> getHashes() {

        Session currentSession = sessionFactory.getCurrentSession();

        List<Hash> hashes = currentSession.createQuery("from Hash", Hash.class).list();

        return hashes;
    }


    @Override
    public void saveHash(Hash hash) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(hash);
    }


    @Override
    public Hash getHash(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Hash hash = currentSession.get(Hash.class, theId);
        return hash;
    }


    @Override
    public void deleteHash(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Hash where id=:hashId");
        theQuery.setParameter("hashId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public int hashCounter() {
        Session currentSession = sessionFactory.getCurrentSession();
        int count = (int) currentSession.createQuery("Select count (e) FROM Hashes e").getSingleResult();
        return count;
    }

}

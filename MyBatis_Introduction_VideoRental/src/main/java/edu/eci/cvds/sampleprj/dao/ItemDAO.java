package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException;

<<<<<<< HEAD
}
=======
}
>>>>>>> 595048eee059aa0a23723c3a611438dbb49d5440

package edu.eci.cvds.sampleprj.dao;

<<<<<<< HEAD
import edu.eci.cvds.samples.entities.Item;

public interface TipoItemDAO {

   public void save(TipoItem ti) throws PersistenceException;

   public Item load(int id) throws PersistenceException;

=======
import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {
    
    public void save(TipoItem descripcion) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe
}

package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.Item;

public interface ItemRentadoDAO {

   public void save(ItemRentado ir) throws PersistenceException;

   public Item load(int id) throws PersistenceException;

   public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException;

}

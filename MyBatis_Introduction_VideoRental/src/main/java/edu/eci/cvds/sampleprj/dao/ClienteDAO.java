package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import java.util.List;
import java.util.Date;


public interface ClienteDAO {

   public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(long id) throws PersistenceException;

   public List<Cliente> consultarClientes() throws PersistenceException;
   
   public void registrarAlquiler(Date date, long docu, Item item, int numdias) throws PersistenceException ;

   public void vetar(long docu, boolean estado) throws PersistenceException;
}

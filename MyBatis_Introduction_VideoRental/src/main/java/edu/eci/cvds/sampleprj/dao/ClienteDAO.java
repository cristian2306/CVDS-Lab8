package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import java.util.List;


public interface ClienteDAO {

   public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(long id) throws PersistenceException;

   public List<Cliente> consultarClientes() throws PersistenceException; 

   public void vetar(long docu, boolean estado) throws PersistenceException;
}

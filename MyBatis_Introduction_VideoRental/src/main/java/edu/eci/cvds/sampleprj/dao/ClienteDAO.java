package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
<<<<<<< HEAD
import java.util.List;


public interface ClienteDAO {

   public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(int id) throws PersistenceException;

   public List<Cliente> consultarClientes() throws PersistenceException; 

=======

public interface ClienteDAO {
    public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(int id) throws PersistenceException;
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe
}

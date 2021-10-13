package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import java.sql.SQLException;

public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cliente) throws PersistenceException{
  try{
      clienteMapper.insertarCliente(cliente);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
<<<<<<< HEAD
      throw new PersistenceException("Error al registrar el cliente "+cliente.toString(),e);
=======
      throw new PersistenceException("Error al registrar el cliente"+cliente.toString(),e);
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe
  }        

  }

  @Override
  public Cliente load(int id) throws PersistenceException {
<<<<<<< HEAD
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item "+id,e);
        }
    }
=======
  try{
      return clienteMapper.consultarCliente(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el cliente"+id,e);
  }
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe


  @Override
  public List<Cliente> consultarClientes() throws PersistenceException{
        try{
            return clienteMapper.consultarClientes();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los clientes");
        }

  }


  }

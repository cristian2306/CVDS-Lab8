package edu.eci.cvds.sampleprj.dao.mybatis;

<<<<<<< HEAD
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

public class MyBATISCliente implements ItemDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cliente) throws PersistenceException{
  try{
      ClienteMapper.insertarCliente(cliente);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el item "+it.toString(),e);
  }        

  }

  @Override
  public Cliente load(int id) throws PersistenceException {
  try{
      return clienteMapper.consultarCliente(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el item "+id,e);
  }


  }

  }
=======
public class MyBATISClienteDAO {
    
}
>>>>>>> a24d824de1c087a24663f2d239fe40aa0ce9b784

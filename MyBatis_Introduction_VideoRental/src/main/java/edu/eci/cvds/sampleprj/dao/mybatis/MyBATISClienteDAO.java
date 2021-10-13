package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cliente) throws PersistenceException{
  try{
      clienteMapper.insertarCliente(cliente);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el cliente "+cliente.toString(),e);
  }        

  }

  @Override
  public Cliente load(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item "+id,e);
        }
    }


  @Override
  public List<Cliente> consultarClientes() throws PersistenceException{
        try{
            return clienteMapper.consultarClientes();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los clientes",e);
        }
  }

  @Override
  public void vetar(long docu, boolean estado) throws PersistenceException{
      try{
          clienteMapper.vetar(docu,estado);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al vetar al cliente");
        }
  }

  public void registrarAlquiler(Date date, long docu, Item item, int numdias) throws PersistenceException{
        try{
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(date); 
            calendario.add(calendario.DAY_OF_YEAR,numdias);
            Date fechaFin = calendario.getTime();
            clienteMapper.agregarItemRentadoACliente(docu, item.getId(), date, fechaFin);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el alquiler",e);
        }
  }


}

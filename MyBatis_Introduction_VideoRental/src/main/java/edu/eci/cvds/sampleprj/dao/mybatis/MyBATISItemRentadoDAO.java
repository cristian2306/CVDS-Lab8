package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.entities.ItemRentado;
import java.sql.SQLException;
import java.util.List;


public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

    private static final int MULTA_DIARIA=5000;

  @Inject
  private ItemRentadoMapper iRentadoMapper;  

  @Override
  public void save(ItemRentado tItem) throws PersistenceException{
  try{
      iRentadoMapper.insertarItemRentado(tItem);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el tipo de item "+ tItem.toString(),e);
  }        

  }

  @Override
  public ItemRentado load(int id) throws PersistenceException {
        try{
            return iRentadoMapper.consultarItemRentado(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el tipo de Item "+id,e);
        }
    }

  @Override
  public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException{
        try{
            return iRentadoMapper.consultarItemsCliente(idCliente);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los items del cliente "+idCliente);
        }
  }

 @Override
 public ItemRentado consultarItemRentado(long idCliente, int idRentado) throws PersistenceException{
     try{
         return iRentadoMapper.consultarItemRentado(idCliente, idRentado);
     } catch(org.apache.ibatis.exceptions.PersistenceException e){
        throw new PersistenceException("Error al consultar el item rentado"+idCliente);
    }
 }



}

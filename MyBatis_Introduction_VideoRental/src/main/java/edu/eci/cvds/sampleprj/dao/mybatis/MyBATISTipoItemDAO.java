package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

public class MyBATISTipoItemDAO implements ItemDAO{

  @Inject
  private TipoItemMapper tItemMapper;    

  @Override
  public void save(TipoItem tItem) throws PersistenceException{
  try{
      tItemMapper.insertTipoItem(tItem);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el tipo de item "+ tItem.toString(),e);
  }        

  }

  @Override
  public TipoItem load(int id) throws PersistenceException {
  try{
      return tItemMapper.consultartipoItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el tipo de Item "+id,e);
  }


  }

  }

package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
<<<<<<< HEAD
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

=======
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.sampleprj.dao.*;
import java.sql.SQLException;

public class MyBATISTipoItemDAO implements TipoItemDAO{
    
  @Inject
  private TipoItemMapper tipoMapper;

  @Override
  public void save(TipoItem tipoItem) throws PersistenceException{
  try{
    tipoMapper.addTipoItem(tipoItem);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el tipo de item ",e);
  }        
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe
  }

  @Override
  public TipoItem load(int id) throws PersistenceException {
  try{
<<<<<<< HEAD
      return tItemMapper.consultartipoItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el tipo de Item "+id,e);
  }


  }

  }
=======
      return tipoMapper.getTipoItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el tipo de item "+id,e);
  }
  }





}
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe

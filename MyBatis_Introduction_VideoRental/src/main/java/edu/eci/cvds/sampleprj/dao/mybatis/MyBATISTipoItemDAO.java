package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
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
  }

  @Override
  public TipoItem load(int id) throws PersistenceException {
  try{
      return tipoMapper.getTipoItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el tipo de item "+id,e);
  }
  }





}

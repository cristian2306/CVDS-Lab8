package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.TipoItem;


public interface TipoItemDAO {
    
    public void save(TipoItem descripcion) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;

    public List<TipoItem> consultarTiposItem() throws PersistenceException;
}

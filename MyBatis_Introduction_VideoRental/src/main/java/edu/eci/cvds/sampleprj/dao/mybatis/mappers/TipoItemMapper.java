package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemMapper {
    
    
    public List<TipoItem> getTiposItems();
    
<<<<<<< HEAD
    public TipoItem getTipoItem(@Param("id")int id);
    
    public void addTipoItem(@Param("tItem")TipoItem tItem);
=======
    public TipoItem getTipoItem(
        @Param("identiTipo") int id);
    
    public void addTipoItem(
        @Param("tipo") TipoItem tipo);
>>>>>>> b8c5a59b81d9c408ef6df887a51215477504e8fe

}

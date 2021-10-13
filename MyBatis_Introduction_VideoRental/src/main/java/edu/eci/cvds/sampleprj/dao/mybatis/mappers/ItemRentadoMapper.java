package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemRentadoMapper {
    
    
    public List<ItemRentado> consultarItemsRentados();        
    
    public Item consultarItemRentado(
            @Param("IdItemRentado") int id);
    
    public void insertarItemRentado(@Param("itemRentado") ItemRentado iR);

    public List<ItemRentado> consultarItemsCliente(@Param("idCliente")long idCliente);

 
    


        
}


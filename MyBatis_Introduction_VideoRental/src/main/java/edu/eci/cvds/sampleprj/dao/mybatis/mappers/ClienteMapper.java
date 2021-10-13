package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2167892
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") long id);
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param idic
     * @param idi
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idic") long idic, 
            @Param("idi") int idi, 
            @Param("fechainicio") Date fechainicio,
            @Param("fechafin") Date fechafin );

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();

    /**
     * Insertar un cliente a la base de datos
     * @param cliente
     */
    public void insertarCliente(@Param("cliente") Cliente cliente);

}

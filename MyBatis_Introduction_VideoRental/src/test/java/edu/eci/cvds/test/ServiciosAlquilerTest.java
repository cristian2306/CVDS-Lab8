package edu.eci.cvds.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import jdk.jfr.Timestamp;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    private ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }
    /*
    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            long documento = 1001345800;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(0);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };

    }

    @Test 
    public void deberiaRetornarValorMultaxDia(){
        //Se valida que retorne el valor de multa, que en esta caso es 5000
        Assert.assertEquals(5000,serviciosAlquiler.valorMultaRetrasoxDia(1));
    }

    @Test 
    public void deberiaConsultarCliente(){
        try{
            Assert.assertEquals(68,serviciosAlquiler.consultarCliente(68).getDocumento());
        }
        catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }
    

    @Test
    public void deberiaConsultarItemsCliente(){
        try{
            Assert.assertTrue(20000,serviciosAlquiler.consultarItemsCliente(68).get(0).getId());
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }

    @Test
    public void deberiaConsultarClientes(){
        try{
            for(Cliente cliente:serviciosAlquiler.consultarClientes()){
                Assert.assertTrue(cliente instanceof Cliente);
            }
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }
    
    @Test
    public void deberiaConsultarItem(){
        try{
            Assert.assertEquals(serviciosAlquiler.consultarItem(16).getNombre(),"Juego");
        }catch(Exception e){
            Assert.fail("No deberia lanzar erro");
        }
    }    

    @Test
    public void deberiaConsultarItemsDisponibles(){
        try{
            for(Item item:serviciosAlquiler.consultarItemsDisponibles()){
                Assert.assertTrue(item instanceof Item);
            }
        }catch(Exception e){
                Assert.fail("No deberia lanzar error");
        }
    }

    @Test deberiaRegistrarAlquilerCliente(){
        long clienteId = 68;
        ItemRentadoMapper irm;
        try{
            Item item = serviciosAlquiler.consultarItem(16);
            serviciosAlquiler.registrarAlquilerCliente(Date.valueOf("2021-10-01"), clienteId, item, 12);
            Assert.assertTrue(16,irm.consultarItemRentado(clienteId, 16));
        }
    }

    @Test
    public void deberiaconsultarMultaAlquiler(){
        try{
            Assert.assertEquals(60000,serviciosAlquiler.valorMultaRetrasoxDia(16));
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
        
    }

    @Test
    public void deberiaConsultarTipoItem(){
        try{
            Assert.assertEquals(serviciosAlquiler.consultarTipoItem(90).getDescripcion(),"Aventura");
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }

    @Test
    public void deberiaConsultarTiposItem(){
        try{
            for(TipoItem ti: serviciosAlquiler.consultarTiposItem()){
                Assert.asserTrue(ti instaceof TipoItem);
            }
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }

    @Test 
    public void deberiaRegistrarCliente(){
        Cliente cliente = new Cliente("prueba", (long)1010987897, "3008976541", "Cll 93", "prueba@mail.com");
        try{
            serviciosAlquiler.registrarCliente(cliente);
            Assert.assertEquals(serviciosAlquiler.consultarCliente((long)1010987897),cliente);
        }catch(Exception e){
            Assert.fail("No deberia lanzar error");
        }
    }


    */

}
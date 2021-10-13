package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import java.lang.annotation.Inherited;
import java.sql.Date;
<<<<<<< HEAD
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
=======
import java.util.Calendar;
>>>>>>> ffe86f0009098a1c032df8edb449617a104cbb69
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   @Inject
   private ClienteDAO clienteDAO;
   @Inject
   private ItemRentadoDAO iRentadoDAO;
   @Inject
   private TipoItemDAO tItemDAO;
   private static final int MULTA_DIARIA=5000;


   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       //mandar los dias de retraso y multiplicarlos por la multa diaria
       //se tiene los dias de retraso a partir de itemRentado donde está
       //la fecha de terminacion de la renta
       return MULTA_DIARIA;
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
       try{
          return clienteDAO.load(docu);
       }catch (PersistenceException ex){
        throw new ExcepcionServiciosAlquiler("Error al consultar el cliente"+docu,ex);
       }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idCliente) throws ExcepcionServiciosAlquiler {
        try{
            return iRentadoDAO.consultarItemsCliente(idCliente);
        }catch(PersistenceException e){
            throw new ExcepcionServiciosAlquiler("Error al consultar los items del cliente "+idCliente);
        }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
       try{
           return clienteDAO.consultarClientes();
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Erro al consultar los clientes",e);
        }
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler{
       try{
            return itemDAO.consultarItems();
       }catch(PersistenceException e){
        throw new ExcepcionServiciosAlquiler("Error al consultar los items disponibles",e);
       }
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion, long idCliente) throws ExcepcionServiciosAlquiler {
       try{
           consultarItem(iditem);
           consultarCliente(idCliente);
           ItemRentado rentado = iRentadoDAO.consultarItemRentado(idCliente, iditem);
           LocalDate inicio = rentado.getFechainiciorenta().toLocalDate();
           LocalDate fin = rentado.getFechafinrenta().toLocalDate();
           LocalDate entrega = fechaDevolucion.toLocalDate();
           //PARTE LOGICA
            if(entrega.isBefore(inicio)){
                throw new ExcepcionServiciosAlquiler("Día de entrega invalido");
            }
            else if(entrega.isBefore(fin)){
                return 0;
            }
            else{
                long retraso = ChronoUnit.DAYS.between(fin,entrega);
                return retraso*MULTA_DIARIA;
            }           
       }catch(PersistenceException persistenceException){
           throw new ExcepcionServiciosAlquiler("Error al consultar la multa de alquiler");
       }
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       try{
           return tItemDAO.load(id);
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al consultar el tipo Item "+id,e);
       }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       try{
           return tItemDAO.consultarTiposItem();
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al consultar los tipos de item",e);
       }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
       try{
            clienteDAO.registrarAlquiler(date, docu, item, numdias);
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al registrar el alquiler",e);
       }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       try{
           clienteDAO.save(c);
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al registrar al cliente",e);
       }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       Item item = consultarItem(iditem);
       if(numdias < 0){
           throw new ExcepcionServiciosAlquiler("Días de alquiler no válidos");
       }
       return item.getTarifaxDia() *numdias;
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       try{
           itemDAO.actualizarTarifa(id, tarifa);
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al registrar al cliente",e);
       }
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       try{
           itemDAO.save(i);
       }catch(PersistenceException e){
           throw new ExcepcionServiciosAlquiler("Error al registrar el item",e);
       } 
       //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       
   }
}
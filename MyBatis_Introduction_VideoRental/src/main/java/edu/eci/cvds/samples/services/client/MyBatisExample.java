/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.*;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        ClienteMapper cm= (ClienteMapper)sqlss.getMapper(ClienteMapper.class);
        ItemMapper im= (ItemMapper)sqlss.getMapper(ItemMapper.class);
        ItemRentadoMapper ip = (ItemRentadoMapper)sqlss.getMapper(ItemRentadoMapper.class);

        System.out.println("-----------------Consultar Clientes----------------");
       // System.out.println(cm.consultarClientes());
        System.out.println("-----------------Consultar Cliente: --------------");
        //System.out.println(cm.consultarCliente(68));
        System.out.println("-----------------Añadiendo itemRentado al cliente 56155 el item 1 ");
       // cm.agregarItemRentadoACliente(56155, 1, Date.valueOf("2021-09-5"), Date.valueOf("2020-10-5"));
        System.out.println("-----------------Consultar Items----------------");
        System.out.println(im.consultarItems());
        System.out.println("-----------------Consultar Item: 20000 --------------");

        System.out.println(im.consultarItem(20000));

        //System.out.println(im.consultarItem(20000));

        System.out.println("-----------------Consultar multa --------------");
        System.out.println(ip.consultarItemsRentados());
        sqlss.commit();
        sqlss.close();

        
        
    }


}

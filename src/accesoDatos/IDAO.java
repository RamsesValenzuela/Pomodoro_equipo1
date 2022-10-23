/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.ResultSet;

/**
 *
 * @author PC
 * @param <T>
 */
public interface IDAO<T>{
    
    public void insertar(T obj) throws Exception;
    public void actualizar(T obj) throws Exception;
    public void eliminar(int id) throws Exception;
    public T consultarPorId(int id) throws Exception;
    public ResultSet consultarTodos() throws Exception;
}

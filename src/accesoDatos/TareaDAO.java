/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objeto.Tarea;

/**
 *
 * @author PC
 */
public class TareaDAO extends DatabaseConnection implements IDAO<Tarea> {

    public TareaDAO() {
        super();
    }

    @Override
    public void insertar(Tarea obj) throws Exception {
        Tarea exist=consultarPorNombre(obj.getNombre());
        if(exist!=null&&exist.getEstado()!=2){
            throw new Exception("ya existe la tarea");
        }else{
            String sql = "INSERT INTO `tarea` (`idtarea`, `nombre`, `estado`) VALUES (NULL, ? , ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.setString(1, obj.getNombre());
        ps.setInt(2, 0);

        ps.executeUpdate();
        ps.close();
        }
        
    }

    @Override
    public void actualizar(Tarea obj) throws Exception {
        String sql = String.format("UPDATE tarea SET estado = '%d' WHERE idtarea = %d",
                obj.getEstado(),
                obj.getId());

        Statement statement = con.createStatement();

        int registroAfectado = statement.executeUpdate(sql);
        if (registroAfectado != 1) {
            throw new Exception("El estado de la tarea no ha podido ser actualizado.");
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Tarea consultarPorNombre(String nombreB) throws Exception {
        Tarea tarea=null;
        try {
            Statement stmtCon = con.createStatement();
            String codigoSQL = "SELECT * FROM `tarea` WHERE nombre="+nombreB;
            ResultSet rs = stmtCon.executeQuery(codigoSQL);

            while (rs.next()) {
                int idTarea = rs.getInt("idtarea");
                String nombre = rs.getString("nombre");
                int estado = rs.getInt("estado");

                tarea = new Tarea(idTarea, nombre, estado);
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return tarea;
    }
    @Override
    public Tarea consultarPorId(int id) throws Exception {
        Tarea tarea=null;
        try {
            Statement stmtCon = con.createStatement();
            String codigoSQL = "SELECT * FROM `tarea` WHERE idtarea="+id;
            ResultSet rs = stmtCon.executeQuery(codigoSQL);

            while (rs.next()) {
                int idTarea = rs.getInt("idtarea");
                String nombre = rs.getString("nombre");
                int estado = rs.getInt("estado");

                tarea = new Tarea(idTarea, nombre, estado);
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return tarea;
    }

    @Override
    public ResultSet consultarTodos() throws Exception {
        return null;
//        String sql = "SELECT * FROM `tarea` ORDER BY nombre ASC";
//        try {
//            return stmt.executeQuery(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
    }

    public ArrayList<Tarea> consultar() {
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        try {
            Statement stmtCon = con.createStatement();
            String codigoSQL = "SELECT * FROM `tarea`";
            ResultSet rs = stmtCon.executeQuery(codigoSQL);

            while (rs.next()) {
                int idTarea = rs.getInt("idtarea");
                String nombre = rs.getString("nombre");
                int estado = rs.getInt("estado");

                Tarea tarea = new Tarea(idTarea, nombre, estado);
                listaTareas.add(tarea);
            }

            return listaTareas;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

}

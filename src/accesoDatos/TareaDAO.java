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
import java.time.LocalDateTime;
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
        Tarea exist = consultarPorNombre(obj.getNombre());

        if (exist != null && exist.getEstado() != 2) {
            throw new Exception("La tarea insertada ya existe...");

        } else {
            String sql = "INSERT INTO `tarea` ( `idtarea`,`nombre`, `estado`, `fechaterm`, `prioridad`) VALUES (NULL, ? , ?,NULL,?)";
            PreparedStatement ps = null;
            try {
                ps = con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setString(1, obj.getNombre());
            ps.setInt(2, 0);
            ps.setInt(3, 0);

            ps.executeUpdate();
            ps.close();
        }

    }
    public void actualizarNombre(Tarea obj) throws Exception {
        Tarea exist = consultarPorNombre(obj.getNombre());

        if (exist != null && exist.getEstado() != 2) {
            throw new Exception("El nombre de la tarea a actualizar ya existe...");

        }
        String sql = String.format("UPDATE tarea SET nombre = '%s' WHERE idtarea = %d",
                obj.getNombre(),
                obj.getId());

        Statement statement = con.createStatement();

        int registroAfectado = statement.executeUpdate(sql);
        if (registroAfectado != 1) {
            throw new Exception("El nombre de la tarea no ha podido ser actualizado.");
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

    public void actualizarFecha(Tarea obj) throws Exception {
        String sql = String.format("UPDATE tarea SET fechaterm = '%s' WHERE idtarea = %d",
                obj.getFechaDeTerminacion().toString(),
                obj.getId());

        Statement statement = con.createStatement();

        int registroAfectado = statement.executeUpdate(sql);
        if (registroAfectado != 1) {
            throw new Exception("El estado de la tarea no ha podido ser actualizado.");
        }
    }

    public void actualizarPrioridad(Tarea obj) throws Exception {
        String sql = String.format("UPDATE tarea SET prioridad = '%d' WHERE idtarea = %d",
                obj.getPrioridad(),
                obj.getId());

        Statement statement = con.createStatement();

        int registroAfectado = statement.executeUpdate(sql);
        if (registroAfectado != 1) {
            throw new Exception("El estado de la tarea no ha podido ser actualizado.");
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        
                try {
            
            String codigoSQL = String.format("DELETE FROM tarea WHERE idtarea='%d'", id);
            PreparedStatement stmtCon = con.prepareStatement(codigoSQL);
            stmtCon.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Tarea consultarPorNombre(String nombreB) throws Exception {
        Tarea tarea = null;
        try {
            Statement stmtCon = con.createStatement();
            String codigoSQL = String.format("SELECT * FROM `tarea` WHERE nombre = '%s'", nombreB);
            ResultSet rs = stmtCon.executeQuery(codigoSQL);

            while (rs.next()) {
                int idTarea = rs.getInt("idtarea");
                String nombre = rs.getString("nombre");
                int estado = rs.getInt("estado");
                LocalDateTime fechaterm = estado!=2?null:LocalDateTime.parse(rs.getString("fechaterm"));
                int prioridad = rs.getInt("prioridad");

                tarea = new Tarea(idTarea, nombre, estado, fechaterm, prioridad);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return tarea;
    }

    @Override
    public Tarea consultarPorId(int id) throws Exception {
        Tarea tarea = null;
        try {
            Statement stmtCon = con.createStatement();
            String codigoSQL = "SELECT * FROM `tarea` WHERE idtarea=" + id;
            ResultSet rs = stmtCon.executeQuery(codigoSQL);

            while (rs.next()) {
                int idTarea = rs.getInt("idtarea");
                String nombre = rs.getString("nombre");
                int estado = rs.getInt("estado");
                LocalDateTime fechaterm =estado!=2?null: LocalDateTime.parse(rs.getString("fechaterm"));
                int prioridad = rs.getInt("prioridad");
                tarea = new Tarea(idTarea, nombre, estado, fechaterm, prioridad);
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
                LocalDateTime fechaterm = rs.getString("fechaterm")==null?LocalDateTime.now():LocalDateTime.parse(rs.getString("fechaterm"));
                int prioridad = rs.getInt("prioridad");

                Tarea tarea = new Tarea(idTarea, nombre, estado, fechaterm, prioridad);
                listaTareas.add(tarea);
            }

            return listaTareas;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

}

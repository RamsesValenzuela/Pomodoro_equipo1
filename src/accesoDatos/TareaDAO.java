/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "INSERT INTO `tarea` (`idtarea`, `nombre`, `desc`, `estado`) VALUES (NULL, ?, ? , ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.setString(1, obj.getNombre());
        ps.setString(2, obj.getDescripcion());
        ps.setInt(3, 0);

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void actualizar(Tarea obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarea consultarPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet consultarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

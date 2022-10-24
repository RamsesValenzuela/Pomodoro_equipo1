/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import accesoDatos.TareaDAO;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objeto.Tarea;

/**
 *
 * @author PC
 */
public class fmrTareasPendientes extends javax.swing.JFrame {
    TareaDAO tareaDAO;
    /**
     * Creates new form fmrTareasPendientes
     */
    public fmrTareasPendientes() {
        initComponents();
        this.setTitle("Lista de tareas");
        tareaDAO = new TareaDAO();
        this.llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        btn_ArrowDown = new javax.swing.JButton();
        btn_ArrowUP = new javax.swing.JButton();
        btn_agregarTarea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTareas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaTareas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 772, 521));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Estado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 290, 30));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, -1, -1));

        jButton2.setText("jButton2");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, -1, -1));
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 290, 30));

        btn_ArrowDown.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btn_ArrowDown.setText("↓");
        btn_ArrowDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ArrowDownActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ArrowDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, 70, 70));

        btn_ArrowUP.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btn_ArrowUP.setText("↑");
        btn_ArrowUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ArrowUPActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ArrowUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 70, 70));

        btn_agregarTarea.setText("Agregar una nueva tarea");
        btn_agregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void btn_ArrowUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ArrowUPActionPerformed
        this.subirTarea();
    }//GEN-LAST:event_btn_ArrowUPActionPerformed

    private void btn_ArrowDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ArrowDownActionPerformed
        this.bajarTarea();
    }//GEN-LAST:event_btn_ArrowDownActionPerformed

    private void btn_agregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarTareaActionPerformed
        fmrTareas fmrtareas = new fmrTareas();
        fmrtareas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_agregarTareaActionPerformed

    boolean rowSeleccionado = false;
    int index;
    DefaultTableModel model;

    public void subirTarea() {
        if (rowSeleccionado == false) 
        {
            model = (DefaultTableModel) tablaTareas.getModel();
            rowSeleccionado = true;
        }

        index = tablaTareas.getSelectedRow();

        if (index == -1) 
        {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un fila primero!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (index > 0) {
            model.moveRow(index, index, index - 1);
            tablaTareas.setRowSelectionInterval(index - 1, index - 1);
        }
    }

    public void bajarTarea() {
        if (rowSeleccionado == false) 
        {
            model = (DefaultTableModel) tablaTareas.getModel();  
            rowSeleccionado = true;
        }

        index = tablaTareas.getSelectedRow();

        if (index == -1) 
        {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un fila primero!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (index < model.getRowCount() - 1) 
        {
            model.moveRow(index, index, index + 1);
            tablaTareas.setRowSelectionInterval(index + 1, index + 1);
        }
    }

    public void llenarTabla() {
       try {
            ArrayList<Tarea> listaTareas = tareaDAO.consultar();
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTareas.getModel();
            modeloTabla.setRowCount(0);
            
            for (Tarea tarea : listaTareas) {
               Object[] filaDatos = new Object[3];
               
               filaDatos[0] = tarea.getId();
               filaDatos[1] = tarea.getNombre();
               filaDatos[2] = tarea.getEstado();
               
               modeloTabla.addRow(filaDatos);
           }
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmrTareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmrTareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmrTareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmrTareasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmrTareasPendientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ArrowDown;
    private javax.swing.JButton btn_ArrowUP;
    private javax.swing.JButton btn_agregarTarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

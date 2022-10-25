/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class FmrPomodoro extends javax.swing.JFrame {

    private Timer timer;
    private int numPomodoro;
    boolean pausa;

    /**
     * Creates new form FmrPomodoro
     */
    public FmrPomodoro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTiempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnPausa = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTiempo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTiempo.setText("0:00:00");
        lbTiempo.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pomodoro");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnPausa.setText("Pausar");
        btnPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausaActionPerformed(evt);
            }
        });

        btnRestart.setText("Restablecer");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnIniciar)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnPausa)
                        .addGap(40, 40, 40)
                        .addComponent(btnRestart))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnPausa)
                    .addComponent(btnRestart))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        btnPausa.setEnabled(true);
        btnRestart.setEnabled(true);
        pomodoroTimer();
        numPomodoro = 1;
        pausa = false;
        btnIniciar.setEnabled(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausaActionPerformed
        if (!pausa) {
            pausa = true;
            btnRestart.setEnabled(false);
        } else {
            pausa = false;
            btnPausa.setText("Pause");
            btnRestart.setEnabled(true);
        }
    }//GEN-LAST:event_btnPausaActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        timer.cancel();
        lbTiempo.setText("00:00:00");
        btnPausa.setEnabled(false);
        btnRestart.setEnabled(false);
        btnIniciar.setEnabled(true);
    }//GEN-LAST:event_btnRestartActionPerformed

    public void setTime(int time) {
        int timeNow = 1000 * time;
        int second = (timeNow / 1000) % 60;
        int minute = (timeNow / (1000 * 60)) % 60;
        int hour = (timeNow / (1000 * 60 * 60)) % 24;
        lbTiempo.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    private void pomodoroTimer() {
        String pomodoroTime = "0:00:25";
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int counter = 0;

            String[] customTime = pomodoroTime.split(":");
            int cont = Integer.parseInt(customTime[0]) * 60 * 60 + Integer.parseInt(customTime[1]) * 60
                    + Integer.parseInt(customTime[2]);

            @Override
            public void run() {
                if (!pausa) {
                    ++counter;
                    setTime(counter);
                    if (counter == cont && numPomodoro < 4) //if less than 4 pomodoros are complete, take a short break
                    {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Completaste un pomodoro, Puedes tomar un pequeño descanso!!");
                        descansoCorto();
                        numPomodoro++;
                    } else if (counter == cont && numPomodoro == 4) //if 4 pomodoros are complete, take a long break
                    {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Completaste 4 pomodoros, Puedes tomar un gran descanso!!");
                        descansoLargo();
                    }
                }
            }
        }, 0, 1000);

    }

    private void descansoCorto() {
        String descansoCorto = "0:00:05";
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int cont = 0;
            String[] tiempo = descansoCorto.split(":");
            int lim = Integer.parseInt(tiempo[0]) * 60 * 60 + Integer.parseInt(tiempo[1]) * 60
                    + Integer.parseInt(tiempo[2]);

            @Override
            public void run() {
                if (!pausa) {
                    ++cont;
                    setTime(cont);
                    if (cont == lim) {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Descanso corto finalizado");
                        pomodoroTimer();

                    }
                }
            }
        }, 0, 1000);
    }

    private void descansoLargo() {
        String descansoLargo = "0:00:10";
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int cont = 0;
            String[] customTime = descansoLargo.split(":");
            int counterLimit = Integer.parseInt(customTime[0]) * 60 * 60 + Integer.parseInt(customTime[1]) * 60
                    + Integer.parseInt(customTime[2]);

            @Override
            public void run() {
                if (!pausa) {
                    ++cont;
                    setTime(cont);
                    if (cont == counterLimit) {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Es hora de continuar con las tareas.");
                        numPomodoro = 1;
                        pomodoroTimer();
                    }
                }
            }
        }, 0, 1000);
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
            java.util.logging.Logger.getLogger(FmrPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmrPomodoro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPausa;
    private javax.swing.JButton btnRestart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbTiempo;
    // End of variables declaration//GEN-END:variables
}

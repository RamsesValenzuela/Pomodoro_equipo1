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
import objeto.Tarea;

/**
 *
 * @author PC
 */
public class FmrPomodoro extends javax.swing.JFrame {

    private Timer timer;
    private int numPomodoro;
    private boolean pausa;
    private Tarea haciendo;
    private String leyenda="Haciendo: ";
    /**
     * Creates new form FmrPomodoro
     * @param tarea
     */
    public FmrPomodoro(Tarea tarea) {
        this.haciendo=tarea;
        initComponents();
        this.jLabel3.setText(leyenda+tarea.getNombre());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTiempo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTiempo.setText("0:00:00");
        lbTiempo.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Descansos antes del descanso largo: 3");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Pomodoro");

        jLabel3.setText("Haciendo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnIniciar)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnPausa)
                                .addGap(40, 40, 40)
                                .addComponent(btnRestart))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnPausa)
                    .addComponent(btnRestart))
                .addContainerGap(25, Short.MAX_VALUE))
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
            this.btnPausa.setText("Reanudar");
        } else {
            pausa = false;
            btnPausa.setText("Pause");
            btnRestart.setEnabled(true);
            this.btnPausa.setText("Pausar");
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
        String pomodoroTime = "0:00:15";
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
                    if (counter==(cont-5)) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "5 segundos para el descanso");
                    }
                    if (counter == cont && numPomodoro < 4) //if less than 4 pomodoros are complete, take a short break
                    {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Completaste un pomodoro, Puedes tomar un pequeño descanso!!");
                        descansoCorto();
                        
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
        String descansoCorto = "0:00:07";
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
                    if (cont==(lim-5)) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "5 segundos para empezar de nuevo");
                    }
                    if (cont == lim) {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Descanso corto finalizado");
                        numPomodoro++;
                        int descansosFaltantes=4-numPomodoro;
                        jLabel1.setText(descansosFaltantes!=0?"Descansos antes del descanso largo: "+(4-numPomodoro):"El siguiente es un descanso largo!!");
                        pomodoroTimer();

                    }
                }
            }
        }, 0, 1000);
    }

    private void descansoLargo() {
        String descansoLargo = "0:00:10";
        jLabel1.setText("Descanso largo!!! ");
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
                    if (cont==(counterLimit-5)) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "5 segundos para empezar de nuevo");
                    }
                    if (cont == counterLimit) {
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Es hora de continuar con las tareas.");
                        numPomodoro = 1;
                        jLabel1.setText("Descansos antes del descanso largo: "+(4-numPomodoro));
                        pomodoroTimer();
                    }
                }
            }
        }, 0, 1000);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPausa;
    private javax.swing.JButton btnRestart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbTiempo;
    // End of variables declaration//GEN-END:variables
}

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
    private Timer timerBlink;
    private int numPomodoro;
    private boolean pausa;
    private Tarea haciendo;
    private final String leyenda = "Haciendo: ";
    private final String leyendaCont = "Faltan:";
    private final String pomodoroTime = "0:00:15";
    private final String descansoCorto = "0:00:07";
    private final String descansoLargo = "0:00:10";

    /**
     * Creates new form FmrPomodoro
     *
     * @param tarea
     */
    public FmrPomodoro(Tarea tarea) {

        this.haciendo = tarea;
        initComponents();
        this.jLabel3.setText(leyenda + haciendo.getNombre());
        btnRestart.setEnabled(false);
        btnPausa.setEnabled(false);
        jLabel4.setVisible(false);
        setLocationRelativeTo(null);
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
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

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

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPausa)
                                .addGap(40, 40, 40)
                                .addComponent(btnRestart)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnPausa)
                    .addComponent(btnRestart))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
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
        jButton1.setEnabled(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausaActionPerformed
        if (!pausa) {
            pausa = true;
            this.btnPausa.setText("Reanudar");
            
        } else {
            pausa = false;
            btnPausa.setText("Pause");
            btnRestart.setEnabled(true);
            this.btnPausa.setText("Pausar");
            
        }
        blink();
    }//GEN-LAST:event_btnPausaActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro de querer reiniciar?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.OK_OPTION) {
            timer.cancel();
            lbTiempo.setText("00:00:00");
            btnPausa.setEnabled(false);
            btnRestart.setEnabled(false);
            btnIniciar.setEnabled(true);
            jButton1.setEnabled(true);
            this.btnPausa.setText("Pausar");
            jLabel4.setVisible(false);
            numPomodoro=1;
            jLabel1.setText((4 - numPomodoro) != 0 ? "Descansos antes del descanso largo: " + (4 - numPomodoro) : "El siguiente es un descanso largo!!");
        }
    }//GEN-LAST:event_btnRestartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fmrTareasPendientes frm = new fmrTareasPendientes();
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setTime(int time) {
        int timeNow = 1000 * time;
        int second = (timeNow / 1000) % 60;
        int minute = (timeNow / (1000 * 60)) % 60;
        int hour = (timeNow / (1000 * 60 * 60)) % 24;
        lbTiempo.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }
    private void blink(){
        
        if (!pausa) {
            timerBlink.cancel();
            lbTiempo.setEnabled(true);
        }else{
            
        timerBlink=new Timer();
        timerBlink.schedule(new TimerTask(){
            int counter=0;
            @Override
            public void run() {
                counter++;
                if (counter%2==0) {
                    lbTiempo.setEnabled(false);
                }else{
                    lbTiempo.setEnabled(true);
                }
            }
        }, 0,1000);
        }
    }
    private void bip(){
        timerBlink=new Timer();
        timerBlink.schedule(new TimerTask(){
            int counter=0;
            @Override
            public void run() {
                counter++;
                if (counter%2==0) {
                    Toolkit.getDefaultToolkit().beep();
                }
                
            }
        }, 0,1000);
        
    }
    private void pomodoroTimer() {
        jLabel4.setVisible(false);
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
                    if (counter >= (cont - 5)) {
                        Toolkit.getDefaultToolkit().beep();
                        jLabel4.setVisible(true);
                        jLabel4.setText(leyendaCont + " " + (cont - counter) + " segundos para el descanso");
                    }
                    if (counter == cont) {
                        bip();
                        int opcion = JOptionPane.showConfirmDialog(null, numPomodoro < 4 ? "Completaste un pomodoro, Quieres omitir un pequeño descanso??" : "Completaste 4 pomodoros, Quieres omitir un gran descanso??", "Descanso!!", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        jLabel4.setVisible(false);
                        timer.cancel();
                        
                        int confirm=JOptionPane.NO_OPTION;
                        timerBlink.cancel();
                        if (opcion==JOptionPane.YES_OPTION) {
                            confirm = JOptionPane.showConfirmDialog(null, "Seguro que deseas omitir?", "Confirmacion!!", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        }
                        if (confirm == JOptionPane.NO_OPTION) {
                            
                            if (numPomodoro < 4) //if less than 4 pomodoros are complete, take a short break
                            {
                                descansoCorto();

                            } else if (numPomodoro == 4) //if 4 pomodoros are complete, take a long break
                            {
                                descansoLargo();
                            }
                        } else {
                            
                            if (numPomodoro == 4) {
                                numPomodoro = 1;
                            }else{
                            numPomodoro++;
                            }
                            jLabel1.setText((4 - numPomodoro) != 0 ? "Descansos antes del descanso largo: " + (4 - numPomodoro) : "El siguiente es un descanso largo!!");
                            pomodoroTimer();
                        }
                    }
                }
            }
        }, 0, 1000);

    }

    private void descansoCorto() {
        jLabel4.setVisible(false);
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
                    if (cont >= (lim - 5)) {
                        Toolkit.getDefaultToolkit().beep();
                        jLabel4.setVisible(true);
                        jLabel4.setText(leyendaCont + " " + (lim - cont) + " segundos para el descanso");
                    }
                    if (cont == lim) {
                        bip();
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Descanso corto finalizado");
                        timerBlink.cancel();
                        numPomodoro++;
                        int descansosFaltantes = 4 - numPomodoro;
                        jLabel1.setText(descansosFaltantes != 0 ? "Descansos antes del descanso largo: " + (4 - numPomodoro) : "El siguiente es un descanso largo!!");
                        pomodoroTimer();

                    }
                }
            }
        }, 0, 1000);
    }

    private void descansoLargo() {
        jLabel4.setVisible(false);
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
                    if (cont >= (counterLimit - 5)) {
                        Toolkit.getDefaultToolkit().beep();
                        jLabel4.setVisible(true);
                        jLabel4.setText(leyendaCont + " " + (counterLimit - cont) + " segundos para el descanso");
                    }
                    if (cont == counterLimit) {
                        bip();
                        timer.cancel();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Es hora de continuar con las tareas.");
                        timerBlink.cancel();
                        numPomodoro = 1;
                        jLabel1.setText("Descansos antes del descanso largo: " + (4 - numPomodoro));
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbTiempo;
    // End of variables declaration//GEN-END:variables
}

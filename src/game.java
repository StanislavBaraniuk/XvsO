
import java.awt.Color;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stanislaw
 */
class AI {
    private String[] winCombination = {"036", "147", "258", "345", "678", "012", "048", "246"};
    private int[] steps = new int[8];
    private String[] winCombinationArray = new String[5];
    
    public void step(int fr, int i) {
        int[] free = new int[8];
        free[i] = fr;
        
    }
    
    public int getSteps(int i) {return this.steps[i];}
    public String getWinCombination(int i) { return this.winCombination[i];}
}

class Cub {
    private int[] cub = {2,3,4,5,6,7,8,9,10};
    public void setCub(int i, int cub) {this.cub[i] = cub;}
    public int getCub(int i) {return this.cub[i];}
}

public class game extends javax.swing.JFrame {
    
    static Cub cub = new Cub();
    static AI Engi = new AI();
    static AI Tom = new AI();
    int step = 1, win = 0, draw = 0;
    
    public void checkOnWin(String player) {
        if (cub.getCub(0) == cub.getCub(4) && cub.getCub(0) == cub.getCub(8)) {
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jTextArea1.setForeground(Color.red);
            jLabel3.setForeground(Color.red);
            jLabel5.setForeground(Color.red);
            jLabel8.setForeground(Color.red);
        } else if (cub.getCub(2) == cub.getCub(4) && cub.getCub(2) == cub.getCub(6)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel9.setForeground(Color.red);
            jLabel5.setForeground(Color.red);
            jLabel2.setForeground(Color.red);
            win = 1;
        } else if (cub.getCub(3) == cub.getCub(4) && cub.getCub(3) == cub.getCub(5)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel1.setForeground(Color.red);
         
            jLabel5.setForeground(Color.red);
        
            jLabel7.setForeground(Color.red);

            win = 1;
        } else if (cub.getCub(1) == cub.getCub(4) && cub.getCub(1) == cub.getCub(7)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel5.setForeground(Color.red);
   
            jLabel4.setForeground(Color.red);
     
            jLabel6.setForeground(Color.red);
 
            win = 1;
        } else if (cub.getCub(0) == cub.getCub(3) && cub.getCub(0) == cub.getCub(6)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel3.setForeground(Color.red);
           
            jLabel1.setForeground(Color.red);
        
            jLabel2.setForeground(Color.red);
          
            win = 1;
        } else if (cub.getCub(2) == cub.getCub(5) && cub.getCub(2) == cub.getCub(8)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel9.setForeground(Color.red);
            
            jLabel7.setForeground(Color.red);

            jLabel8.setForeground(Color.red);
   
            win = 1;
        } else if (cub.getCub(0) == cub.getCub(1) && cub.getCub(0) == cub.getCub(2)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel3.setForeground(Color.red);
            jLabel4.setForeground(Color.red);
            jLabel9.setForeground(Color.red);
            win = 1;
        } else if (cub.getCub(6) == cub.getCub(7) && cub.getCub(6) == cub.getCub(8)) {
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player " + player + " win");
            jLabel2.setForeground(Color.red);
            jLabel6.setForeground(Color.red);
            jLabel8.setForeground(Color.red);
            win = 1;
        } 
    }
    
    public boolean cubeChecker(int i) {
        boolean check = true;
        
        if (cub.getCub(i) == 1 || cub.getCub(i) == 0) {
            check = false;
        }
        
        return check;
    }
    
    public void step(int cubeNumber) {
        if (cubeChecker(cubeNumber) && win == 0) {
        step++;
        
        if (step == 2) {
            jTextArea1.setText("Game is started");
        } 
        
        
        if (step % 2 == 0) {
            jLabel10.setText("O");
            switch (cubeNumber) {
                case 0:
                    jLabel3.setText("X");
                    break;
                case 1:
                    jLabel4.setText("X");
                    break;
                case 2:
                    jLabel9.setText("X");
                    break;
                case 3:
                    jLabel1.setText("X");
                    break;
                case 4:
                    jLabel5.setText("X");
                    break;
                case 5:
                    jLabel7.setText("X");
                    break;
                case 6:
                    jLabel2.setText("X");
                    break;
                case 7:
                    jLabel6.setText("X");
                    break;
                case 8:
                    jLabel8.setText("X");
                    break;
                default:
                    break;
            }
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player X made a move in " + (cubeNumber + 1) + " cube");
            
            cub.setCub(cubeNumber, 1);
            checkOnWin("X");
        } else {
//            for (int i = 0; i <= 8; i++) {
//                Tom.step(cub.getCub(i), i);
//            }
            jLabel10.setText("X");
            switch (cubeNumber) {
                case 0:
                    jLabel3.setText("O");
                    break;
                case 1:
                    jLabel4.setText("O");
                    break;
                case 2:
                    jLabel9.setText("O");
                    break;
                case 3:
                    jLabel1.setText("O");
                    break;
                case 4:
                    jLabel5.setText("O");
                    break;
                case 5:
                    jLabel7.setText("O");
                    break;
                case 6:
                    jLabel2.setText("O");
                    break;
                case 7:
                    jLabel6.setText("O");
                    break;
                case 8:
                    jLabel8.setText("O");
                    break;
                default:
                    break;
            }
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Player X made a move in " + (cubeNumber + 1) + " cube");
            
            cub.setCub(cubeNumber, 0);
            checkOnWin("O");
        }
        if (step == 10) {
            if (draw < 1) {
            jTextArea1.setText(jTextArea1.getText() + "\n" + "Players have a draw");
            jTextArea1.setBackground(Color.DARK_GRAY);
            jTextArea1.setForeground(Color.yellow);
            jLabel1.setForeground(Color.yellow);
            jLabel2.setForeground(Color.yellow);
            jLabel3.setForeground(Color.yellow);
            jLabel4.setForeground(Color.yellow);
            jLabel5.setForeground(Color.yellow);
            jLabel6.setForeground(Color.yellow);
            jLabel7.setForeground(Color.yellow);
            jLabel8.setForeground(Color.yellow);
            jLabel9.setForeground(Color.yellow);
            }
            draw++;
            win = 1;
        }
        }
    }
      
    public void finish() {
        int forCub  = 1;
        step = 1;
        win = 0;
        draw = 0;
        for (int i = 0; i <= 8; i++) {
            forCub++;
            cub.setCub(i, forCub);
        }
        jLabel10.setText("GAME STORY");
        jTextArea1.setBackground(Color.white);
        jTextArea1.setForeground(Color.black);
        jLabel1.setForeground(Color.black);
        jLabel2.setForeground(Color.black);
        jLabel3.setForeground(Color.black);
        jLabel4.setForeground(Color.black);
        jLabel5.setForeground(Color.black);
        jLabel6.setForeground(Color.black);
        jLabel7.setForeground(Color.black);
        jLabel8.setForeground(Color.black);
        jLabel9.setForeground(Color.black);
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        jTextArea1.setText("");
    }
    
    public game() {
        initComponents();
        jButton5.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XvsO");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel3.setSize(new java.awt.Dimension(100, 100));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel1.setSize(new java.awt.Dimension(100, 100));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel2.setSize(new java.awt.Dimension(100, 100));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel4.setSize(new java.awt.Dimension(100, 100));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel5.setSize(new java.awt.Dimension(100, 100));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel6.setSize(new java.awt.Dimension(100, 100));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel7.setSize(new java.awt.Dimension(100, 100));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel8.setSize(new java.awt.Dimension(100, 100));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        jLabel10.setText("GAME STORY");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setDoubleBuffered(true);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("school time");

        jButton3.setText("help");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("RESTART");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jButton5.setVisible(false);
        
        finish();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        step(0);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        step(1);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        step(2);
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        step(3);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        step(4);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        step(5);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        step(6);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        step(7);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        step(8);
    }//GEN-LAST:event_jLabel8MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "To start the game press 'START' button and click on free cell \n You can restart the game by clicking 'RESTART'");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

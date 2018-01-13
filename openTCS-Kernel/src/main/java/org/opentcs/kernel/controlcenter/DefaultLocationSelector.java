/*
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.kernel.controlcenter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Heshan
 */
public class DefaultLocationSelector
    extends javax.swing.JDialog implements Runnable{

  private volatile boolean done;
  private KernelControlCenter controlCenter;
  private Map<String,String> defaultLocations;
  /**
   * Creates new form DefaultLocationSelector
   */
  public DefaultLocationSelector(Map<String,String> defaultValues,KernelControlCenter controlCenter) {
    done = false;
    this.controlCenter = controlCenter;
    this.defaultLocations = defaultValues;
    initComponents();
    setValues(defaultValues);
    
  }

  @Override
  public void run() {
    while(!done){
      
    }
    
  }

  /**
   * This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtRechargeLocation = new javax.swing.JTextField();
    btnOk = new javax.swing.JButton();

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setText("Recharging Location");

    txtRechargeLocation.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtRechargeLocationActionPerformed(evt);
      }
    });

    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnOkActionPerformed(evt);
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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtRechargeLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnOk)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtRechargeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
        .addComponent(btnOk)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txtRechargeLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRechargeLocationActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtRechargeLocationActionPerformed

  private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    // TODO add your handling code here:
    defaultLocations.put("recharge-location", txtRechargeLocation.getText());
    done = true;
    dispose();
  }//GEN-LAST:event_btnOkActionPerformed

  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnOk;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txtRechargeLocation;
  // End of variables declaration//GEN-END:variables

  private void setValues(Map<String,String> defaultValues){
    txtRechargeLocation.setText(defaultValues.get("recharge-location"));
  }
}

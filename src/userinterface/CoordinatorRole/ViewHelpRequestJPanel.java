/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

import business.Enterprise.Enterprise;
import business.Enterprise.FoodBankEnterprise;
import business.WorkQueue.GetHelpRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author asahoho
 */
public class ViewHelpRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private GetHelpRequest request;
    private FoodBankEnterprise enterprise;

    /**
     * Creates new form ViewHelpRequestJPanel
     */

    ViewHelpRequestJPanel(JPanel userProcessContainer, GetHelpRequest request, FoodBankEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
        txtSpecialRequest.setText(request.getMessage());
        txtID.setText(Integer.toString(request.getID()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSpecialRequest = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnUpdateStatus = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSpecialRequest.setColumns(20);
        txtSpecialRequest.setRows(5);
        jScrollPane1.setViewportView(txtSpecialRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 411, 213));

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("View Help Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setText("Request ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        btnUpdateStatus.setText("Update Status");
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });
        add(btnUpdateStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 124, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("UpdateStatus", new UpdateStatusJPanel(userProcessContainer, request, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdateStatusActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtSpecialRequest;
    // End of variables declaration//GEN-END:variables
}

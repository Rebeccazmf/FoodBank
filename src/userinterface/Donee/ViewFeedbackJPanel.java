/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Donee;

import business.User.*;
import business.UserAccount.*;
import business.WorkQueue.ApplyVolunteerRequest;
import business.WorkQueue.GetHelpRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author asahoho
 */
public class ViewFeedbackJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private CustomerAccount customerAccount;
    /**
     * Creates new form ViewFeedbackJPanel
     */
    ViewFeedbackJPanel(JPanel userProcessContainer, CustomerAccount customerAccount, int id) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.customerAccount = customerAccount;
        txtID.setText(String.valueOf(id));
        txtAreaFeedBack.setText(getFeedback(id));       
    }
    
    public String getFeedback(int id){
        String feedback = null;
        for(WorkRequest wr : customerAccount.getWorkQueue().getWorkRequestList()){
            if (wr.getID() == id)
                feedback = ((GetHelpRequest)wr).getFeedback();
        }
        return feedback;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaFeedBack = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 107, -1));

        jLabel1.setText("ID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        txtAreaFeedBack.setColumns(20);
        txtAreaFeedBack.setRows(5);
        jScrollPane1.setViewportView(txtAreaFeedBack);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 400, 253));

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        jLabel2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel2.setText("Your Feedback");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaFeedBack;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}

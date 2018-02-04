/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VolunteerServiceRole;

import business.EcoSystem;
import business.Enterprise.*;
import business.Organization.VolunteerServiceOrganization;
import business.User.*;
import business.UserAccount.*;
import business.VolunteerJob.VolunteerJob;
import business.WorkQueue.ApplyVolunteerRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Customer.CustomerProfileJPanel;

/**
 *
 * @author 梦菲
 */
public class AcceptVolunteerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AcceptVolunteerJPanel
     */
    private JPanel userProcessContainer;
    private EmployeeAccount employeeAccount;
    private FoodBankEnterprise enterprise;

    AcceptVolunteerJPanel(JPanel userProcessContainer, FoodBankEnterprise enterprise, EmployeeAccount employeeAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.employeeAccount = employeeAccount;
        this.enterprise = enterprise;
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblAcceptVolunteer.getModel();

        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request instanceof ApplyVolunteerRequest) {
                ApplyVolunteerRequest req = (ApplyVolunteerRequest) request;
                Object[] row = new Object[4];
                row[0] = req.getSender().getCustomer();
                row[1] = req.getJob();
                row[2] = req;

                model.addRow(row);
            }
        }
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
        tblAcceptVolunteer = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnViewVolunteerInfo = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAcceptVolunteer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Volunteer", "Job Applied", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAcceptVolunteer);
        if (tblAcceptVolunteer.getColumnModel().getColumnCount() > 0) {
            tblAcceptVolunteer.getColumnModel().getColumn(0).setResizable(false);
            tblAcceptVolunteer.getColumnModel().getColumn(1).setResizable(false);
            tblAcceptVolunteer.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 530, 210));

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, -1, -1));

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("Volunteer Service-Accept Volunteer");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        btnViewVolunteerInfo.setText("View Volunteer Info");
        btnViewVolunteerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVolunteerInfoActionPerformed(evt);
            }
        });
        add(btnViewVolunteerInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewVolunteerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVolunteerInfoActionPerformed
        int row = tblAcceptVolunteer.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ApplyVolunteerRequest request = (ApplyVolunteerRequest) tblAcceptVolunteer.getValueAt(row, 2);
        CustomerProfileJPanel customerProfileJPanel = new CustomerProfileJPanel(userProcessContainer, request.getSender());
        userProcessContainer.add("customerProfileJPanel", customerProfileJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewVolunteerInfoActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        int row = tblAcceptVolunteer.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ApplyVolunteerRequest request = (ApplyVolunteerRequest) tblAcceptVolunteer.getValueAt(row, 2);
        request.setStatus("Accept");
        enterprise.getWorkQueue().getWorkRequestList().remove(request);
        employeeAccount.incrementReuqestHandled();
        populateRequestTable();
        JOptionPane.showMessageDialog(null,"Accept volunteer successfully!");
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewVolunteerInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAcceptVolunteer;
    // End of variables declaration//GEN-END:variables
}
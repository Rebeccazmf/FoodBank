/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ManageFoodRole;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Enterprise.FoodBankEnterprise;
import business.Enterprise.FoodSupplierEnterprise;
import business.Food.*;
import business.Network.Network;
import business.Organization.ManageFoodOrganization;
import business.UserAccount.EmployeeAccount;
import java.awt.CardLayout;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 梦菲
 */
public class FoodBankManageFoodJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EmployeeAccount employeeAccount;
    private ManageFoodOrganization organization;
    private FoodBankEnterprise enterprise;
    private EcoSystem system;

    /**
     * /**
     * Creates new form FoodListJPanel
     */
    public FoodBankManageFoodJPanel(JPanel userProcessContainer, EmployeeAccount employeeAccount,
            ManageFoodOrganization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.employeeAccount = employeeAccount;
        this.organization = organization;
        this.enterprise = (FoodBankEnterprise) enterprise;
        this.system = system;
        populateTable((FoodBankEnterprise) enterprise);
        this.userProcessContainer.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {

            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                populateTable((FoodBankEnterprise) enterprise);
            }
        });
    }

    private void populateTable(FoodBankEnterprise enterprise) {
        DefaultTableModel model = (DefaultTableModel) tblFoodInfo.getModel();

        model.setRowCount(0);

        for (Food f : enterprise.getFoods().getFoodList()) {
            Object[] row = new Object[3];
            row[0] = f.getFoodType();
            row[1] = f;
            row[2] = f.getQuantity();

            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoodInfo = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        btnAddFood = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("Manage Food Storage (Food Bank)");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        tblFoodInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Type", "Food Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFoodInfo);
        if (tblFoodInfo.getColumnModel().getColumnCount() > 0) {
            tblFoodInfo.getColumnModel().getColumn(0).setResizable(false);
            tblFoodInfo.getColumnModel().getColumn(1).setResizable(false);
            tblFoodInfo.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 613, 280));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        btnAddFood.setText("Add Food");
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });
        add(btnAddFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int row = tblFoodInfo.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        Food food = (Food) tblFoodInfo.getValueAt(row, 1);

        ViewFoodJPanel viewFoodJPanel = new ViewFoodJPanel(userProcessContainer, employeeAccount, organization, enterprise, system, food);
        userProcessContainer.add("viewFoodJPanel", viewFoodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        ViewFoodJPanel viewFoodJPanel = new ViewFoodJPanel(userProcessContainer, employeeAccount, organization, enterprise, system, null);
        userProcessContainer.add("viewFoodJPanel", viewFoodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblFoodInfo.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Food food = (Food) tblFoodInfo.getValueAt(row, 1);
            enterprise.getFoods().getFoodList().remove(food);
            populateTable(enterprise);
            JOptionPane.showMessageDialog(this, "The food has been deleted.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFoodInfo;
    // End of variables declaration//GEN-END:variables
}

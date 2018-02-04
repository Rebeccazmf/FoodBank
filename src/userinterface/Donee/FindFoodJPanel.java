/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Donee;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Enterprise.FoodBankEnterprise;
import business.Food.Food;
import business.Food.Food.FoodType;
import business.Network.Network;
import business.UserAccount.CustomerAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Enterprise.FoodBankInfoJPanel;

/**
 *
 * @author gundamwings
 */
public class FindFoodJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private CustomerAccount customerAccount;

    /**
     * Creates new form FindFoodJPanel
     */
    public FindFoodJPanel(JPanel userProcessContainer, CustomerAccount customerAccount) {
        initComponents();
        system = EcoSystem.getInstance();
        this.customerAccount = customerAccount;
        this.userProcessContainer = userProcessContainer;
        foodTypeJComboBox.removeAllItems();
        for (FoodType ft : Food.getFoodTypes()) {
            foodTypeJComboBox.addItem(ft);
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

        btnViewDetail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        foodTypeJComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoodBankInfo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewDetail.setText("View detail>>");
        btnViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailActionPerformed(evt);
            }
        });
        add(btnViewDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, -1, -1));

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("Find Food");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        foodTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodTypeJComboBoxActionPerformed(evt);
            }
        });
        add(foodTypeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 90, -1));

        jLabel4.setText("Food Type:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        tblFoodBankInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Bank Name", "Address"
            }
        ));
        jScrollPane1.setViewportView(tblFoodBankInfo);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 613, 220));

        jLabel5.setText("Food Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        txtFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoodNameActionPerformed(evt);
            }
        });
        add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 120, -1));

        jLabel2.setText("List of food banks");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 180, -1));

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailActionPerformed
        int row = tblFoodBankInfo.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pelease select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        FoodBankEnterprise fb = (FoodBankEnterprise) tblFoodBankInfo.getValueAt(row, 0);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("foodBankInfoJPanel", new FoodBankInfoJPanel(userProcessContainer, fb, customerAccount));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewDetailActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void foodTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodTypeJComboBoxActionPerformed
        populateTable();
    }//GEN-LAST:event_foodTypeJComboBoxActionPerformed

    private void txtFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoodNameActionPerformed
        populateTable();
    }//GEN-LAST:event_txtFoodNameActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        populateTable();    
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnViewDetail;
    private javax.swing.JComboBox<FoodType> foodTypeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFoodBankInfo;
    private javax.swing.JTextField txtFoodName;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblFoodBankInfo.getModel();

        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof FoodBankEnterprise) {
                    if (e.getFoods().hasFood(txtFoodName.getText(), (FoodType) foodTypeJComboBox.getSelectedItem())) {
                        Object[] row = new Object[2];
                        row[0] = e;
                        row[1] = ((FoodBankEnterprise) e).getAddress();
                        model.addRow(row);
                    }
                }

            }
        }
    }
}

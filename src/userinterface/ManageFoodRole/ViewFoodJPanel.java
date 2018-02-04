/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ManageFoodRole;

import business.EcoSystem;
import business.Enterprise.*;
import business.Organization.ManageFoodOrganization;
import business.UserAccount.EmployeeAccount;
import business.Food.*;
import business.Food.Food.FoodType;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 梦菲
 */
public class ViewFoodJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EmployeeAccount employeeAccount;
    private ManageFoodOrganization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Food food;
    private boolean isUpdating;

    /**
     * Creates new form AddFoodJPanel
     */
    public ViewFoodJPanel(JPanel userProcessContainer, EmployeeAccount employeeAccount,
            ManageFoodOrganization organization, Enterprise enterprise, EcoSystem system, Food food) {
        initComponents();
        jcbFoodType.removeAllItems();
        for (FoodType ft : Food.getFoodTypes()) {
            jcbFoodType.addItem(ft);
        }
        this.userProcessContainer = userProcessContainer;
        this.employeeAccount = employeeAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.food = food;
        isUpdating = false;
        if (food != null) {
            defaultView();
            btnAdd.setVisible(false);
        } else {
            this.food = new Food();
            updateView();
            btnUpdate.setVisible(false);
        }
        displayFoodInfo();
    }

    private void defaultView() {
        jcbFoodType.setEnabled(false);
        txtFoodName.setEnabled(false);
        txtQuantity.setEnabled(false);
    }

    private void updateView() {
        jcbFoodType.setEnabled(true);
        txtFoodName.setEnabled(true);
        txtQuantity.setEnabled(true);
    }

    private void displayFoodInfo() {
        lblFoodID.setText(String.valueOf(food.getId()));
        jcbFoodType.setSelectedItem(food.getFoodType());
        txtFoodName.setText(food.getFoodName());
        txtQuantity.setText(String.valueOf(food.getQuantity()));
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
        jLabel2 = new javax.swing.JLabel();
        jcbFoodType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblFoodID = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("Modify food info");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setText("Food Type:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        add(jcbFoodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 171, -1));

        jLabel4.setText("Food Name:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 171, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        jLabel5.setText("Quantity:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 171, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jLabel6.setText("Food ID:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        lblFoodID.setText("<Show food id here>");
        add(lblFoodID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!fillFoodInfo()) {
            return;
        }
        enterprise.getFoods().addFood(food);
        food = new Food();
        displayFoodInfo();
        JOptionPane.showMessageDialog(null, "Add food successfully!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isUpdating) {
            if (!fillFoodInfo()) {
                return;
            }
            txtQuantity.setEnabled(false);
            btnUpdate.setText("Update");
            isUpdating = false;
            JOptionPane.showMessageDialog(null, "Update food successfully!");
        } else {
            txtQuantity.setEnabled(true);
            btnUpdate.setText("Save");
            isUpdating = true;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private boolean fillFoodInfo() {
        FoodType foodType = (FoodType) jcbFoodType.getSelectedItem();
        String foodName = txtFoodName.getText();
        int quantity;
        if (!isValidName(foodName)) {
            JOptionPane.showMessageDialog(null, "Error: you have to fill in valid name!");
            return false;
        }
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill in valid quantity");
            return false;
        }
        if (quantity < 0) {
            JOptionPane.showMessageDialog(null, "Please fill in valid quantity");
            return false;
        }
        food.setFoodType(foodType);
        food.setFoodName(foodName);
        food.setQuantity(quantity);
        return true;
    }

    public static boolean isValidName(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[a-zA-Z]+");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<FoodType> jcbFoodType;
    private javax.swing.JLabel lblFoodID;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}

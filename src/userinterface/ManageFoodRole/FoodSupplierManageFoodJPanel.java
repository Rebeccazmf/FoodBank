/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ManageFoodRole;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Enterprise.FoodSupplierEnterprise;
import business.Food.Food;
import business.Food.Food.FoodType;
import business.Organization.ManageFoodOrganization;
import business.UserAccount.EmployeeAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 梦菲
 */
public class FoodSupplierManageFoodJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EmployeeAccount employeeAccount;
    private ManageFoodOrganization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    private List<Food> foodsInCart;

    /**
     * Creates new form FoodSupplierManageFoodJPanel
     */
    public FoodSupplierManageFoodJPanel(JPanel userProcessContainer, EmployeeAccount employeeAccount,
            ManageFoodOrganization organization, Enterprise enterprise, EcoSystem system) {

        this.userProcessContainer = userProcessContainer;
        this.employeeAccount = employeeAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.foodsInCart = new ArrayList<>();
        this.userProcessContainer.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {

            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                populateTable((FoodSupplierEnterprise) enterprise);
            }
        });
        initComponents();
        foodTypeJComboBox.removeAllItems();
        for (FoodType ft : Food.getFoodTypes()) {
            foodTypeJComboBox.addItem(ft);
        }
        populateTable((FoodSupplierEnterprise) enterprise);

    }

    private void populateTable(FoodSupplierEnterprise enterprise) {
        DefaultTableModel model = (DefaultTableModel) tblFoodInfo.getModel();

        model.setRowCount(0);

        for (Food f : enterprise.getFoods().getFoodList()) {
            if ((FoodType) foodTypeJComboBox.getSelectedItem() == f.getFoodType()) {
                Object[] row = new Object[3];
                row[0] = f.getFoodType();
                row[1] = f;
                row[2] = f.getQuantity();

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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoodInfo = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnCreateFood = new javax.swing.JButton();
        foodTypeJComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setText("Manage Food Storage - Food Supplier");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        tblFoodInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Type", "Food Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 613, 240));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, -1, -1));

        btnCreateFood.setText("Create Food");
        btnCreateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFoodActionPerformed(evt);
            }
        });
        add(btnCreateFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        foodTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodTypeJComboBoxActionPerformed(evt);
            }
        });
        add(foodTypeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 130, -1));

        jLabel4.setText("Food Type:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        btnBack.setText("<<Bank");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFoodActionPerformed
        //Food food = new Food();
        ViewFoodJPanel viewFoodJPanel = new ViewFoodJPanel(userProcessContainer, employeeAccount, organization, enterprise, system, null);
        userProcessContainer.add("viewFoodJPanel", viewFoodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateFoodActionPerformed

    private void foodTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodTypeJComboBoxActionPerformed
        populateTable((FoodSupplierEnterprise) enterprise);
    }//GEN-LAST:event_foodTypeJComboBoxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

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
            populateTable((FoodSupplierEnterprise) enterprise);
            JOptionPane.showMessageDialog(this, "The food has been deleted.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateFood;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<FoodType> foodTypeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tblFoodInfo;
    // End of variables declaration//GEN-END:variables
}

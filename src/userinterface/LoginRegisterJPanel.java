/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.Organization;
import business.UserAccount.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;
import userinterface.Customer.CustomerRegisterJPanel;
import userinterface.Customer.CustomerWorkAreaJPanel;

/**
 *
 * @author 梦菲
 *
 */
public class LoginRegisterJPanel extends javax.swing.JPanel {
    // JPanel userProcessContainer;

    EcoSystem system;
    boolean isCustomer;
    JPanel containerPanel;

    /**
     * Creates new form CustomerLoginRegisterJPanel
     */
    public LoginRegisterJPanel(EcoSystem system, JPanel containerPanel, boolean isCustomer) {
        initComponents();
        this.system = system;
        this.isCustomer = isCustomer;
        jLabel3.setVisible(isCustomer);
        btnRegister.setVisible(isCustomer);
        jLabel4.setText(isCustomer ? "Customer Login/Register" : "Employee Login");
        this.containerPanel = containerPanel;
        btnLogout.setEnabled(false);
    }
     public static boolean isValidUserName(String str){
        if(str == null){
            return false;
        }
        return str.matches("\\w+");
    }
    public static boolean isValidPassword(String str){
        if(str == null){
            return false;
        }
        return str.matches("\\w+");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnHomepage = new javax.swing.JButton();
        userProcessContainer = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(300);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("User Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 69, -1, -1));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 66, 135, -1));

        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 122, -1, -1));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 170, -1, -1));

        jLabel3.setText("Do not have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel4.setText("<Role title Login>");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 119, 135, -1));

        btnHomepage.setText("Back to Homepage");
        btnHomepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomepageActionPerformed(evt);
            }
        });
        jPanel1.add(btnHomepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jSplitPane1.setLeftComponent(jPanel1);

        userProcessContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        CustomerRegisterJPanel customerRegisterJPanel = new CustomerRegisterJPanel(userProcessContainer, system);
        userProcessContainer.add("customerRegisterJPanel", customerRegisterJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String userName = txtUserName.getText();
        // Get Password
        char[] passwordCharArray = txtPassword.getPassword();

        String password = String.valueOf(passwordCharArray);
        if (!isValidUserName(userName)) {
            JOptionPane.showMessageDialog(null,"Error: you have to fill in valid User Name!");
            return;
        }
        if (!isValidPassword(password)){
            JOptionPane.showMessageDialog(null,"Error: you have to fill in valid Password!");
            return;
        }
        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        if (userAccount == null) {
            //Step2: Go inside each network to check each enterprise
            for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {
                        //Step3: Check against each organization inside that enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                break;
                            }
                        }
                    } else {
                        inEnterprise = enterprise;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }
        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        }

        if (userAccount instanceof EmployeeAccount && !isCustomer) {
            EmployeeAccount acc = (EmployeeAccount) userAccount;
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(acc.getRole().toString() + "workArea", acc.getRole().createWorkArea(userProcessContainer, userAccount, inOrganization, inEnterprise, system));
            layout.next(userProcessContainer);
        } else if (userAccount instanceof EmployeeAccount && isCustomer) {
            JOptionPane.showMessageDialog(null, "Error.Invalid Credentails!");
            return;
        } else if (userAccount instanceof CustomerAccount && !isCustomer) {
            JOptionPane.showMessageDialog(null, "Error.Invalid Credentails!");
            return;
        } else if (userAccount instanceof CustomerAccount && isCustomer) {
            CustomerAccount acc = (CustomerAccount) userAccount;
            CustomerWorkAreaJPanel customerWorkAreaJPanel = new CustomerWorkAreaJPanel(system, acc, userProcessContainer);
            userProcessContainer.add("customerWorkAreaJPanel", customerWorkAreaJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        }

        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        btnLogout.setEnabled(false);
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        btnLogin.setEnabled(true);

        txtUserName.setText("");
        txtPassword.setText("");

        userProcessContainer.removeAll();
        JPanel blankJP = new JPanel();
        userProcessContainer.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnHomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomepageActionPerformed
        userProcessContainer.removeAll();
        containerPanel.remove(this);
        CardLayout layout = (CardLayout) containerPanel.getLayout();
        layout.previous(containerPanel);
    }//GEN-LAST:event_btnHomepageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHomepage;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}

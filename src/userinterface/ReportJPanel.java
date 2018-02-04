/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import org.jfree.chart.*;
import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Enterprise.FoodBankEnterprise;
import business.Enterprise.FoodSupplierEnterprise;
import business.Food.Food;
import business.Network.Network;
import business.Organization.Organization;
import business.Organization.VolunteerServiceOrganization;
import business.UserAccount.EmployeeAccount;
import business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author gundamwings
 */
public class ReportJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private Network network;
    private Enterprise enterprise;
    private VolunteerServiceOrganization organization;
    private JPanel containerPanel;

    ReportJPanel(EcoSystem system, JPanel containerPanel) {
        initComponents();
        this.system = system;
        network = system.getNetworkList().get(0);
        enterprise = network.getEnterpriseDirectory().getEnterpriseList().get(0);
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof VolunteerServiceOrganization) {
                        organization = (VolunteerServiceOrganization) o;
                    }
                }
            }
        }
        this.containerPanel = containerPanel;
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("System Report");
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        JButton btnBack = new JButton();
        btnBack.setText("Back to Homepage");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnPerformed();
            }
        });
        mainPanel.add(btnBack);
        mainPanel.add(title);
        mainPanel.add(new JLabel("(Ecosystem level) How does the proportion look like regarding food bank distribution?"));
        mainPanel.add(createSystemLevelPanel());
        mainPanel.add(new JLabel("(Network level) How is " + network.getName() + "'s enterprises divided by type?"));
        mainPanel.add(createNetworkLevelPanel());
        mainPanel.add(new JLabel("(Enterprise level) For " + enterprise + ", what food does it offer?"));
        mainPanel.add(createEnterpriseLevelPanel());
        if (organization != null) {
            mainPanel.add(new JLabel("(Organization level) In " + organization + ", who handled the most amount of volunteer application requests?"));
            mainPanel.add(createOrganizationLevelPanel());
        }
    }

    private void backBtnPerformed() {
        containerPanel.remove(this);
        CardLayout layout = (CardLayout) containerPanel.getLayout();
        layout.previous(containerPanel);
    }

    private JPanel createSystemLevelPanel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Network n : system.getNetworkList()) {
            int count = 0;
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof FoodBankEnterprise) {
                    count++;
                }
            }
            dataset.setValue(n.getName(), new Integer(count));
        }
        JFreeChart chart = ChartFactory.createPieChart(
                "Food Bank Distribution", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);
        ChartPanel p = new ChartPanel(chart);
        p.setMaximumSize(new Dimension(1000, 1000));
        return p;
    }

    private JPanel createNetworkLevelPanel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int fbcount = 0;
        int fscount = 0;
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof FoodBankEnterprise) {
                fbcount++;
            } else if (e instanceof FoodSupplierEnterprise) {
                fscount++;
            }
        }
        dataset.setValue("Food Bank Enterprise", new Integer(fbcount));
        dataset.setValue("Food Supplier Enterprise", new Integer(fscount));
        JFreeChart chart = ChartFactory.createPieChart(
                "Enterprise Type Distribution", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);
        ChartPanel p = new ChartPanel(chart);
        p.setMaximumSize(new Dimension(1000, 1000));
        return p;
    }

    private JPanel createEnterpriseLevelPanel() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (Food f : enterprise.getFoods().getFoodList()) {
            data.addValue(f.getQuantity(), f.getFoodName(), f.getFoodType());
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Food",
                "Food",
                "Quantity",
                data,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel p = new ChartPanel(barChart);
        p.setMaximumSize(new Dimension(1000, 1000));
        return p;
    }

    private JPanel createOrganizationLevelPanel() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (EmployeeAccount ua : organization.getUserAccountDirectory().getEmployeeAccountList()) {
            data.addValue(ua.getReuqestHandled(), ua.getUsername(), "");
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Reuqest Handled",
                "",
                "number of requests",
                data,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel p = new ChartPanel(barChart);
        p.setMaximumSize(new Dimension(1000, 1000));
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(mainPanel);

        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class UserDirectory {
//      private ArrayList<Employee> employeeList;
//      private ArrayList<Customer> customerList;
      private ArrayList<User> userList;
    public UserDirectory() {
        userList = new ArrayList();
        
    }

    public ArrayList<User> getUserList() {
        return userList;
    }


    
    public Employee createEmployee(String firstName, String lastName){
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        userList.add(employee);
        return employee;
    }  
    
    public ArrayList<Employee> getEmployeeList() {
    ArrayList<Employee> list = new ArrayList<>();
    for (User u : userList)
        if (u instanceof Employee)
            list.add((Employee) u);
    return list;
}
    
    public Customer createCustomer(String firstName, String lastName){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        userList.add(customer);
        return customer;
    }  
    
    public ArrayList<Customer> getCustomerList() {
    ArrayList<Customer> list = new ArrayList<>();
    for (User u : userList)
        if (u instanceof Employee)
            list.add((Customer) u);
    return list;
}
        public void deleteUser(User u){
        userList.remove(u);
    }
}

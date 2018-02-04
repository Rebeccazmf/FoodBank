/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

/**
 *
 * @author 梦菲
 */
public abstract class User {
    private String firstName;
    private String lastName;
    
    //private String name;
//    private int id;
//    private static int count = 1;

    public User() {
//        id = count;
//        count++;
    }

//    public int getId() {
//        return id;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    
//    public String getName() {
//        return name;
//    }

    
     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }   

    
}

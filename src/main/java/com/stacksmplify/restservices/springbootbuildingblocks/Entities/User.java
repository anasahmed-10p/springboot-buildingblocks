package com.stacksmplify.restservices.springbootbuildingblocks.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="user")
public class User {

 @Id
 @GeneratedValue
 private long id;

 @NotEmpty(message="First name cannot be empty")
 @Size(min=2,message="First name length cannot be less then 1")
 private String firstName;
 private String lastName;

 @Column(length=50,unique=true,nullable=false)
 private String email;

 @Column(name ="User_Name",length=50,nullable=false,unique=true)
 private String userName;

 @Column(nullable = false,length=50)
 private String role;

@OneToMany(mappedBy="user")
 private List<Order> orders;

 public List<Order> getOrders() {
  return orders;
 }

 public void setOrders(List<Order> orders) {
  this.orders = orders;
 }

 public User() {
 }

 public User(long id, String firstName, String lastName, String email, String userName) {
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.userName = userName;
 }

 @Override
 public String toString() {
  return "User{" +
          "id=" + id +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", email='" + email + '\'' +
          ", userName='" + userName + '\'' +
          ", role='" + role + '\'' +
          '}';
 }

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

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

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getUserName() {
  return userName;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

 public String getRole() {
  return role;
 }

 public void setRole(String role) {
  this.role = role;
 }


}

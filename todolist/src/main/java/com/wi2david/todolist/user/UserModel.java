package com.wi2david.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String name;
  @Column(unique = true)
  private String username;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

  // UserModel(String name, String username, String password) {
  //   setName(name);
  //   setUsername(username);
  //   setPassword(password);
  // }
  // public String getName() {
  //   return this.name;
  // }
  // public void setName(String name) {
  //   this.name = name;
  // }
  // public String getUsername() {
  //   return this.username;
  // }
  // public void setUsername(String username) {
  //   this.username = username;
  // }
  // public String getPassword() {
  //   return this.password;
  // }
  // public void setPassword(String password) {
  //   this.password = password;
  // }
}

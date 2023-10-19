package com.wi2david.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private IUserRepository userRepository;

  /**
   * Tipos de dados em Java
   * String (texto)
   * Interger (int) números inteiros
   * Double (double) números decimais
   * Float (float) números decimais
   * char (caracteres)
   * Date (data)
   * void (vazio)
   */
  /**
   * Body
   */
  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if(user != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado.");
    }

    var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashred);
    
    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    // System.out.println(userModel.getName());
    // System.out.println(userModel.getUsername());
    // System.out.println(userModel.getPassword());
  }

  // @PostMapping("/post")
  // @ResponseBody
  // public UserModel post(@RequestBody UserModel userModel) {
  //   System.out.println(userModel.name);
  //   return new UserModel("David");
  // }
}

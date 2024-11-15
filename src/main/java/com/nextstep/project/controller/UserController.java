package com.nextstep.project.controller;

import com.nextstep.project.model.User;
import com.nextstep.project.response.ApiResponse;
import com.nextstep.project.service.EmailService;
import com.nextstep.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    all APIS is routes:
    @Autowired
    UserService userService;
@PostMapping("/saveAllUser")
    public ResponseEntity<ApiResponse>saveDetail(@RequestBody User user) {
    try {
        userService.saveUser(user);
        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    } catch (Exception ex) {
        System.out.println(ex);
        ApiResponse apiResponse = ApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

    }
}

@GetMapping("/getAllDetails")

    public ResponseEntity<ApiResponse>getDetails(){
      try{
          List<User>list=userService.getUser();
          ApiResponse apiResponse=ApiResponse.<User>builder().message("success").statusCode(HttpStatus.OK.value()).list(list).build();
          return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
      }

      catch(Exception ex){


          System.out.println(ex);
          ApiResponse apiResponse=ApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
      }

    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ApiResponse>deleteById(@PathVariable("id") int id){
    try{
       userService.deleteById(id);
       ApiResponse apiResponse=ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
       return  ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

    catch(Exception ex){
        System.out.println(ex);
        ApiResponse apiResponse=ApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }
    }

//    patch only edit existing
@PatchMapping("/edit")
    public ResponseEntity<ApiResponse>edituserDetails(@RequestBody User user){
    try{
        userService.updateUser(user);
        ApiResponse apiResponse=ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    catch(Exception ex){
        System.out.println(ex);
        ApiResponse apiResponse=ApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
}



//put replace whole resource with new ersource:
@PutMapping("/editput")
    public ResponseEntity<ApiResponse>editByPatch(@RequestBody User user){

    try{
userService.updateUser(user);
ApiResponse apiResponse=ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    catch (Exception ex){

        System.out.println(ex);

        ApiResponse apiResponse=ApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

    }
}
}

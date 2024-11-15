package com.nextstep.project.controller;

import com.nextstep.project.model.Email;
import com.nextstep.project.response.ApiResponse;
import com.nextstep.project.response.EmailApiResponse;
import com.nextstep.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//All @T hings are annotitaion

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    EmailService emailService;
@PostMapping("/send")
    public ResponseEntity<EmailApiResponse>sendEmail(@RequestBody Email email){
try{
    emailService.sendMessage(email);
    EmailApiResponse emailApiResponse=EmailApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
    return ResponseEntity.status(HttpStatus.OK).body(emailApiResponse);
}
catch(Exception ex){
    System.out.println(ex);

    EmailApiResponse emailApiResponse=EmailApiResponse.builder().message("internal server error").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailApiResponse);
}
    }

}

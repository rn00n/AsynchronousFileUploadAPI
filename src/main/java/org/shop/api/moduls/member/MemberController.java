package org.shop.api.moduls.member;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@RequestMapping("/users")
public class MemberController {

    @PostMapping(produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            List<ObjectError> globalErrors = result.getGlobalErrors();
            List<FieldError> fieldErrors = result.getFieldErrors();
            
            for (int i = 0; i < allErrors.size(); i++) {
                log.info("allError = " + allErrors.get(i));
            }

            for (int i = 0; i < globalErrors.size(); i++) {
                log.info("globalError = " + globalErrors.get(i));
            }

            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);
                log.info("fieldError = " + fieldError);
                
                log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
            }

            return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
        }
        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getUserName() = " + member.getUsername());
        log.info("member.getEmail() = " + member.getEmail());
        log.info("member.getGender() = " + member.getGender());
        log.info("member.getDateOfBirth() = " + member.getDateOfBirth());

        if (member.getAddress() != null) {
            log.info("member.getAddress().getPostCode() = " + member.getAddress().getPostCode());
            log.info("member.member.getAddress().getLocation() = " + member.getAddress().getLocation());
        }

        if (member.getCardList() != null) {
            for (int i = 0; i < member.getCardList().size(); i++) {
                log.info("member.getCardList().get(" + i + ").getNo() = " + member.getCardList().get(i).getNo());
                log.info("member.getCardList().get(" + i + ").getValidMonth() = " + member.getCardList().get(i).getValidMonth());
            }
        }

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}

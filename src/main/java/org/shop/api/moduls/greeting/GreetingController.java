package org.shop.api.moduls.greeting;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Log
@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/welcome", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> welcome() {

        String[] args = {"홍길동"};
        String message = messageSource.getMessage("welcome.message", args, Locale.KOREA);

        log.info("Welcome message: " + message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

package com.mib.shop;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MyExceptionHandler {


    //특정에러에만 실행하기
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handler1() {
        return ResponseEntity.status(400).body("특정 에러시 발동");
    }

    //모든 에러
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler() {
        return ResponseEntity.status(400).body("모든 컨트롤러 에러시 발동");
    }

}

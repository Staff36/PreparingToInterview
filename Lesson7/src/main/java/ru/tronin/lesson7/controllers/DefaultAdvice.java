package ru.tronin.lesson7.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tronin.lesson7.exceptions.NoEntityException;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(NoEntityException.class)
    public String handleNoEntityException(NoEntityException e){
        return "students/notFound";
    }
}

package org.ncmao.controller;


import org.ncmao.Exception.RestError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ErrorHandleController {


    @RequestMapping(value = "/404", method = GET)
    @ResponseBody
    public ResponseEntity<RestError> handleNotFoundError() {
        return new ResponseEntity<>(new RestError(NOT_FOUND, "not found"), NOT_FOUND);
    }


}

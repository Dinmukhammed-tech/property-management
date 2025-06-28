package io.proglib.mycompany.controller;

import io.proglib.mycompany.model.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(@RequestParam("a") Double a, @RequestParam("b") Double b){
        return a+b;
    }

    @GetMapping("/sub/{a}/{b}")
    public Double sub(@PathVariable Double a, @PathVariable Double b){
        Double res = null;
        if(a>b){
            res=a-b;
        }else if(a<b){
            res=b-a;
        }
        return res;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO dto){
        Double res = null;
        res = dto.getNum1()*dto.getNum2()*dto.getNum3()*dto.getNum4();
        ResponseEntity<Double> response = new ResponseEntity<>(res, HttpStatus.CREATED);
        return response;
    }
}

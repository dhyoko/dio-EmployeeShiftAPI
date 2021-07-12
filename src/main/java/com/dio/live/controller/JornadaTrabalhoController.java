package com.dio.live.controller;

import com.dio.live.exception.EmployeeShiftNotFoundException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{idJornada}")
    public JornadaTrabalho getJornadaByID(@PathVariable("idJornada") Long idJornada) throws EmployeeShiftNotFoundException {
        return jornadaService.getById(idJornada);

    }

    @PutMapping("/{idJornada}")
    public JornadaTrabalho updateJornada(@PathVariable("idJornada") Long idJornada, @RequestBody JornadaTrabalho jornadaTrabalho) throws EmployeeShiftNotFoundException {
        return jornadaService.updateJornada(idJornada, jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable("idJornada") Long idJornada) throws EmployeeShiftNotFoundException {
           jornadaService.deleteJornada(idJornada);

    }



}

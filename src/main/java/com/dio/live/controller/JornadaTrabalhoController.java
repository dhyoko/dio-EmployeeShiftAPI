package com.dio.live.controller;

import com.dio.live.dto.request.JornadaTrabalhoDTO;
import com.dio.live.dto.response.MessageResponseDTO;
import com.dio.live.exception.EmployeeShiftNotFoundException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/jornada")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JornadaTrabalhoController {

    private JornadaService jornadaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JornadaTrabalhoDTO createJornada(@RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO){
        return jornadaService.createJornada(jornadaTrabalhoDTO);
    }

    @GetMapping
    public List<JornadaTrabalhoDTO> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{id}")
    public JornadaTrabalhoDTO getJornadaByID(@PathVariable("id") Long id) throws EmployeeShiftNotFoundException {
        return jornadaService.getById(id);

    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateJornada(@PathVariable("id") Long id, @RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO) throws EmployeeShiftNotFoundException {
        return jornadaService.updateJornada(id, jornadaTrabalhoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable("id") Long id) throws EmployeeShiftNotFoundException {
           jornadaService.deleteJornada(id);

    }



}

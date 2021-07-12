package com.dio.live.service;

import com.dio.live.exception.EmployeeShiftNotFoundException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JornadaService {


    JornadaRepository jornadaRepository;

//    @Autowired
//    public JornadaService(JornadaRepository jornadaRepository) {
//        this.jornadaRepository = jornadaRepository;
//    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
       return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
       return   jornadaRepository.findAll();
    }

    public JornadaTrabalho getById(Long idJornada) throws EmployeeShiftNotFoundException {
        return verifyIfExists(idJornada);
    }

    public JornadaTrabalho updateJornada(Long idJornada, JornadaTrabalho jornadaTrabalho) throws EmployeeShiftNotFoundException {
        verifyIfExists(idJornada);
        return jornadaRepository.save(jornadaTrabalho);
    }

    public void deleteJornada(Long idJornada) throws EmployeeShiftNotFoundException {
        verifyIfExists(idJornada);
        jornadaRepository.deleteById(idJornada);
    }

    private JornadaTrabalho verifyIfExists(long id) throws EmployeeShiftNotFoundException {
        return jornadaRepository.findById(id).orElseThrow(() -> new EmployeeShiftNotFoundException(id));
    }
}

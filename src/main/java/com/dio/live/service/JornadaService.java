package com.dio.live.service;

import com.dio.live.dto.request.JornadaTrabalhoDTO;
import com.dio.live.dto.response.MessageResponseDTO;
import com.dio.live.exception.EmployeeShiftNotFoundException;
import com.dio.live.mapper.JornadaTrabalhoMapper;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JornadaService {

    private final JornadaRepository jornadaRepository;

    private final JornadaTrabalhoMapper jornadaTrabalhoMapper = JornadaTrabalhoMapper.INSTANCE;

    public JornadaTrabalhoDTO createJornada(JornadaTrabalhoDTO jornadaTrabalhoDTO){
        JornadaTrabalho jornadaTrabalhoToSave = jornadaTrabalhoMapper.toModel(jornadaTrabalhoDTO);
        JornadaTrabalho savedJornadaTrabalho = jornadaRepository.save(jornadaTrabalhoToSave);
        return jornadaTrabalhoMapper.toDTO(savedJornadaTrabalho);
    }

    public List<JornadaTrabalhoDTO> findAll() {
        List<JornadaTrabalho> employeeShiftToList = jornadaRepository.findAll();
        return employeeShiftToList.stream()
                .map(jornadaTrabalhoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JornadaTrabalhoDTO getById(Long id) throws EmployeeShiftNotFoundException {
        JornadaTrabalho jornadaTrabalho = verifyIfExists(id);
        return jornadaTrabalhoMapper.toDTO(jornadaTrabalho);
    }

    public MessageResponseDTO updateJornada(Long id, JornadaTrabalhoDTO jornadaTrabalhoDTO) throws EmployeeShiftNotFoundException {
        verifyIfExists(id);
        JornadaTrabalho jornadaTrabalhoToUpdate = jornadaTrabalhoMapper.toModel(jornadaTrabalhoDTO);
        jornadaRepository.save(jornadaTrabalhoToUpdate);
        return createMessageResponse(jornadaTrabalhoToUpdate.getId(), "Updated employee shift with id: ");
    }

    public void deleteJornada(Long id) throws EmployeeShiftNotFoundException {
        verifyIfExists(id);
        jornadaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(long id, String message){
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private JornadaTrabalho verifyIfExists(long id) throws EmployeeShiftNotFoundException {
        return jornadaRepository.findById(id).orElseThrow(() -> new EmployeeShiftNotFoundException(id));
    }

}

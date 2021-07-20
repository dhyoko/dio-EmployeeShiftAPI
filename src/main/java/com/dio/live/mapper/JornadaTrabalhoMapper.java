package com.dio.live.mapper;

import com.dio.live.dto.request.JornadaTrabalhoDTO;
import com.dio.live.model.JornadaTrabalho;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JornadaTrabalhoMapper {

    JornadaTrabalhoMapper INSTANCE = Mappers.getMapper(JornadaTrabalhoMapper.class);

    JornadaTrabalho toModel(JornadaTrabalhoDTO jornadaTrabalhoDTO);

    JornadaTrabalhoDTO toDTO(JornadaTrabalho jornadaTrabalho);
}

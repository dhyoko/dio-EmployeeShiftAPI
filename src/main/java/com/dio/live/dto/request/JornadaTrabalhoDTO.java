package com.dio.live.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JornadaTrabalhoDTO {

    private long id;

    @NotEmpty
    @Size(min=10, max=255)
    private String descricao;
}

package com.reto.seek.demo.infraestructure.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Error response model")
public class ErrorReponse {

    @Schema(description = "Error message", example = "Invalid request")
    private String message;
}

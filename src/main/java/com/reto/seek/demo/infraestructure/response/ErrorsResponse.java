package com.reto.seek.demo.infraestructure.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Errors response model")
public class ErrorsResponse  {

    @Schema(description = "List of error messages", example = "[\"Error 1\", \"Error 2\"]")
    private List<String> errors;
}
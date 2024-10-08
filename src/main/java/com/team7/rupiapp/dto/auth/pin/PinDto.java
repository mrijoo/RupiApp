package com.team7.rupiapp.dto.auth.pin;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PinDto {
    @NotBlank(message = "PIN is required")
    private String pin;
}

package com.team7.rupiapp.dto.transfer.qris;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class QrisCPMResponseDto {
    private String qris;

    private LocalDateTime expiredAt;
}

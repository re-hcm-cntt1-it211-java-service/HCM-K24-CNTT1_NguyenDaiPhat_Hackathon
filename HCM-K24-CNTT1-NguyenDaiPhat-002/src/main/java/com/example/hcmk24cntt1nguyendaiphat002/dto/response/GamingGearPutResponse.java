package com.example.hcmk24cntt1nguyendaiphat002.dto.response;

import com.example.hcmk24cntt1nguyendaiphat002.enums.GamingGearType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamingGearPutResponse {
    private Long ib;

    private String product_name;

    private String serial_code;

    private BigDecimal price;

    private GamingGearType type;
    
    private boolean is_deleted;
}

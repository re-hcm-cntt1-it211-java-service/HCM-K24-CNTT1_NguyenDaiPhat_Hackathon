package com.example.hcmk24cntt1nguyendaiphat002.dto.request;

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
public class GamingGearPutResquest {

    @NotBlank(message = "Không để trống tên sản phẩm")
    private String product_name;

    @NotBlank(message = "Không để trống serial_code")
    private String serial_code;

    @Min(value = 0, message = "price không để âm")
    private BigDecimal price;

    @NotBlank(message = "Không để trống type")
    private GamingGearType type;

    private boolean is_deleted;
}

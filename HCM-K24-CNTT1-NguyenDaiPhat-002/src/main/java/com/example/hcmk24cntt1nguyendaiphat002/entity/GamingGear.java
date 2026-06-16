package com.example.hcmk24cntt1nguyendaiphat002.entity;

import com.example.hcmk24cntt1nguyendaiphat002.enums.GamingGearType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gamingGears")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamingGear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ib;

    private String product_name;

    private String serial_code;

    private BigDecimal price;

    private GamingGearType type;

    private boolean is_deleted;
}

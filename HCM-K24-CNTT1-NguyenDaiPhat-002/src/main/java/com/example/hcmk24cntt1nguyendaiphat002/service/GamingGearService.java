package com.example.hcmk24cntt1nguyendaiphat002.service;

import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearCreateResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearPatchResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearPutResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearCreateResponse;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearPatchResponse;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearPutResponse;
import com.example.hcmk24cntt1nguyendaiphat002.entity.GamingGear;
import com.example.hcmk24cntt1nguyendaiphat002.exception.GamingGearWithByIdException;
import com.example.hcmk24cntt1nguyendaiphat002.repository.GamingGearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamingGearService {
    private final GamingGearRepository gamingGearRepository;

    public List<GamingGear> getAllGamingGear() {
        return gamingGearRepository.findAll();
    }

    public GamingGearCreateResponse createGamingGear(GamingGearCreateResquest resquest) {
        GamingGear gear = GamingGear.builder()
                .product_name(resquest.getProduct_name())
                .serial_code(resquest.getSerial_code())
                .price(resquest.getPrice())
                .type(resquest.getType())
                .is_deleted(resquest.is_deleted())
                .build();

        GamingGear gearSave = gamingGearRepository.save(gear);

        GamingGearCreateResponse response = GamingGearCreateResponse.builder()
                .ib(gearSave.getIb())
                .product_name(gearSave.getProduct_name())
                .serial_code(gearSave.getSerial_code())
                .price(gearSave.getPrice())
                .type(gearSave.getType())
                .is_deleted(gearSave.is_deleted())
                .build();

        return response;
    }

    public GamingGearPutResponse updateFullGamingGear(Long id, GamingGearPutResquest resquest) {
        GamingGear gear = gamingGearRepository.findById(id)
                .orElseThrow(() -> new GamingGearWithByIdException(id));

        gear.setProduct_name(resquest.getProduct_name());
        gear.setSerial_code(resquest.getSerial_code());
        gear.setPrice(resquest.getPrice());
        gear.setType(resquest.getType());
//        gear.ge;

        GamingGear gearSave = gamingGearRepository.save(gear);

        return GamingGearPutResponse.builder()
                .ib(gearSave.getIb())
                .product_name(gearSave.getProduct_name())
                .serial_code(gearSave.getSerial_code())
                .price(gearSave.getPrice())
                .type(gearSave.getType())
                .is_deleted(gearSave.is_deleted())
                .build();
    }

    public GamingGearPatchResponse updatePatchGamingGear(Long id, GamingGearPatchResquest resquest) {
        GamingGear gear = gamingGearRepository.findById(id)
                .orElseThrow(() -> new GamingGearWithByIdException(id));

        if (resquest.getProduct_name() != null) {
            gear.setProduct_name(resquest.getProduct_name());
        }

        if (resquest.getSerial_code() != null) {
            gear.setSerial_code(resquest.getSerial_code());
        }

        if (resquest.getPrice() != null) {
            gear.setPrice(resquest.getPrice());
        }

        if (resquest.getType() != null) {
            gear.setType(resquest.getType());
        }

        GamingGear gearSave = gamingGearRepository.save(gear);

        return GamingGearPatchResponse.builder()
                .ib(gearSave.getIb())
                .product_name(gearSave.getProduct_name())
                .serial_code(gearSave.getSerial_code())
                .price(gearSave.getPrice())
                .type(gearSave.getType())
                .is_deleted(gearSave.is_deleted())
                .build();
    }

    public void delete(Long id) {
        GamingGear gear = gamingGearRepository.findById(id)
                .orElseThrow(() -> new GamingGearWithByIdException(id));

        gamingGearRepository.deleteById(gear.getIb());
    }
}

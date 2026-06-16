package com.example.hcmk24cntt1nguyendaiphat002.exception;

public class GamingGearWithByIdException extends RuntimeException {
    public GamingGearWithByIdException(Long id) {
        super("Id " + id +" không tồn tại");
    }
}

package com.example.hcmk24cntt1nguyendaiphat002.controller;

import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearCreateResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearPatchResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.request.GamingGearPutResquest;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearCreateResponse;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearPatchResponse;
import com.example.hcmk24cntt1nguyendaiphat002.dto.response.GamingGearPutResponse;
import com.example.hcmk24cntt1nguyendaiphat002.entity.GamingGear;
import com.example.hcmk24cntt1nguyendaiphat002.service.GamingGearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gears")
@RequiredArgsConstructor
public class GamingGearController {
    private final GamingGearService gamingGearService;

    @GetMapping
    public ResponseEntity<List<GamingGear>> getAllGamingGear() {

        return ResponseEntity.ok()
                .body(gamingGearService.getAllGamingGear());
    }

    @PostMapping
    public ResponseEntity<GamingGearCreateResponse> createGamingGear(@RequestBody @Valid GamingGearCreateResquest resquest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gamingGearService.createGamingGear(resquest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamingGearPutResponse> updateFullGamingGear(
            @PathVariable Long id,
            @RequestBody @Valid GamingGearPutResquest resquest) {

        return ResponseEntity.ok()
                .body(gamingGearService.updateFullGamingGear(id, resquest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GamingGearPatchResponse> updatePatchGamingGear(
            @PathVariable Long id,
            @RequestBody @Valid GamingGearPatchResquest resquest) {


        return ResponseEntity.ok()
                .body(gamingGearService.updatePatchGamingGear(id, resquest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gamingGearService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

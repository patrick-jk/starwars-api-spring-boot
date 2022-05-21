package me.dio.gof.controller;

import lombok.RequiredArgsConstructor;
import me.dio.gof.model.Fan;
import me.dio.gof.service.FanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fans")
@RequiredArgsConstructor
public class FanRestController {
    private final FanService fanService;

    @GetMapping
    public ResponseEntity<Iterable<Fan>> findAllFans() {
        return ResponseEntity.ok(fanService.findAllFans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fan> findById(@PathVariable Long id) {
        return ResponseEntity.ok(fanService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Fan> insertFan(@RequestBody Fan fan) {
        fanService.insertFan(fan);
        return ResponseEntity.ok(fan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fan> updateFan(@PathVariable Long id, @RequestBody Fan fan) {
        fanService.updateFan(id, fan);
        return ResponseEntity.ok(fan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        fanService.deleteFan(id);
        return ResponseEntity.ok().build();
    }
}

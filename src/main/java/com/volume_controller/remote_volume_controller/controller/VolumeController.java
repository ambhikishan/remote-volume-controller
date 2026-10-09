package com.volume_controller.remote_volume_controller.controller;

import com.volume_controller.remote_volume_controller.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolumeController {


    @GetMapping("/up")
    public ResponseEntity<?> volumeUp()
    {
    VolumeService.volumeUp();
    return ResponseEntity.ok().build();
    }


    @GetMapping("down")
    public ResponseEntity<?> volumeDown()
    {
        VolumeService.volumeDown();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mute")
    public ResponseEntity<?> volumeMute()
    {
        VolumeService.mute();
        return ResponseEntity.ok().build();
    }
}

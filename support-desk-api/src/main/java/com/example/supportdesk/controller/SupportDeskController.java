package com.example.supportdesk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SupportDeskController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> getHealth() {
        Map<String, String> response = Map.of(
                "status", "UP",
                "service", "support-desk-api"
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/about")
    public ResponseEntity<Map<String, String>> getAbout() {
        Map<String, String> response = Map.of(
                "appName", "Support Desk API",
                "version", "1.0.0",
                "description", "API for managing IT support tickets"
        );
        return ResponseEntity.ok(response);
    }
}

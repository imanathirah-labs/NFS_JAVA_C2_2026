package com.example.supportdesk.controller;

import com.example.supportdesk.dto.TicketResponse;
import com.example.supportdesk.dto.CreateTicketRequest;
import com.example.supportdesk.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<TicketResponse> getTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    public TicketResponse getTicketById(@PathVariable("id") String id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/tickets")
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        TicketResponse created = ticketService.createTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

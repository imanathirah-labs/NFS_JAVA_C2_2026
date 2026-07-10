package com.example.supportdesk.controller;

import com.example.supportdesk.dto.TicketResponse;
import com.example.supportdesk.exception.GlobalExceptionHandler;
import com.example.supportdesk.exception.ResourceNotFoundException;
import com.example.supportdesk.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
@Import(GlobalExceptionHandler.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    private static final String JSON_TEMPLATE = "{\"title\": \"%s\", \"description\": \"%s\", \"category\": \"%s\", \"priority\": \"%s\", \"createdBy\": \"%s\"}";

    @Test
    void shouldReturnTicketList() throws Exception {
        TicketResponse ticket = new TicketResponse(
                "T001",
                "Cannot access email",
                "User cannot login to company email account.",
                "Email",
                "HIGH",
                "OPEN",
                "amir@example.com",
                "2026-07-03"
        );

        when(ticketService.getAllTickets()).thenReturn(List.of(ticket));

        mockMvc.perform(get("/api/tickets"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$[0].id").value("T001"))
                .andExpect(jsonPath("$[0].title").value("Cannot access email"));
    }

    @Test
    void shouldReturnTicketById() throws Exception {
        TicketResponse ticket = new TicketResponse(
                "T001",
                "Cannot access email",
                "User cannot login to company email account.",
                "Email",
                "HIGH",
                "OPEN",
                "amir@example.com",
                "2026-07-03"
        );

        when(ticketService.getTicketById("T001")).thenReturn(ticket);

        mockMvc.perform(get("/api/tickets/T001"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id").value("T001"))
                .andExpect(jsonPath("$.title").value("Cannot access email"));
    }

    @Test
    void shouldCreateTicket() throws Exception {
        TicketResponse created = new TicketResponse(
                "T004",
                "VPN connection not working",
                "User cannot connect to company VPN from home.",
                "Network",
                "MEDIUM",
                "OPEN",
                "siti@example.com",
                "2026-07-10"
        );

        when(ticketService.createTicket(org.mockito.ArgumentMatchers.any())).thenReturn(created);

        String requestBody = String.format(JSON_TEMPLATE,
                "VPN connection not working",
                "User cannot connect to company VPN from home.",
                "Network",
                "MEDIUM",
                "siti@example.com"
        );

        mockMvc.perform(post("/api/tickets")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id").value("T004"))
                .andExpect(jsonPath("$.status").value("OPEN"))
                .andExpect(jsonPath("$.createdBy").value("siti@example.com"));
    }

    @Test
    void shouldReturnBadRequestForInvalidTicket() throws Exception {
        String requestBody = String.format(JSON_TEMPLATE,
                "",
                "",
                "",
                "",
                ""
        );

        mockMvc.perform(post("/api/tickets")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validation failed"));
    }
}

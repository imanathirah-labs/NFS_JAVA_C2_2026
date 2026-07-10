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
    void shouldReturnNotFoundWhenTicketDoesNotExist() throws Exception {
        when(ticketService.getTicketById("T999"))
                .thenThrow(new ResourceNotFoundException("Ticket T999 was not found"));

        mockMvc.perform(get("/api/tickets/T999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Ticket T999 was not found"));
    }
}

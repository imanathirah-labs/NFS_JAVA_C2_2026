package com.example.supportdesk.controller;

import com.example.supportdesk.dto.TicketResponse;
import com.example.supportdesk.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
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
}

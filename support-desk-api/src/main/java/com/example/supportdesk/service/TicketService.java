package com.example.supportdesk.service;

import com.example.supportdesk.dto.TicketResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final List<TicketResponse> tickets = new ArrayList<>(List.of(
            new TicketResponse(
                    "T001",
                    "Cannot access email",
                    "User cannot login to company email account.",
                    "Email",
                    "HIGH",
                    "OPEN",
                    "amir@example.com",
                    "2026-07-03"
            ),
            new TicketResponse(
                    "T002",
                    "Laptop is slow",
                    "The laptop is running very slowly after the latest update.",
                    "Hardware",
                    "MEDIUM",
                    "IN_PROGRESS",
                    "sara@example.com",
                    "2026-07-04"
            ),
            new TicketResponse(
                    "T003",
                    "VPN connection not working",
                    "User cannot connect to the VPN from home.",
                    "Network",
                    "HIGH",
                    "OPEN",
                    "mike@example.com",
                    "2026-07-05"
            )
    ));

    public List<TicketResponse> getAllTickets() {
        return tickets;
    }
}

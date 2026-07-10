package com.example.supportdesk.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTicketRequest(
        @NotBlank(message = "title must not be blank") String title,
        @NotBlank(message = "description must not be blank") String description,
        @NotBlank(message = "category must not be blank") String category,
        @NotBlank(message = "priority must not be blank") String priority,
        @NotBlank(message = "createdBy must not be blank") String createdBy
) {
}

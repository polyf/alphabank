package com.alpha.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Embeddable
public class Contact {

    @Size(max = 15, message = "Phone number must be less than or equal to 15 characters")
    @Column(name = "contact_phone")
    private String phone;

    @Size(max = 15, message = "Whatsapp number must be less than or equal to 15 characters")
    @Column(name = "contact_whatsapp")
    private String whatsapp;

    @Email(message = "Invalid email format")
    @Column(name = "contact_email")
    private String email;
}
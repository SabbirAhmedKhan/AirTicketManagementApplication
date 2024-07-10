package com.example.Air_Ticket_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.sql.Date;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String route;
    private Double ticketPrice;
    private Date orderDate;

}

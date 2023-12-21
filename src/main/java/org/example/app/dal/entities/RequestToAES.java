package org.example.app.dal.entities;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public abstract class RequestToAES {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "request_date")
    private String date;
    @Column(name = "request_text")
    private String text;
    @JoinColumn(name = "citizen_id")
    private Citizen author;
}

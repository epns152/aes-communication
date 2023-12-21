package org.example.app.dal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "protocols")
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "protocol_text")
    private String protocolText;
    @Column(name = "protocol_status")
    private ProtocolStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Protocol protocol = (Protocol) o;
        return Objects.equals(id, protocol.id) && Objects.equals(protocolText, protocol.protocolText) && status == protocol.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, protocolText, status);
    }
}

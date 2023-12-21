package org.example.app.dal.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "appointment_duration")
    private int appointmentDuration;
    @Column(name = "appointment_status")
    private AppointmentStatus status;
    @OneToMany(mappedBy = "appointment")
    private List<User> participants;
    @OneToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;
    @Column(name = "cancellation_message")
    private String cancellationMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentDuration == that.appointmentDuration && Objects.equals(id, that.id) && Objects.equals(appointmentDate, that.appointmentDate) && status == that.status && Objects.equals(participants, that.participants) && Objects.equals(protocol, that.protocol) && Objects.equals(cancellationMessage, that.cancellationMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentDate, appointmentDuration, status, participants, protocol, cancellationMessage);
    }
}

package org.example.app.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.app.dal.entities.abstractions.User;

@Entity
@Table(name = "citizens")
public class Citizen extends User {
}

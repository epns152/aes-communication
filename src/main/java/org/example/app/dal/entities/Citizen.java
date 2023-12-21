package org.example.app.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizens")
public class Citizen extends User {
}

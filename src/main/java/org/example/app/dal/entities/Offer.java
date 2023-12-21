package org.example.app.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.app.dal.entities.abstractions.RequestToAES;

@Entity
@Table(name = "offers")
public class Offer extends RequestToAES {
}

package org.example.app.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends RequestToAES {
}

package com.spring.batch.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "SLOT_PLAN")
public class SlotPlan implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "slot_number")
    private String slotNumber;

    @Column(name = "slot_info")
    private String slotInfo;

}

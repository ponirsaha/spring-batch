package com.spring.batch.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@lombok.Data
public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 1454246093596040899L;

    private String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dob;

    private Long age;

}


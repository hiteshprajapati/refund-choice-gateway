package com.herringbank.refund.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String name;
    private Double refund;
    private String email;
    private Integer phone;
}

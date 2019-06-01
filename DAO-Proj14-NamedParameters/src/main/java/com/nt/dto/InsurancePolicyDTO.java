package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class InsurancePolicyDTO implements Serializable {
    private int ipid;
    private String ipName;
    private int initialAmount;
    private int tenure;
}

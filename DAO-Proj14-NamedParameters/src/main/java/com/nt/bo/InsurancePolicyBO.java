package com.nt.bo;

import lombok.Data;

@Data
public class InsurancePolicyBO {
    private int ipid;
    private String ipName;
    private int initialAmount;
    private int tenure;
}

package com.nt.service;

import com.nt.dto.BankDTO;

public interface BankService {
	String CalculateSICI(BankDTO dto) throws Exception;
}

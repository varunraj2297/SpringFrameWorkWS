package com.nt.service;

import com.nt.externalcomp.ExternalServiceComp;

public class IPLScoreCompService {
	ExternalServiceComp ext;

	public IPLScoreCompService(ExternalServiceComp ext) {
		this.ext = ext;
	}
	
	public String getExtService(int matchId) {
		String result=ext.getScore(matchId);
		return result;
	}
	
	
}

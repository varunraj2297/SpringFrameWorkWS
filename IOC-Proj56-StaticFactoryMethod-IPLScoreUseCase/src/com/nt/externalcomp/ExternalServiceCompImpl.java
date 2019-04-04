package com.nt.externalcomp;

public class ExternalServiceCompImpl implements ExternalServiceComp {

	@Override
	public String getScore(int matchid) {
		String result=null;
		if(matchid==1001) 
			result= "CSK vs MI----->Score::160/8(csk)";
		else if(matchid==1002)
			result= "SRH vs RCB----->Score::232/2(srh)";
		else if(matchid==1003)
			result= "DC vs RR------>Score::189/2(rr)";
		return result;
	}

}

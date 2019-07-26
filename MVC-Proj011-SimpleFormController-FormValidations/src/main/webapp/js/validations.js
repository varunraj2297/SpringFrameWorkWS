
function validate(frm){
	alert("validate(-)");
	let cname=frm.cname.value;
	let caddrs=frm.caddrs.value;
	let mobileNo=frm.mobileNo.value;
	let billAmount=frm.billAmount.value;
	frm.hbox.value="yes";
	
	document.getElementById("cname.err").innerHTML="";
	document.getElementById("caddrs.err").innerHTML="";
	document.getElementById("mobileNo.err").innerHTML="";
	document.getElementById("billAmount.err").innerHTML="";
	
	if(cname==""){
		alert("cname");
		document.getElementById("cname.err").innerHTML="customer name is required.";
	    frm.cname.focus();
	    return false;
	}
	
	if(caddrs==""){
		alert("caddrs");
		document.getElementById("caddrs.err").innerHTML="customer addrs is required.";
		frm.caddrs.focus();
		return false;
	}
	else if (caddrs.length<5 || caddrs.length>10) {
		alert("caddrs length");
		document.getElementById("caddrs.err").innerHTML="customer addrs must contain 5 to 10 chars.";
		frm.caddrs.focus();
		return false;
	}
	
	if(mobileNo==""){
		alert("mobile");
		document.getElementById("mobileNo.err").innerHTML="customer mobileNo is required.";
		frm.mobileNo.focus();
		return false;
	} else if(isNaN(mobileNo)){
		alert("mobile is num");
		document.getElementById("mobileNo.err").innerHTML="customer mobileNo must contain only numbers";
		frm.mobileNo.focus();
		return false;
	} else if(mobileNo<0){
		alert("mobile positive num");
		document.getElementById("mobileNo.err").innerHTML="customer mobileNo cannot be -ve";
		frm.mobileNo.focus();
		return false;
	} else if(mobileNo.length!=10){
		alert("mobile length");
		document.getElementById("mobileNo.err").innerHTML="customer mobileNo must contain 10 digits.";
		frm.mobileNo.focus();
		return false;
	} 
	
	if(billAmount==""){
		alert("billAmount");
		document.getElementById("billAmount.err").innerHTML="customer billAmount is required.";
		frm.billAmount.focus();
		return false;
	} else if(isNaN(billAmount)){
		alert("billAmount is num");
		document.getElementById("billAmount.err").innerHTML="customer billAmount must contain only numbers.";
		frm.billAmount.focus();
		return false;
	} else if(billAmount<0){
		alert("billAmount -ve");
		document.getElementById("billAmount.err").innerHTML="customer billAmount cannot be -ve.";
		frm.billAmount.focus();
		return false;
	}
	
	return true;
}
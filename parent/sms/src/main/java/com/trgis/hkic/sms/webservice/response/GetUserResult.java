package com.trgis.hkic.sms.webservice.response;

import javax.xml.bind.annotation.XmlType;

import com.trgis.hkic.sms.webservice.WsConstants;
import com.trgis.hkic.sms.webservice.response.dto.UserDTO;

@XmlType(name = "GetUserResult", namespace = WsConstants.NS)
public class GetUserResult extends WSResult {
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}

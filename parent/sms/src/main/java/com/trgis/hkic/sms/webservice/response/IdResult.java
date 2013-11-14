package com.trgis.hkic.sms.webservice.response;

import javax.xml.bind.annotation.XmlType;

import com.trgis.hkic.sms.webservice.WsConstants;

/**
 * 创建某个对象返回的 通用IdResult.
 * 
 * @author badqiu
 */
@XmlType(name = "IdResult", namespace = WsConstants.NS)
public class IdResult extends WSResult {
	private Long id;

	public IdResult() {
	}

	public IdResult(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

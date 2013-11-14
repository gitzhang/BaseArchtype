package com.trgis.hkic.sms.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.trgis.hkic.sms.webservice.response.GetUserResult;
import com.trgis.hkic.sms.webservice.response.IdResult;
import com.trgis.hkic.sms.webservice.response.SearchUserResult;
import com.trgis.hkic.sms.webservice.response.dto.UserDTO;

/**
 * JAX-WS2.0的WebService接口定义类.
 * 
 * 使用JAX-WS2.0 annotation设置WSDL中的定义.
 * 使用WSResult及其子类类包裹返回结果.
 * 使用DTO传输对象隔绝系统内部领域对象的修改对外系统的影响.
 * 
 * @author zhangqian
 */
// name 指明wsdl中<wsdl:portType>元素的名称
@WebService(name = "AccountService", targetNamespace = WsConstants.NS)
public interface AccountSoapService {

	/**
	 * 获取用户信息.
	 */
	GetUserResult getUser(@WebParam(name = "id") Long id);

	/**
	 * 搜索用户信息.
	 */
	SearchUserResult searchUser(@WebParam(name = "username") String username, @WebParam(name = "name") String name);

	/**
	 * 新建用户.
	 */
	IdResult createUser(@WebParam(name = "user") UserDTO user);

}

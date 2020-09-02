package util;

import common.CommonConstants;
import config.ConfigReader;
import dto.OrderDetailsDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtil {
	
	public static Response postRequest(Object requestObject, String serviceName) {
		RestAssured.baseURI = ConfigReader.getInstance().getProperties().getProperty(CommonConstants.BASE_URI);
		RequestSpecification request = RestAssured.given();
		request.header(CommonConstants.CONTENT_TYPE, CommonConstants.APPLICATION_JSON);
		Response response = request.body(requestObject).post(CommonConstants.FORWARD_SLASH+ConfigReader.getInstance().getProperties().getProperty(CommonConstants.VERSION_NUMBER)+serviceName);
		return response;
	}
	
	public static void main(String args[]) {
		OrderDetailsDTO details = new OrderDetailsDTO(100, 200, 10, "2020-09-02T16:23:03.557Z", "2020-09-02T16:23:03.557Z", true);
		Response response  = postRequest(details, "/store/order");
		System.out.println(response.getStatusCode());
	}
	
}

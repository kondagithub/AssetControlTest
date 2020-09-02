package stepdefinitions;

import static org.junit.Assert.*;

import common.CommonConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.JsonDataReader;
import dto.OrderDetailsDTO;
import io.restassured.response.Response;
import util.RestAssuredUtil;

public class PetPurchaseOrder {

	OrderDetailsDTO orderDetailsDTORequest = null;
	OrderDetailsDTO orderDetailsDTOResponse = null;
	Response response = null;
	
	@Given("^Loded purchase order details$")
	public void loded_purchase_order_details() throws Throwable {
		orderDetailsDTORequest = JsonDataReader.getOrderDetailsDTO();
		assertNotEquals(orderDetailsDTORequest, null);
	}

	@When("^Placed purchase order request$")
	public void placed_purchase_order_request() throws Throwable {
		response = RestAssuredUtil.postRequest(orderDetailsDTORequest, CommonConstants.STORE_ORDER_SERVICE_NAME);
		assertNotEquals(response, null);
	}
	
	@Then("^Verified for succes response$")
	public void verified_for_succes_response() throws Throwable {
		assertEquals(CommonConstants.HTTP_STATUS_CODE_200, response.getStatusCode());
	}
	
	@Then("^Verified responde details$")
	public void verified_responde_details() throws Throwable {
		orderDetailsDTOResponse = JsonDataReader.getOrderDetailsDTO(response.getBody().asString());
		assertEquals(orderDetailsDTORequest.getId(), orderDetailsDTOResponse.getId());
		assertEquals(orderDetailsDTORequest.getPetId(), orderDetailsDTOResponse.getPetId());
		assertEquals(orderDetailsDTORequest.getQuantity(), orderDetailsDTOResponse.getQuantity());
//		assertEquals(orderDetailsDTORequest.getShipDate(), orderDetailsDTOResponse.getShipDate());
		assertEquals(orderDetailsDTORequest.getStatus(), orderDetailsDTOResponse.getStatus());
	}
	
}

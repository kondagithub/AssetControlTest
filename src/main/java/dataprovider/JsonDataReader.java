package dataprovider;

import common.CommonConstants;
import config.ConfigReader;
import dto.OrderDetailsDTO;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	private static final String orderDetails = ConfigReader.getInstance().getProperties().getProperty(CommonConstants.TEST_DATA_RESOURCE_PATH)+"OrderDetails.json";
	private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static OrderDetailsDTO getOrderDetailsDTO() {
		OrderDetailsDTO orderDetailsDTO = null;
		try {
			orderDetailsDTO = mapper.readValue(new File(orderDetails), OrderDetailsDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orderDetailsDTO;
	}
	
	public static OrderDetailsDTO getOrderDetailsDTO(String jsonResponse) {
		OrderDetailsDTO orderDetailsDTO = null;
		try {
			orderDetailsDTO = JsonDataReader.getMapper().readValue(jsonResponse, OrderDetailsDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return orderDetailsDTO;
	}
	public static void main(String args[]) {
		OrderDetailsDTO orderDetailsDTO = getOrderDetailsDTO();
		System.out.println(orderDetailsDTO.getId());
	}
	
}

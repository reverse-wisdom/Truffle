package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.ssafy.pjt.dto.OrderDto;
import com.ssafy.pjt.service.OrderServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/truffle/swagger-ui.html
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/order")
public class OrderController {

	private IamportClient api;

	@Autowired
	private OrderServiceImpl orderService;

	public OrderController() {
		// i'mport rest api key, secret
		this.api = new IamportClient("1538295053237784",
				"aPXsDO8KmvABvbF5vUphFeHQt84sp6DzVB2yqajMGUnb52hBXGSDVzuoHyR6EuGA6I9wTtiznFKtI24G	");
	}

	@ApiOperation(value = "imp_uid 로 검증 진행")
	@GetMapping("/verifyIamport")
	private IamportResponse<Payment> paymentByImpUid(@RequestParam(required = true) final String imp_uid) {

		try {
			return api.paymentByImpUid(imp_uid);
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@ApiOperation(value = "결제 완료", notes = "uuid, event_id, imp_uid 값 필수")
	@PostMapping("/completePayment")
	private ResponseEntity<String> completePayment(@RequestBody(required = true) OrderDto orderDto) {
		try {
			boolean result = orderService.completePayment(orderDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}
		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

}

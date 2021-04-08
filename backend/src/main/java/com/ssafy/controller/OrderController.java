package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.ssafy.pjt.dto.OrderDto;
import com.ssafy.pjt.dto.OrderUpdateRequestDto;
import com.ssafy.pjt.service.OrderServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/truffle/swagger-ui.html
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/order")
public class OrderController {
	
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private IamportClient api;

	@Autowired
	private OrderServiceImpl orderService;

	public OrderController() {
		// i'mport REST API key, secret
		this.api = new IamportClient("1538295053237784",
				"aPXsDO8KmvABvbF5vUphFeHQt84sp6DzVB2yqajMGUnb52hBXGSDVzuoHyR6EuGA6I9wTtiznFKtI24G");
	}

	@ApiOperation(value = "imp_uid 로 검증 진행")
	@GetMapping("/verifyIamport")
	private IamportResponse<Payment> verifyIamport(@RequestParam(required = true) final String imp_uid) {
		try {
			return api.paymentByImpUid(imp_uid);
		} catch (IamportResponseException | IOException e) {
			return null;
		}
	}

	@ApiOperation(value = "결제 완료", notes = "uuid, event_id, imp_uid 값 필수")
	@PostMapping("/completePayment")
	private ResponseEntity<String> completePayment(@RequestBody(required = true) OrderDto orderDto) {
		try {
			boolean result = orderService.completePayment(orderDto);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}
		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Order 테이블조회", notes = "pay_status가 1이면 결제완료상태")
	@GetMapping("/selectOrderByEventId")
	private ResponseEntity<List<OrderDto>> selectOrderByEventId(@RequestParam(required = true) final int event_id) {
		List<OrderDto> list;
		try {
			list = orderService.selectOrderByEventId(event_id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "imp_uid를 통해 Iamprort 결제취소 호출")
	@GetMapping("/cancelIamport")
	private IamportResponse<Payment> cancelIamport(@RequestParam(required = true) final String imp_uid) {
		CancelData cancelData = new CancelData(imp_uid, true);
		try {
			return api.cancelPaymentByImpUid(cancelData);
		} catch (IamportResponseException | IOException e) {
			return null;
		}
	}

	@ApiOperation(value = "event_id를 통해 주문기록테이블 삭제")
	@DeleteMapping("/deleteOrderByEventId")
	private ResponseEntity<String> deleteOrderByEventId(@RequestParam(required = true) final int event_id) {
		try {
			boolean result = orderService.deleteOrderByEventId(event_id);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}
		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "주문상태변경")
	@PutMapping("/updateOrderStatus")
	private ResponseEntity<String> updateOrderStatus(
			@RequestBody(required = true) OrderUpdateRequestDto orderUpdateRequestDto) {
		try {
			boolean result = orderService.updateOrderStatus(orderUpdateRequestDto);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}
		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

}

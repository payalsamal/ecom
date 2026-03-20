package com.example.ecom.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.seller.model.SellerDto;
import com.example.ecom.seller.service.SellerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/seller",version="1")
@Tag(name = "Seller", description = "Seller management")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@PostMapping
//	@Operation(
//	        summary = "Create a new seller (v1)",
//	        description = "Saves a new seller and returns a confirmation",
//	        parameters = @Parameter(
//	            name = "X-API-Version",
//	            in = ParameterIn.HEADER,
//	            required = true,
//	            example = "1"          
//	        )
//	    )
	@ApiResponses({
        @ApiResponse(responseCode = "201", description = "Seller saved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
	public ResponseEntity<String>saveProduct(@RequestBody SellerDto seller){
		sellerService.save(seller);
		return  new ResponseEntity<String>("Saved successfully", HttpStatus.CREATED );
	}
	@GetMapping
	public ResponseEntity<List<SellerDto>>getSeller(){
		
		return  new ResponseEntity<List<SellerDto>>(sellerService.getAll(), HttpStatus.CREATED );
	}
}

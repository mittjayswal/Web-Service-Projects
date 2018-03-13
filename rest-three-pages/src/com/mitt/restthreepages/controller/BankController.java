package com.mitt.restthreepages.controller;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.mitt.restthreepages.BO.BankService;
import com.mitt.restthreepages.BO.BankServiceImpl;
import com.mitt.restthreepages.VO.BankVO;

@Path("/rest")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes (value = {MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
@RestController
@XmlRootElement(name = "BankVO")
public class BankController {

 	BankService bankService = new BankServiceImpl();
	
	@GET
	@Path("get")
	public ArrayList<BankVO> getAllBankInfo() {
		System.out.println("Controller");
		return bankService.getAllBankInfo();
	}
	
	@DELETE
	@Path("{messageId}")
	public void deleteBankInfo (@PathParam("messageId") int id) {
		System.out.println(id);
		bankService.deleteBankInfo(id);
	}
	
	@POST
	public void addBankInfo(BankVO bankvo) {
		try {
			bankService.addBankInfo(bankvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

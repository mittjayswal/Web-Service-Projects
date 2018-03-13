package com.mitt.restthreepages.BO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitt.restthreepages.DAO.BankDAO;
import com.mitt.restthreepages.DAO.BankDAOImpl;
import com.mitt.restthreepages.VO.BankVO;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankDAO bankdao = new BankDAOImpl();
	
	@Override
	public void addBankInfo(BankVO bvo) throws Exception {
		bankdao.addBankInfo(bvo);
		
	}

	@Override
	public ArrayList<BankVO> getAllBankInfo() {
		// TODO Auto-generated method stub
		System.out.println("Service");
		return bankdao.getAllBankInfo();
		
	}

	@Override
	public int deleteBankInfo(int id) {
		
		return bankdao.deleteBankInfo(id);
	}

}

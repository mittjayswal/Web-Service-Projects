package com.mitt.restthreepages.DAO;

import java.util.ArrayList;

import com.mitt.restthreepages.VO.BankVO;

public interface BankDAO {
	
	public void addBankInfo(BankVO bvo) throws Exception;

	public ArrayList<BankVO> getAllBankInfo();

	public ArrayList<BankVO> editBankInfo(String firstName);

	public int deleteBankInfo(int id);
}

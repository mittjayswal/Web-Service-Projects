package com.mitt.restthreepages.BO;

import java.util.ArrayList;
import java.util.List;

import com.mitt.restthreepages.VO.BankVO;

public interface BankService {

	public void addBankInfo(BankVO bvo) throws Exception;

	public ArrayList<BankVO> getAllBankInfo();

	public int deleteBankInfo(int id);

}

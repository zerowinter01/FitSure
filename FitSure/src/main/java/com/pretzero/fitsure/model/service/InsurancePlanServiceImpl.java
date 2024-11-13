package com.pretzero.fitsure.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretzero.fitsure.model.dao.InsurancePlanDao;
import com.pretzero.fitsure.model.dto.InsurancePlan;

@Service
public class InsurancePlanServiceImpl implements InsurancePlanService {

	@Autowired
	InsurancePlanDao insurancePlanDao; 
	
	@Override
	public void addinsurance(InsurancePlan insurancePlan) {
		insurancePlanDao.registInsurance(insurancePlan);
		
	}

	@Override
	public boolean disableInsurance(int insuranceId) {
		int result = insurancePlanDao.stopInsurance(insuranceId);
		
		if( result > 0) return true;
		else return false;
	}

	@Override
	public InsurancePlan readInsurance(int insuranceId) {
		InsurancePlan insurancePlan = new InsurancePlan();
		return insurancePlan = insurancePlanDao.selectInsurance(insuranceId);
	}
	
	@Override
	public boolean modifyInsurance(InsurancePlan insurancePlan) {
		int result = insurancePlanDao.changeInsurance(insurancePlan);
		
		if( result > 0) return true;
		else return false;
	}

	

}

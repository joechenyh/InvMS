package com.nus.invms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nus.invms.domain.PartUsage;
import com.nus.invms.repo.PartUsageRepository;

@Service
public class PartUsageServiceImpl implements PartUsageService {

	@Autowired
	PartUsageRepository purepo;

	public PartUsageServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean addPartUsage(PartUsage usage) {
		if (purepo.save(usage) != null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public void deletePartUsage(PartUsage usage) {
		purepo.delete(usage);

	}

	@Override
	@Transactional
	public PartUsage editPartUsage(PartUsage usage) {
		PartUsage currentusage = purepo.findById(usage.getTransactionId()).get();
		currentusage = usage;
		purepo.save(currentusage);

		return currentusage;
	}

	@Override
	@Transactional
	public ArrayList<PartUsage> listPartUsage() {
		return (ArrayList<PartUsage>) purepo.findAll();
	}

	@Override
	@Transactional
	public ArrayList<PartUsage> viewPartUsage(String partnumber) {
		return (ArrayList<PartUsage>) purepo.findPartUsageByPartNumber(partnumber);
	}

	@Override
	@Transactional
	public ArrayList<PartUsage> findPartUsageByCarplate(String carplate) {
		// TODO Auto-generated method stub
		return (ArrayList<PartUsage>) purepo.findUsageByCarplate(carplate);
	}

	@Override
	@Transactional
	public ArrayList<PartUsage> findByUsagedateBetween(String d1, String d2) {
		// TODO Auto-generated method stub
		return (ArrayList<PartUsage>) purepo.findByUsagedateBetween(d1, d2);
	}

	@Override
	@Transactional
	public PartUsage findByTransactionId(Integer tid) {
		// TODO Auto-generated method stub
		return purepo.findByTransactionId(tid);
	}

}





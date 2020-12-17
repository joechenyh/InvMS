package com.nus.invms.service;

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
	public List<PartUsage> listPartUsage() {
		return purepo.findAll();
	}

	@Override
	@Transactional
	public List<PartUsage> viewPartUsage(String partnumber) {
		return purepo.findPartUsageByPartNumber(partnumber);
	}

	@Override
	@Transactional
	public List<PartUsage> findPartUsageByCarplate(String carplate) {
		// TODO Auto-generated method stub
		return purepo.findUsageByCarPlate(carplate);
	}

	@Override
	@Transactional
	public List<PartUsage> findByUsageDateBetween(String d1, String d2) {
		// TODO Auto-generated method stub
		return purepo.findByUsageDateBetween(d1, d2);
	}

}

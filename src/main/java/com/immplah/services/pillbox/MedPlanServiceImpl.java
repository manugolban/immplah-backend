package com.immplah.services.pillbox;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.immplah.dtos.DayPlanDTO;
import com.immplah.services.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;


@Service
@AutoJsonRpcServiceImpl
public class MedPlanServiceImpl implements MedPlanService {


    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedPlanServiceImpl(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @Override
    public DayPlanDTO getTodaysPlan(String todaysDate, UUID patientId) {
        return medicationPlanService.getDayPlan(todaysDate, patientId);
    }
}

package com.immplah.services.pillbox;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.immplah.dtos.DayPlanDTO;
import com.immplah.services.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;


@Service
@AutoJsonRpcServiceImpl
public class MedPlanServiceImpl implements MedPlanService {

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedPlanServiceImpl(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @Override
    public DayPlanDTO getTodaysPlan(String todaysDate, UUID patientId) {
        return medicationPlanService.getDayPlan(todaysDate, patientId);
    }

    @Override
    public String markDrugAsTaken(String drug, UUID patientId, String date, String interval) {
        System.out.println(String.format("[%s] Patient with ID:[%s] has taken [%s] at [%s]", date, patientId, drug, interval));
        return "Drug was successfully marked as TAKEN!";
    }

    @Override
    public String markDrugAsNotTaken(String drug, UUID patientId, String date, String interval) {
        System.out.printf("[%s] Patient with ID:[%s] DID NOT TAKE [%s] at [%s]%n", date, patientId, drug, interval);
        webSocket.convertAndSend("/topic/notifications", String.format("[%s] Patient [Neal Caffrey] with ID:[%s] DID NOT TAKE [%s] at [%s]", date, patientId, drug, interval));
        return String.format("Caregiver of PATIENT with ID:[%s] has been alerted!", patientId);
    }



}

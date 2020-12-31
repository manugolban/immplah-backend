package com.immplah.services.pillbox;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.immplah.dtos.DayPlanDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;


@JsonRpcService("/pillbox")
public interface MedPlanService {

    DayPlanDTO getTodaysPlan(@JsonRpcParam(value = "date") String todaysDate,
                             @JsonRpcParam(value = "patientId") UUID patientId);

    String markDrugAsTaken(@JsonRpcParam(value = "drug") String drug,
                           @JsonRpcParam(value = "patientId") UUID patientId,
                           @JsonRpcParam(value = "takenOn") String date,
                           @JsonRpcParam(value = "interval") String interval);

    String markDrugAsNotTaken(@JsonRpcParam(value = "drug") String drug,
                           @JsonRpcParam(value = "patientId") UUID patientId,
                           @JsonRpcParam(value = "takenOn") String date,
                           @JsonRpcParam(value = "interval") String interval);
}

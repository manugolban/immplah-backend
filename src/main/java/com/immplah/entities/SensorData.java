package com.immplah.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class SensorData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name="patient_id", nullable = false)
    private UUID patientId;

    @Column(name="activity", nullable = false)
    private String activity;


    @Column(name="\"start\"", nullable = false)
    private long start;

    @Column(name="\"end\"", nullable = false)
    private long end;

    @Column(name="is_anomalous", nullable = false)
    private boolean isAnomalous;

    public SensorData() {
    }

    public SensorData(UUID patientId, String activity, long start, long end) {
        this.patientId = patientId;
        this.activity = activity;
        this.start = start;
        this.end = end;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public boolean isAnomalous() {
        return isAnomalous;
    }

    public void setAnomalous(boolean anomalous) {
        isAnomalous = anomalous;
    }
}

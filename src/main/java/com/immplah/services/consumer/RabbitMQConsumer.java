package com.immplah.services.consumer;


import com.immplah.entities.SensorData;
import com.immplah.repositories.SensorDataRepository;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RabbitMQConsumer {

    private final SensorDataRepository sensorDataRepository;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Autowired
    public RabbitMQConsumer(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @RabbitListener(queues = "${immplah.rabbitmq.queue}")
    public void recievedMessage(String incomingMessage) {

        JSONObject entry = new JSONObject(incomingMessage);
        SensorData sensorData = new SensorData(UUID.fromString(entry.getString("patient_id")),
                entry.getString("activity"),
                entry.getLong("start"),
                entry.getLong("end"));


        long periodHours = TimeUnit.MILLISECONDS.toHours(entry.getLong("end") - entry.getLong("start"));
        long periodMinutes = TimeUnit.MILLISECONDS.toMinutes(entry.getLong("end") - entry.getLong("start"));

        switch(entry.getString("activity")) {
            case "Sleeping":
                if (periodHours > 7) {
                    sensorData.setAnomalous(true);
                    webSocket.convertAndSend("/topic/notifications", String.format(
                            "Patient: [Neal Caffrey] has been sleeping for %s hours",
                            periodHours));
                    System.out.println("[ " + LocalTime.now() +" ]" + "A notification was sent to caregiver of [Neal Caffrey]");
                } else {
                    sensorData.setAnomalous(false);
                }
                break;
            case "Leaving":
                if (periodHours > 5) {
                    sensorData.setAnomalous(true);
                    webSocket.convertAndSend("/topic/notifications", String.format(
                            "Patient: [Neal Caffrey] has been outdoor for %s hours",
                            periodHours));
                    System.out.println("[ " + LocalTime.now() +" ]" + "A notification was sent to caregiver of [Neal Caffrey]");
                } else {
                    sensorData.setAnomalous(false);
                }
                break;
            case "Grooming":
            case "Toileting":
            case "Showering":
                if (periodMinutes > 30) {
                    webSocket.convertAndSend("/topic/notifications", String.format(
                            "Patient: [Neal Caffrey] has been in the bathroom for %s minutes",
                           periodMinutes));
                    System.out.println("[ " + LocalTime.now() +" ]" + "A notification was sent to caregiver of [Neal Caffrey]");
                    sensorData.setAnomalous(true);
                } else {
                    sensorData.setAnomalous(false);
                }
                break;
            default:
                sensorData.setAnomalous(false);
        }

        System.out.println( String.format("[%s] Received sensor data tuples >> ACTIVITY: [%s] WITH DURATION: [HOURS: %s | MINUTES: %s] >> [MARKED AS: %s ]",
                LocalDateTime.now(),
                entry.getString("activity"), periodHours, periodMinutes,
                sensorData.isAnomalous() ? "ANOMALOUS" : " *NOT* ANOMALOUS"));

        sensorData = sensorDataRepository.save(sensorData);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package naverreservation.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import naverreservation.config.kafka.KafkaProcessor;
import naverreservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ShopReservationRepository shopReservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_PaymentComplete(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener PaymentComplete : " + paid + "\n\n"
        );

        // Sample Logic //
        ShopReservation.paymentComplete(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCancelled'"
    )
    public void wheneverPaymentCancelled_PaymentCancel(
        @Payload PaymentCancelled paymentCancelled
    ) {
        PaymentCancelled event = paymentCancelled;
        System.out.println(
            "\n\n##### listener PaymentCancel : " + paymentCancelled + "\n\n"
        );

        // Sample Logic //
        ShopReservation.paymentCancel(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

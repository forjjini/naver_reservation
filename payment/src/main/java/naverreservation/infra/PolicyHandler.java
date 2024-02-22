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
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCancelRequested'"
    )
    public void wheneverPaymentCancelRequested_ReservtionCancelInfo(
        @Payload PaymentCancelRequested paymentCancelRequested
    ) {
        PaymentCancelRequested event = paymentCancelRequested;
        System.out.println(
            "\n\n##### listener ReservtionCancelInfo : " +
            paymentCancelRequested +
            "\n\n"
        );

        // Sample Logic //
        Payment.reservtionCancelInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentRequested'"
    )
    public void wheneverPaymentRequested_ReservtionInfo(
        @Payload PaymentRequested paymentRequested
    ) {
        PaymentRequested event = paymentRequested;
        System.out.println(
            "\n\n##### listener ReservtionInfo : " + paymentRequested + "\n\n"
        );

        // Sample Logic //
        Payment.reservtionInfo(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

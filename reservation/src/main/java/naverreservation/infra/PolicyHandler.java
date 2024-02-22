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
    ShopRepository shopRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentRequested'"
    )
    public void wheneverPaymentRequested_ReservationStatus(
        @Payload PaymentRequested paymentRequested
    ) {
        PaymentRequested event = paymentRequested;
        System.out.println(
            "\n\n##### listener ReservationStatus : " +
            paymentRequested +
            "\n\n"
        );

        // Sample Logic //
        Shop.reservationStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookCompleted'"
    )
    public void wheneverBookCompleted_ReservationStatus(
        @Payload BookCompleted bookCompleted
    ) {
        BookCompleted event = bookCompleted;
        System.out.println(
            "\n\n##### listener ReservationStatus : " + bookCompleted + "\n\n"
        );

        // Sample Logic //
        Shop.reservationStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookCancelled'"
    )
    public void wheneverBookCancelled_ReservationCancellationStatus(
        @Payload BookCancelled bookCancelled
    ) {
        BookCancelled event = bookCancelled;
        System.out.println(
            "\n\n##### listener ReservationCancellationStatus : " +
            bookCancelled +
            "\n\n"
        );

        // Sample Logic //
        Shop.reservationCancellationStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

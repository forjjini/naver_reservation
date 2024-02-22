package naverreservation.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import naverreservation.config.kafka.KafkaProcessor;
import naverreservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ReservationInfoRepository reservationInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookCompleted_then_CREATE_1(
        @Payload BookCompleted bookCompleted
    ) {
        try {
            if (!bookCompleted.validate()) return;

            // view 객체 생성
            ReservationInfo reservationInfo = new ReservationInfo();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            reservationInfoRepository.save(reservationInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookCancelled_then_UPDATE_1(
        @Payload BookCancelled bookCancelled
    ) {
        try {
            if (!bookCancelled.validate()) return;
            // view 객체 조회
            Optional<ReservationInfo> reservationInfoOptional = reservationInfoRepository.findById(
                bookCancelled.getUserId()
            );

            if (reservationInfoOptional.isPresent()) {
                ReservationInfo reservationInfo = reservationInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                reservationInfo.setStatus("예약취소");
                // view 레파지 토리에 save
                reservationInfoRepository.save(reservationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}

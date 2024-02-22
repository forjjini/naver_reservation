package naverreservation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import naverreservation.ShopApplication;
import naverreservation.domain.BookCancelled;
import naverreservation.domain.BookCompleted;
import naverreservation.domain.PaymentCancelRequested;
import naverreservation.domain.PaymentRequested;

@Entity
@Table(name = "ShopReservation_table")
@Data
//<<< DDD / Aggregate Root
public class ShopReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopId;

    private Date reservedDate;

    private Date reservedTime;

    private Integer reservedCnt;

    private Long charge;

    private String status;

    private Long userId;

    private String name;

    @PostPersist
    public void onPostPersist() {
        PaymentRequested paymentRequested = new PaymentRequested(this);
        paymentRequested.publishAfterCommit();

        PaymentCancelRequested paymentCancelRequested = new PaymentCancelRequested(
            this
        );
        paymentCancelRequested.publishAfterCommit();

        BookCompleted bookCompleted = new BookCompleted(this);
        bookCompleted.publishAfterCommit();

        BookCancelled bookCancelled = new BookCancelled(this);
        bookCancelled.publishAfterCommit();
        // Get request from ShopReservation
        //naverreservation.external.ShopReservation shopReservation =
        //    Application.applicationContext.getBean(naverreservation.external.ShopReservationService.class)
        //    .getShopReservation(/** mapping value needed */);

    }

    public static ShopReservationRepository repository() {
        ShopReservationRepository shopReservationRepository = ShopApplication.applicationContext.getBean(
            ShopReservationRepository.class
        );
        return shopReservationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void paymentComplete(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopReservation shopReservation = new ShopReservation();
        repository().save(shopReservation);

        BookCompleted bookCompleted = new BookCompleted(shopReservation);
        bookCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(shopReservation->{
            
            shopReservation // do something
            repository().save(shopReservation);

            BookCompleted bookCompleted = new BookCompleted(shopReservation);
            bookCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void paymentCancel(PaymentCancelled paymentCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopReservation shopReservation = new ShopReservation();
        repository().save(shopReservation);

        BookCancelled bookCancelled = new BookCancelled(shopReservation);
        bookCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(shopReservation->{
            
            shopReservation // do something
            repository().save(shopReservation);

            BookCancelled bookCancelled = new BookCancelled(shopReservation);
            bookCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

package naverreservation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import naverreservation.ReservationApplication;

@Entity
@Table(name = "Shop_table")
@Data
//<<< DDD / Aggregate Root
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long shopId;

    private Date reservedDate;

    private Integer reservedCnt;

    private Date reservedTime;

    private Long charge;

    private String name;

    private String name;

    @PostPersist
    public void onPostPersist() {}

    public static ShopRepository repository() {
        ShopRepository shopRepository = ReservationApplication.applicationContext.getBean(
            ShopRepository.class
        );
        return shopRepository;
    }

    //<<< Clean Arch / Port Method
    public static void reservationStatus(PaymentRequested paymentRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Shop shop = new Shop();
        repository().save(shop);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentRequested.get???()).ifPresent(shop->{
            
            shop // do something
            repository().save(shop);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void reservationStatus(BookCompleted bookCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Shop shop = new Shop();
        repository().save(shop);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookCompleted.get???()).ifPresent(shop->{
            
            shop // do something
            repository().save(shop);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void reservationCancellationStatus(
        BookCancelled bookCancelled
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Shop shop = new Shop();
        repository().save(shop);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookCancelled.get???()).ifPresent(shop->{
            
            shop // do something
            repository().save(shop);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

package hotel.reservation.models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;
    private String checkInDate;
    private String checkOutDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
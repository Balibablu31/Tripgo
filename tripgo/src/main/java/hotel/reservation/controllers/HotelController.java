package hotel.reservation.controllers;

import hotel.reservation.models.Hotel;
import hotel.reservation.services.HotelApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class HotelController {

    private final HotelApiService hotelApiService;

    @Autowired
    public HotelController(HotelApiService hotelApiService) {
        this.hotelApiService = hotelApiService;
    }

    @GetMapping("/api/hotels")
    public List<Hotel> getAvailableHotels(
            @RequestParam String locationId,
            @RequestParam String checkinDate,
            @RequestParam String checkoutDate) throws IOException {
        return hotelApiService.getHotels(locationId, checkinDate, checkoutDate);
    }
}
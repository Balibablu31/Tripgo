package hotel.reservation.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.reservation.services.HotelApiService;

@RestController
public class HotelController {

    private final HotelApiService hotelApiService;

    public HotelController(HotelApiService hotelApiService) {
        this.hotelApiService = hotelApiService;
    }

    @GetMapping("/api/hotels")
    public  Map<String, Object> getAvailableHotels(
            @RequestParam String locationId,
            @RequestParam String checkinDate,
            @RequestParam String checkoutDate) throws IOException {
        return hotelApiService.getHotels(locationId, checkinDate, checkoutDate);
    }
}
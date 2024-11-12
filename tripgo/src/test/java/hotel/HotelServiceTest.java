package hotel;

import hotel.reservation.models.Hotel;
import hotel.reservation.services.HotelService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    public HotelServiceTest(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Test
    public void testGetHotelById() {
        Long hotelId = 1L;
        Hotel hotel = hotelService.getHotelById(hotelId);
        assertNotNull(hotel);
        assertEquals(hotelId, hotel.getId(), "Hotel ID should match");
    }

    private void assertNotNull(Hotel hotel) {
    }

    @Test
    public void testInvalidHotelId() {
        Long invalidId = -1L;
        assertThrows(Exception.class, () -> hotelService.getHotelById(invalidId), "Exception expected for invalid ID");
    }
}
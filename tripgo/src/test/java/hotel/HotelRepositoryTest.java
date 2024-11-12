package hotel;

import hotel.reservation.models.Hotel;
import hotel.reservation.repositories.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    public void testSaveAndRetrieveHotel() {
        Hotel hotel = new Hotel("Sample Hotel", "Sample Location");
        hotelRepository.save(hotel);

        boolean exists = hotelRepository.existsById(hotel.getId());
        assertTrue(exists, "Hotel should be saved and found in repository");
    }
}
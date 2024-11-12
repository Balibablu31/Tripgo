package hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAvailableHotels() throws Exception {
        mockMvc.perform(get("/api/hotels")
                        .param("locationId", "1_318")
                        .param("checkinDate", "2024-11-15")
                        .param("checkoutDate", "2024-11-17"))
                .andExpect(status().isOk());
    }
}
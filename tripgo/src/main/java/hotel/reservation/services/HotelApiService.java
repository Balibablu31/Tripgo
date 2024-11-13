package hotel.reservation.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class HotelApiService {

    @Value("${api.hotel.url}")
    private String apiUrl;

    @Value("${api.rapidapi.key}")
    private String apiKey;

    @Value("${api.rapidapi.host}")
    private String apiHost;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> getHotels(String locationId, String checkinDate, String checkoutDate) throws IOException {
        // Build the URL with dynamic parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(apiUrl).newBuilder();
        urlBuilder.addQueryParameter("id", locationId);
        urlBuilder.addQueryParameter("checkinDate", checkinDate);
        urlBuilder.addQueryParameter("checkoutDate", checkoutDate);

        String url = urlBuilder.build().toString();

        // Create the request with headers
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", apiHost)
                .build();

        // Execute the request and parse response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Deserialize JSON response to Map<String, Object>
            String responseBody = response.body().string();

            // Parse the response into a Map
            return objectMapper.readValue(responseBody, Map.class);
        }
    }
}
package hotel.reservation.repositories;

import hotel.reservation.models.UserInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInquiryRepository extends JpaRepository<UserInquiry, Long> {
}
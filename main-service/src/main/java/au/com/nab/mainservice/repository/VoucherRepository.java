package au.com.nab.mainservice.repository;

import au.com.nab.mainservice.entity.Voucher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    List<Voucher> findAllByPhoneNumber(String phoneNumber);
}

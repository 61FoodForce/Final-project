package Repo;

import POJO.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepo extends CrudRepository<Donation, Long> {
}

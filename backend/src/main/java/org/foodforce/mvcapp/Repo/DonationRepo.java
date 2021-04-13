package org.foodforce.mvcapp.Repo;

import org.foodforce.mvcapp.POJO.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepo extends CrudRepository<Donation, Long> {
}

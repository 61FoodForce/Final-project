package org.foodforce.mvcapp.Repo;

import org.foodforce.mvcapp.POJO.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessRepo extends CrudRepository<Business, Long> {
    Business findByName(String name);
}

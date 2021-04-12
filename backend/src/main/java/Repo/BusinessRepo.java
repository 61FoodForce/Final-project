package Repo;

import POJO.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessRepo extends CrudRepository<Business, Long> {
}

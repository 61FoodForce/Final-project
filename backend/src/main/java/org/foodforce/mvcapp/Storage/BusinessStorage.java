package org.foodforce.mvcapp.Storage;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.Repo.BusinessRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessStorage {
    private BusinessRepo businessRepo;

    public BusinessStorage(BusinessRepo businessRepo) {this.businessRepo = businessRepo;}

    public void saveBusiness(Business business) {businessRepo.save(business);}

    public Iterable<Business> retrieveAllBusiness() {return businessRepo.findAll();}

    public void deleteBusinessById(Long id) {businessRepo.deleteById(id);}

    public Optional<Business> retrieveBusinessById(Long id) {return businessRepo.findById(id);}
}

package org.foodforce.mvcapp.Storage;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.Repo.BusinessRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BusinessStorage {
    private BusinessRepo businessRepo;

    public BusinessStorage(BusinessRepo businessRepo) {this.businessRepo = businessRepo;}

    public void saveBusiness(Business business) {businessRepo.save(business);}

    public Iterable<Business> retrieveAllBusiness() {return businessRepo.findAll();}

    public void deleteBusinessById(Long id) {businessRepo.deleteById(id);}

    public Optional<Business> retrieveDonationById(Long id) {return businessRepo.findById(id);}

    public Optional<Business> retrieveBusinessById(long id) {return businessRepo.findById(id);}

    public Business retrieveBusinessByName(String name){
        return businessRepo.findByName(name);

    }
    public Iterable<Business> retrieveAllCharities(){

        ArrayList<Business> charities = new ArrayList<Business>();
        for (Business business : businessRepo.findAll()) {
            if (business.getCharity()) {
                charities.add(business);
            }
        }
        return charities;
    }
    public Iterable<Business> retrieveAllForProfit(){

        ArrayList<Business> forProfit = new ArrayList<Business>();
        for (Business business : businessRepo.findAll()) {
            if (!business.getCharity()) {
                forProfit.add(business);
            }
        }
        return forProfit;
    }

}

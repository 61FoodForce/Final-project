package org.foodforce.mvcapp.Storage;

import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Repo.DonationRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonationStorage {
    private DonationRepo donationRepo;

    public DonationStorage(DonationRepo donationRepo) {this.donationRepo = donationRepo;}

    public void saveDonation(Donation donation) {donationRepo.save(donation);}

    public Iterable<Donation> retrieveAllDonations() {return donationRepo.findAll();}

    public void deleteDonationById(Long id) {
        donationRepo.deleteById(id);

    }

    public Optional<Donation> retrieveDonationById(Long id) {return donationRepo.findById(id);}


    }




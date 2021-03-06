package org.foodforce.mvcapp.POJO;

import javax.persistence.*;

@Entity
public class Donation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Business business;
    private int foodQuantity;
    private Unit foodUnit;
    private boolean readyForPickup =false;
    private String donatedBy;
    public enum Unit{
        CAN,
        POUND,
        CASE,
        GALLONS,
        BOX,
        BAG
    }

//    //private String foodUnit;
//    public enum Unit{
//        CAN("Can"),
//        POUND("Pounds")
//
////        can("can"),
////        lb("pounds");
////
////        public String getLabel() {
////            return label;
////        }
////
////        private final String label;
////        private unit(String label){
////            this.label = label;
//      }

//
    public Donation(){}

    public Donation(String itemName, Business business, int foodQuantity,  Unit foodUnit){
        this.name = itemName;
        this.business = business;
        this.foodQuantity = foodQuantity;
        this.foodUnit = foodUnit;
    }
    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit getFoodUnit() {
        return foodUnit;
    }

    public void setFoodUnit(Unit foodUnit) {
        this.foodUnit = foodUnit;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public boolean isReadyForPickup() {
        return readyForPickup;
    }

    public void setReadyForPickup(boolean readyForPickup) {
        this.readyForPickup = readyForPickup;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public void setDonatedBy(String donatedBy) {
        this.donatedBy = donatedBy;
    }
}

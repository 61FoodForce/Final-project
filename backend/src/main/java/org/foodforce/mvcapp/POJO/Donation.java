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

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    private int foodQuantity;
    private String foodUnit;
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


    protected Donation(){}

    public Donation(String itemName, Business business){
        this.name = itemName;
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

    public String getFoodUnit() {
        return foodUnit;
    }

    public void setFoodUnit(String foodUnit) {
        this.foodUnit = foodUnit;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }
}
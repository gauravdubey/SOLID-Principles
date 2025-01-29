package com.gaurav.solidprinciples.ocp;

/**
 * This class is not following the OCP principle
 */
public class InvoiceWithoutOCP {

    /**
     * This method is not open for extension
     * @param type
     * @return
     */
    double calculateDiscount(String type){
        if (type.equalsIgnoreCase("New Customer")){
            return 10;
        }else if (type.equalsIgnoreCase("Royal Customer")){
            return 20;
        }
        return 0;
    }
}



// Now the below classes are following the OCP principle
// OCP : "Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."
/**
 * This interface is open for extension
 */
interface Discount{
    double getDiscount();
}

/**
 * This class is open for extension
 */
class NewCustomerDiscount implements Discount{
    @Override
    public double getDiscount() {
        return 10;
    }
}

/**
 * This class is open for extension
 */
class RoyalCustomerDiscount implements Discount{
    @Override
    public double getDiscount() {
        return 20;
    }
}

/**
 * This class is closed for modification
 */
class InvoiceWithOCP{
    double calculateDiscount(Discount discount){
        return discount.getDiscount();
    }
}

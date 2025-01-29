package com.gaurav.solidprinciples.isp;

// ISP : "A class should not be forced to implement interfaces it does not use."
/**
 * Segregate the Interface according the needs
 */
interface Workable{
    void work();
}

interface Eatable{
    void eat();
}

/**
 * This class is following the ISP principle
 */
public class DeveloperWithISP implements Workable{
    @Override
    public void work() {
        System.out.println("Writing code ...");
    }
}

/**
 * This class is following the ISP principle
 */
class DeveloperAtLunch implements Eatable{
    @Override
    public void eat() {
        System.out.println("Eating Food ...");
    }
}

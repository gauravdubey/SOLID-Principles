package com.gaurav.solidprinciples.isp;

interface Worker{
    void work();
    void eat();
}

public class DeveloperWithoutISP implements Worker{

    @Override
    public void work() {
        System.out.println("Writing code ...");
    }

    @Override
    public void eat() { // ❌ Not all workers need an eat method
        System.out.println("Eating Food ...");
    }
}

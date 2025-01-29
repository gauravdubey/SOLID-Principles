package com.gaurav.solidprinciples.srp;

/**
 * Violating SRP Rules of SOLID
 */
public class User {
    String name;
    String email;

    void saveFile(){ // This method doesn't belong here
        System.out.println("Saving user data to file ...");
    }
}

/**
 * Following SRP Rules of SOLID
 */
// SRP : "A class should have only one reason to change."
class UserWithSRP{
    String name;
    String email;
}

/**
 * Separate class for saving user data to database
 */
class UserRepository{
    void save(UserWithSRP user){
        System.out.println("Saving user data to database ...");
    }

}
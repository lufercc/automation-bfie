package com.fie.stepdef;

import com.fie.pageobject.Pet;
import com.fie.pageobject.ProductPage;
import io.cucumber.java.en.Then;

public class Print {
    private Pet pet;

    public Print(Pet pet){
        this.pet = pet;
    }

    @Then("Print name")
    public void printName() {
        String petName = pet.getName();
        System.out.println(petName + "******");
    }
}

package com.fie.stepdef;

import com.fie.pageobject.Pet;
import io.cucumber.java.en.Given;

public class Create {
    private Pet pet;

    public Create(Pet pet){
        this.pet = pet;
    }

    @Given("I create pet {string}")
    public void iCreatePet(String name) {
        pet.setName(name);
    }
}

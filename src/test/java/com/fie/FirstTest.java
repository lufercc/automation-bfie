package com.fie;

import com.fie.UnderTest;
import org.testng.annotations.Test;

public class FirstTest {
    UnderTest underTest = new UnderTest();

    @Test
    public void test1(){
        assert true;
    }

    @Test
    public void test2(){
        assert "1" == "1";
    }

    @Test
    public void verifyTheMethodSumaWorksWithNaturalNumbers(){
        int response = underTest.suma(5, 2);
        assert response == 7;
    }

    @Test
    public void verifyTheMethodSumaWorksWithNegativeNumbers(){
        int response = underTest.suma(-5, -2);
        assert response == -7;
    }

    @Test
    public void verifyTheMethodSumaWorksWithNegativeAndPositiveNumbers(){
        int response = underTest.suma(-5, 2);
        assert response == -3;
    }

}

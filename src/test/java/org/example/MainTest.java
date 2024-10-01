package org.example;
import org.junit.Assert;
import org.junit.Test;

import java.lang.foreign.AddressLayout;

public class MainTest {
    @Test
    public void test(){
        Assert.assertTrue(Main.IsExample (6));
    }
    @Test
    public void test2(){
        Assert.assertTrue(Main.IsExample(99));
    }
}

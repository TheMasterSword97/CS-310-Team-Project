/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.tas_fa20;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author SomeAnxiousIguana
 */
public class JUnitTest {
    

@Test
public void testClassMethod1() {
    assertEquals(TestClass.testMethod1(), "Hello, World!");
}
@Test
public void testClassMethod2() {
    assertEquals(TestClass.testMethod2(), "Hello there, world!");
}

}

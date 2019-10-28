package co.creativegaming.java.recruiting.cgspringboottest.task1;

import org.junit.Assert;
import org.junit.Test;

public class SpecialStringTest {

    @Test
    public void testIsSpecial1() throws Exception {
        boolean result1 = SpecialString.isSpecial("bac");
        Assert.assertFalse(result1);
        
        
        boolean result2 = SpecialString.isSpecial("aei");
       // System.out.println(result2);
        Assert.assertTrue(result2);
        
        boolean result3 = SpecialString.isSpecial("nn");
        // System.out.println(result2);
         Assert.assertTrue(result3);
         
         boolean result4 = SpecialString.isSpecial("bac");
         // System.out.println(result2);
          Assert.assertFalse(result4);
          
          boolean result5 = SpecialString.isSpecial("aza");
          // System.out.println(result2);
           Assert.assertFalse(result5);
           
           boolean result6 = SpecialString.isSpecial("abaca");
           // System.out.println(result2);
            Assert.assertFalse(result6);
            
            boolean result7 = SpecialString.isSpecial("baaa");
            Assert.assertTrue(result7);
            
            boolean result8 = SpecialString.isSpecial("aaab");
            Assert.assertTrue(result8);
            
            
        
    }
}

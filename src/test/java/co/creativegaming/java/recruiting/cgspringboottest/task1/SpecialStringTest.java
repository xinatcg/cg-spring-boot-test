package co.creativegaming.java.recruiting.cgspringboottest.task1;

import org.junit.Assert;
import org.junit.Test;

public class SpecialStringTest {

    @Test
    public void testIsSpecial1() throws Exception {
        boolean result = SpecialString.isSpecial("bac");
        Assert.assertFalse(result);
    }
}

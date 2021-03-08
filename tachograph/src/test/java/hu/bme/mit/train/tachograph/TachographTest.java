package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.OffsetDateTime;

public class TachographTest {

 @Test
    public void TachographTest1() {
     Tachograph t = new Tachograph();
     int count = t.count();

     t.add(OffsetDateTime.now(), 2, 120.0);
     Assert.assertTrue(count < t.count());
 }
	
}

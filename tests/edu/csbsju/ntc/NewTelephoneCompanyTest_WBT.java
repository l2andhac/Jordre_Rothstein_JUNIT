package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	  
	  @Before
	  public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }
	  
	  @Test(expected=UnsupportedOperationException.class)
	  public void testComputeChargeInvalidStartTime() {
		  ntc.setStartTime(-5);
		  ntc.setDuration(10);
		  ntc.computeCharge();
	  }
	  
	  @Test(expected=UnsupportedOperationException.class)
	  public void testComputeChargeInvalidDuration() {
		  ntc.setStartTime(1800);
		  ntc.setDuration(0);
		  ntc.computeCharge();
	  }

	  @Test
	  public void testComputeChargeDiscountedStartTimeAndDiscountedDuration() {
		  ntc.setStartTime(500);
		  ntc.setDuration(100);
		  
		  assertTrue("The charge should be 1768", ntc.computeCharge() == 1768.0);
	  }
	  
	  @Test
	  public void testComputeChargeDiscountedStartTimeOnly() {
		  ntc.setStartTime(0);
		  ntc.setDuration(60);
		  
		  assertTrue("The charge should be 1248", ntc.computeCharge() == 1248.0);
	  }
	  
	  @Test
	  public void testComputeChargeDiscountedDurationOnly() {
		  ntc.setStartTime(800);
		  ntc.setDuration(65);
		  
		  assertTrue("The charge should be 2298.4", ntc.computeCharge() == 2298.4);
	  }
	  
	  @Test
	  public void testComputeChargeNoDiscounts() {
		  ntc.setStartTime(1000);
		  ntc.setDuration(40);
		  
		  assertTrue("The charge should be 1664", ntc.computeCharge() == 1664.0);
	  }
}

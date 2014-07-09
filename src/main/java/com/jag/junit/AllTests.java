package com.jag.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite()); 
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for junit");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestIt2.class);
		suite.addTestSuite(TestIt.class);
		//$JUnit-END$
		return suite;
	}

}

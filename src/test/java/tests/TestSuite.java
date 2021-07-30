package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SuiteDisplayName;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Test Suite Tests and TestURL")
@SelectClasses({Tests.class, TestURL.class})
public class TestSuite {

}

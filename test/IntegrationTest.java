


import play.mvc.*;


import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fest.assertions.Assertions.assertThat; 
import static play.test.Helpers.HTMLUNIT; 
import static play.test.Helpers.fakeApplication; 
import static play.test.Helpers.inMemoryDatabase; 
import static play.test.Helpers.running; 
import static play.test.Helpers.testServer; 
import org.junit.Test; 

import play.test.TestBrowser; 
import static play.test.*;
 

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
   
    @Test
    public void test() {
        running(testServer(), HTMLUNIT, browser -> {
                browser.goTo("http://localhost:3333");
                assertThat(browser.pageSource()).contains("HELLO, WORLD");
            });
        }
    

}

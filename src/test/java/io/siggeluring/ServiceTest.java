package io.siggeluring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Optional;

import java.util.Date;

public class ServiceTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createService() {
        Service service = new Service("google", "http://google.com");
        Assert.assertEquals(service.getName(), "google");
        Assert.assertEquals(service.getUrl(), "http://google.com");
    }

    @Test
    public void setCheckStatus() {
        Date checkdate = new Date();
        String status = "OK";
        Service service = new Service("google", "http://google.com");
        service.setCheckStatus(status, checkdate);
        Assert.assertEquals(service.getLastCheck(), checkdate);
        Assert.assertEquals(service.getStatus(), status);
    }

}

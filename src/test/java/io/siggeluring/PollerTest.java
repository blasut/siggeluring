package io.siggeluring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Optional;

import java.util.Date;

public class PollerTest {

    @Test
    public void pollerShouldSetStatusOfPollOnService() {
        Service service = new Service("google", "http://google.com");
        Services services = Services.INSTANCE;
        services.add(service);
        Poller poller = new Poller(services);
        poller.start();
    }
}

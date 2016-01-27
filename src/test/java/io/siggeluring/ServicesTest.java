package io.siggeluring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Optional;

public class ServicesTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        // Här borde vi rensa collectionen
        Services services = Services.INSTANCE;
        services.clear();
    }

    @Test
    public void servicesAdd() {
        Services services = Services.INSTANCE;
        Service service = new Service("mjau", "Mjausson");
        services.add(service);
    }

    @Test
    public void servicesAll() {
        Services services = Services.INSTANCE;
        Service service = new Service("mjau", "Mjausson");
        services.add(service);
        Optional<Service> firstElement = services.all().stream().findFirst();
        Assert.assertEquals(firstElement.get().getId(), service.getId());
    }

    @Test
    public void servicesDelete() {
        Services services = Services.INSTANCE;
        Service service = new Service("mjau", "Mjausson");
        services.add(service);
        services.delete(service.getId());
        Assert.assertTrue("services.all is empty", services.all().isEmpty());
    }

    @Test
    public void servicesShouldReturnJsonEncodedVersion() {
        Services services = Services.INSTANCE;
        Service service = new Service("mjau", "Mjausson");
        services.add(service);
        services.getAllAsJson();
        // TOOD: implement this test
    }

}

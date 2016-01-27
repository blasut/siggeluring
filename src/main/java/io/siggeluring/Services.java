package io.siggeluring;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.file.FileSystem;

/*
  Den här klassen är ansvarig för att spara alla Services.
  Den håller dom dessutom i minnet, vilket gör att vi inte behöver öppna filen för att hämta ut dom.

  Det går att utökad denna klass, så att den instanseras med en fil.
 */

public class Services {
    // Thread safe.
    public final static Services INSTANCE = new Services();
    private final static Vertx vertx = Vertx.vertx();
    private final static String fileName = "target/classes/services.json";
    
    private Services() {
        // Detta är en singleton class, vilket innebär att endast en instansiering finns tillgänglig
        initServicesMap();
    }

    public Collection<Service> all() {
        return getServicesList();
    }

    public String getAllAsJson() {
        return Json.encodePrettily(servicesMap);
    }

    public void add(Service service) {
        getServicesList().add(service);
        save_to_file();
    }

    public void delete(Integer id) {
        Iterator<Service> s = getServicesList().iterator();
        while (s.hasNext()) {
            Service service = s.next();
            if (service.getId() == id) {
                s.remove();
            }
        }
        save_to_file();
    }

    public void clear() {
        getServicesList().clear();
        save_to_file();
    }


    /*
      This passes the tests, but can probably be made nicer. It should be initiated in one go
     */
    private Map<String, ArrayList> servicesMap = new LinkedHashMap<>();

    private void initServicesMap() {
        ArrayList servicesList = new ArrayList();
        servicesMap.put("services", servicesList);
    }

    private ArrayList getServicesList() {
        return servicesMap.get("services");
    }

    private void save_to_file() {
        // Vi kan göra såhär pga singletonen är garanterat att endast en instans finns på hela JVMen.
        Buffer servicesBuffer = Buffer.buffer(getAllAsJson());
        vertx.fileSystem().writeFile(fileName, servicesBuffer, result -> {
                if (result.succeeded()) {
                    System.out.println("File written");
                } else {
                    System.err.println("Oh oh ..." + result.cause());
                }
            });
    }
}

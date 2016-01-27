package io.siggeluring;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;

public class Services {
    // Thread safe.
    public final static Services INSTANCE = new Services();
    private Services() {
        // Detta är en singleton class, vilket innebär att endast en instansiering finns tillgänglig
    }

    private Map<Integer, Service> services_list = new LinkedHashMap<>();

    public Collection<Service> all() {
        return services_list.values();
    }

    public void add(Service service) {
        services_list.put(service.getId(), service);
    }

    public void delete(Integer id) {
        services_list.remove(id);
    }

    public void clear() {
        services_list.clear();
    }
}

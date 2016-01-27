package io.siggeluring;

/*
  vertx.setPeriodic(1000, id -> {
  // This handler will get called every second
  System.out.println("timer fired!");
  });
 */

import java.util.Iterator;
import java.util.Date;

import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;

import io.vertx.core.Vertx;

class Poller {
    private final static Vertx vertx = Vertx.vertx();

    public Poller(Services services) {
        this.services = services;
    }

    private Services services;

    public void start() {
        poll();
    }

    private void poll() {
        // For each of the services,
        //     - Make a HTTP request
        //     - Depending on the result, set the status of the object 
        Iterator<Service> s = services.all().iterator();
        while (s.hasNext()) {
            Service service = s.next();
            // POLL
            if(checkStatus(service)) {
                service.setCheckStatus("OK", new Date());
            } else {
                service.setCheckStatus("FAIL", new Date());
            }
        }
        services.save_to_file();
    }

    private boolean checkStatus(Service service) {
        Integer statusCode = 0;
        vertx.createHttpClient().getNow("/", new Handler<HttpClientResponse>() {
                public void handle(HttpClientResponse response) {
                    response.dataHandler(new Handler<Buffer>() {
                            public void handle(Buffer data) {
                                System.out.println(data);
                            }
                        });
          }
        });

        if(statusCode == 200) {
            return true;
        } else {
            return false;
        }
    }
}

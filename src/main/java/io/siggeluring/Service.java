package io.siggeluring;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int id;

    private String name;
    private String url;
    private String status;
    private Date lastCheck;

    public Service(String name, String url) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.url = url;
    }

    public Service() {
        this.id = COUNTER.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    public void setCheckStatus(String status, Date lastCheck) {
        this.setLastCheck(lastCheck);
        this.setStatus(status);
    }
}

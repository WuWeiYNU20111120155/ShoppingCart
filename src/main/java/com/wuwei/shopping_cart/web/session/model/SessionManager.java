package com.wuwei.shopping_cart.web.session.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class SessionManager {

    private Map<Integer,Session> sessions = new HashMap<>();

    public Map<Integer, Session> getSessions() {
        return sessions;
    }

    public void setSessions(Map<Integer, Session> sessions) {
        this.sessions = sessions;
    }
}

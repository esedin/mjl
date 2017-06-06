package com.yard42.l.java.guice.agent;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

public class HollywoodServiceClient {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceJuice hollywoodService = injector.getInstance(HollywoodServiceJuice.class);
        List<Agent> agents = hollywoodService.getFriendlyAgents();
    }
}

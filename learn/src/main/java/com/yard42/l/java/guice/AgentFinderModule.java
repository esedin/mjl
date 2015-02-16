package com.yard42.l.java.guice;

import com.google.inject.AbstractModule;

public class AgentFinderModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(WebServiceAgentFinder.class);
    }
}

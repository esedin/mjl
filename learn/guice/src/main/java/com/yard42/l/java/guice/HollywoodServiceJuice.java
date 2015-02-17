package com.yard42.l.java.guice;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ievgen on 2/15/2015.
 */
public class HollywoodServiceJuice {
    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceJuice(AgentFinder finder) {
        this.finder = finder;
    }

    public List<Agent> getFriendlyAgents() {
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }

    public List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<Agent>();
        for (Agent agent : agents) {
            if (agent.getType().equals(agentType)) {
                filteredAgents.add(agent);
            }
        }

        return filteredAgents;
    }
}

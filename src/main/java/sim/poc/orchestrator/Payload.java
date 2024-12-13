package sim.poc.orchestrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class Payload {

    @JsonProperty("inbound")
    private Inbound inbound;

    @JsonProperty("outbound")
    private Outbound outbound;

    @JsonProperty("workflowList")
    private List<String> workflowList;

    // Default constructor
    public Payload() {}

    // Constructor with workflowList
    public Payload(Workflow workflow) {
        this.workflowList = workflow.getPayload().getWorkflowList();
    }


    // Getters and Setters
    public Inbound getInbound() {
        return inbound;
    }

    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
    }

    public Outbound getOutbound() {
        return outbound;
    }

    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

    public List<String> getWorkflowList() {
        return workflowList;
    }

    public void setWorkflowList(List<String> workflowList) {
        this.workflowList = workflowList;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "inbound=" + inbound +
                ", outbound=" + outbound +
                ", workflowList=" + workflowList +
                '}';
    }

    public static class Inbound {
        @JsonProperty("type")
        private String type;

        @JsonProperty("parameters")
        private Map<String, Object> parameters;

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Map<String, Object> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, Object> parameters) {
            this.parameters = parameters;
        }

        @Override
        public String toString() {
            return "Inbound{" +
                    "type='" + type + '\'' +
                    ", parameters=" + parameters +
                    '}';
        }
    }

    public static class Outbound {
        @JsonProperty("type")
        private String type;

        @JsonProperty("parameters")
        private Map<String, Object> parameters;

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Map<String, Object> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, Object> parameters) {
            this.parameters = parameters;
        }

        @Override
        public String toString() {
            return "Outbound{" +
                    "type='" + type + '\'' +
                    ", parameters=" + parameters +
                    '}';
        }
    }
}

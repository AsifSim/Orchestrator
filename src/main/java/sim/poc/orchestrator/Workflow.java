package sim.poc.orchestrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Workflow {
    @JsonProperty("workflowName") // New field to match the JSON
    private String workflowName;

    @JsonProperty("payload")
    private Payload payload;

    @JsonProperty("port")
    private int port;

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String toString(){
        return "Workflow{" +
                "workflowName='" + workflowName + '\'' +
                ", payload=" + payload +
                ", port=" + port +
                '}';
    }

}

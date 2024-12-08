package sim.poc.orchestrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workflow {
    @JsonProperty("inbound")
    String inbound;
    @JsonProperty("outbound")
    String outbound;
    @JsonProperty("workflowList")
    List<String> workflowList;
}

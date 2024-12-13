package sim.poc.orchestrator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    @Qualifier("inboundPayload")
    public Payload.Inbound inboundPayload() {
        Payload.Inbound inbound = new Payload.Inbound();
        System.out.println("Creating a new instance of inboundPayload with hashCode: " + inbound.hashCode());
        return inbound;
    }

    @Bean
    @Scope("prototype")
    @Qualifier("outboundPayload")
    public Payload.Outbound outboundPayload() {
        Payload.Outbound outbound = new Payload.Outbound();
        System.out.println("Creating a new instance of outboundPayload with hashCode: " + outbound.hashCode());
        return outbound;
    }

    @Bean
    @Qualifier("workflowList")
    public List<String> defaultWorkflowList() {
        System.out.println("Creating singleton workflowList");
        return List.of("DefaultWorkflow1", "DefaultWorkflow2");
    }
}

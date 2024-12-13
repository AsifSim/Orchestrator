package sim.poc.orchestrator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowProcessor {

    private final ApplicationContext context;
    private final List<String> defaultWorkflowList;

    public WorkflowProcessor(
            ApplicationContext context,
            @Qualifier("workflowList") List<String> defaultWorkflowList
    ) {
        this.context = context;
        this.defaultWorkflowList = defaultWorkflowList;
    }

    public void processWorkflow(Workflow workflow) {
        // Retrieve prototype beans for inbound and outbound
        Payload.Inbound inbound = context.getBean("inboundPayload", Payload.Inbound.class);
        Payload.Outbound outbound = context.getBean("outboundPayload", Payload.Outbound.class);

        // Set inbound and outbound from workflow
        inbound.setType(workflow.getPayload().getInbound().getType());
        inbound.setParameters(workflow.getPayload().getInbound().getParameters());

        outbound.setType(workflow.getPayload().getOutbound().getType());
        outbound.setParameters(workflow.getPayload().getOutbound().getParameters());

        // Create Payload with singleton workflowList
        Payload payload = new Payload(workflow);
        payload.setInbound(inbound);
        payload.setOutbound(outbound);

        System.out.println("Processing workflow:");
        System.out.println("Inbound: " + payload.getInbound());
        System.out.println("Outbound: " + payload.getOutbound());
        System.out.println("Workflow List: " + payload.getWorkflowList());

        try {
            Thread.sleep(4000); // Simulating processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Workflow processing interrupted for: " + workflow);
        }

        System.out.println("Completed processing for workflow on port: " + workflow.getPort());
    }
}
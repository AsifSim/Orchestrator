package sim.poc.orchestrator;

import sim.poc.orchestrator.Workflow;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WorkflowProcessor {

    @Async("taskExecutor")
    public void processWorkflow(Workflow workflow) {
        System.out.println("Processing workflow: " + workflow.workflowList.toString());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Workflow processing interrupted: " + workflow);
        }
        System.out.println("Completed processing: " + workflow);
    }
}


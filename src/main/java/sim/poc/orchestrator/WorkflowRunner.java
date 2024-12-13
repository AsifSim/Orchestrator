package sim.poc.orchestrator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkflowRunner implements CommandLineRunner {

    private final WorkflowService workflowService;
    private final WorkflowProcessor workflowProcessor;

    public WorkflowRunner(WorkflowService workflowService, WorkflowProcessor workflowProcessor) {
        this.workflowService = workflowService;
        this.workflowProcessor = workflowProcessor;
    }

    @Override
    public void run(String... args) {
        String directoryPath = "C:/spriced-platform/Orchestrator/Orchestrator/src/main/resources";
        List<Workflow> workflows = workflowService.loadWorkflows(directoryPath);

        for (Workflow workflow : workflows) {
            try {
                workflowProcessor.processWorkflow(workflow);
            } catch (Exception e) {
                System.err.println("Error processing workflow: " + workflow.getWorkflowName() + " - " + e.getMessage());
            }
        }
    }
}

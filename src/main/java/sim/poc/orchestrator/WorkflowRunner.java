package sim.poc.orchestrator;

//import sim.poc.orchestrator.Workflow;
//import sim.poc.orchestrator.WorkflowProcessor;
//import sim.poc.orchestrator.WorkflowService;
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
        String directoryPath = "C:/Users/asif.azmi_simadvisor/Downloads/orchestrator/orchestrator/src/main/resources";
        List<Workflow> workflows = workflowService.loadWorkflows(directoryPath);

        for (Workflow workflow : workflows) {
            workflowProcessor.processWorkflow(workflow);
        }
    }
}


package sim.poc.orchestrator;

import sim.poc.orchestrator.Workflow;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkflowService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Workflow> loadWorkflows(String directoryPath) {
        List<Workflow> workflows = new ArrayList<>();
        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null) {
            for (File file : files) {
                try {
                    System.out.println("FOr file "+file.getName());
                    Workflow workflow = objectMapper.readValue(file, Workflow.class);
                    workflows.add(workflow);
                } catch (Exception e) {
                    System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
                }
            }
        }
        return workflows;
    }
}


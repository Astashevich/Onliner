package by.onliner.cucumber.testContext;

import java.util.HashMap;
import java.util.Map;

/***
 *  ScenarioContext helps to store data and pass it from step to step
 */
public class ScenarioContext {

    private static ScenarioContext scenario;
    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getScenarioContext() {
        if (scenario == null) {
            scenario = new ScenarioContext();
        }
        return scenario;
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}

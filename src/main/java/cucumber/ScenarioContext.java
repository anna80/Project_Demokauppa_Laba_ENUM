package cucumber;

import java.util.HashMap;
import java.util.Map;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    /*принимает два параметра: ключ в виде строки и значение
    в виде объекта. Key – это не что иное, как перечисление Context.*/

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    /*принимает ключ в качестве параметра и
    возвращает объект, соответствующий ключу.*/

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    /*Этот метод выполняет проверку на полной карте,
    содержит ли она ключ или нет.*/

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}

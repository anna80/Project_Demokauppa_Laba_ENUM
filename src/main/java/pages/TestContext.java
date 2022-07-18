package pages;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private String name;
    private double price;
    private Map<String, Double> textContext;

    public void TextContext(){
        textContext = new HashMap<String, Double>();
    }

    public void setTextContext(final String name, final double price) {
        textContext.put(name, price);
    }

    public Map<String, Double> getTextContext() {
        return textContext;
    }
}

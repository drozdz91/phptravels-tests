package general;

public interface Scenario<Input extends BasePage, Output extends BasePage> {

    Output run(Input entry);
}

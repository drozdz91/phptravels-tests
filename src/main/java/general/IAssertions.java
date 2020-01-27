package general;

public interface IAssertions {

    <G extends BasePage, T extends AbstractAssertions<G>> T check(Class<T> clazz) throws RuntimeException;
}

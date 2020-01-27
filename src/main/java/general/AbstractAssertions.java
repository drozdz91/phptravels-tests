package general;

public abstract class AbstractAssertions<T extends BasePage> {

    protected T page;

    public T endAssertion() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }
}

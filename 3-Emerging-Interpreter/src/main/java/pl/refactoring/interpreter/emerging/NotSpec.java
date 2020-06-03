package pl.refactoring.interpreter.emerging;

public class NotSpec implements Spec {
    private final Spec spec;

    public NotSpec(Spec spec) {
        this.spec = spec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return !spec.isSatisfiedBy(estate);
    }
}

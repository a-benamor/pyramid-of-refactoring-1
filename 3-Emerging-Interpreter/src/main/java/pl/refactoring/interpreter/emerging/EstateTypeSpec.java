package pl.refactoring.interpreter.emerging;

public class EstateTypeSpec implements Spec {
    private EstateType type;

    public EstateTypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
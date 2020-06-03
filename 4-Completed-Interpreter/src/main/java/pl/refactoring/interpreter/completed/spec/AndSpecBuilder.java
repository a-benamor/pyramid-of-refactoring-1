package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.Spec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndSpecBuilder {
    private List<Spec> specs = new ArrayList<>();

    public AndSpecBuilder and(Spec spec) {
        this.specs.add(spec);
        return this;
    }

    public AndSpec build() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}
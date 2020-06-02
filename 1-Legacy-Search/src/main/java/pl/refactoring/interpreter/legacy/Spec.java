package pl.refactoring.interpreter.legacy;

import pl.refactoring.interpreter.legacy.RealEstate;

/**
 * @author abenamor on 02/06/2020
 */
public interface Spec {
    boolean isSatisfiedBy(RealEstate estate);
}

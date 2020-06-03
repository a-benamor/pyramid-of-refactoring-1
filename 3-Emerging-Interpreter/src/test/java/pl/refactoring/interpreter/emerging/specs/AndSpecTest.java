package pl.refactoring.interpreter.emerging.specs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.refactoring.interpreter.emerging.RealEstate;
import pl.refactoring.interpreter.emerging.Spec;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author abenamor on 03/06/2020
 */
class AndSpecTest {

    private Spec yesSpec;

    @BeforeEach
    void setUp() {
        yesSpec = Mockito.mock(Spec.class);

        Mockito.when(yesSpec.isSatisfiedBy(Mockito.any(RealEstate.class)))
                .thenReturn(true);
    }

    @Test
    void shouldVerifyTwoComponentsInCaseOfYesResult() {
        // Given
        AndSpec andSpec = new AndSpec(yesSpec, yesSpec);

        // when
        boolean andResult = andSpec.isSatisfiedBy(Mockito.mock(RealEstate.class));

        // Then
        Mockito.verify(yesSpec, Mockito.times(2))
                .isSatisfiedBy(Mockito.any(RealEstate.class));

        Assertions.assertTrue(andResult);

    }

    @Test
    void shouldVerifyThreeComponentsInCaseOfYesResult() {
        // Given
        AndSpec andSpec = new AndSpec(yesSpec, yesSpec, yesSpec);

        // when
        boolean andResult = andSpec.isSatisfiedBy(Mockito.mock(RealEstate.class));

        // Then
        Mockito.verify(yesSpec, Mockito.times(3))
                .isSatisfiedBy(Mockito.any(RealEstate.class));

        Assertions.assertTrue(andResult);

    }

}
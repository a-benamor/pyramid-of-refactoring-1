package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.EstateMaterial;
import pl.refactoring.interpreter.completed.EstatePlacement;
import pl.refactoring.interpreter.completed.EstateType;
import pl.refactoring.interpreter.completed.Spec;

/**
 * @author abenamor on 03/06/2020
 */
public class Specs {

    public static AreaRangeSpec createAreaRangeSpec(float minArea, float maxArea) {
        return new AreaRangeSpec(minArea, maxArea);
    }


    public static BelowAreaSpec belowArea(float maxBuildingArea) {
        return new BelowAreaSpec(maxBuildingArea);
    }

    public static MaterialSpec createMaterialSpec(EstateMaterial material) {
        return new MaterialSpec(material);
    }

    public static NotSpec createNotSpec(Spec spec) {
        return new NotSpec(spec);
    }

    public static PlacementSpec createPlacementSpec(EstatePlacement placement) {
        return new PlacementSpec(placement);
    }

    public static TypeSpec createTypeSpec(EstateType type) {
        return new TypeSpec(type);
    }
}

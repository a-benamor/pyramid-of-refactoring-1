/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed;

import pl.refactoring.interpreter.completed.spec.AndSpecBuilder;
import pl.refactoring.interpreter.completed.spec.Specs;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static pl.refactoring.interpreter.completed.spec.Specs.createAreaRangeSpec;
import static pl.refactoring.interpreter.completed.spec.Specs.createTypeSpec;

public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> bySpec(Predicate<RealEstate> spec) {
        return repository.stream()
                .filter(spec::test)
                .collect(Collectors.toList());
    }

    @Deprecated
    public List<RealEstate> byBelowArea(float maxBuildingArea){
        return bySpec(Specs.belowArea(maxBuildingArea));
    }

    @Deprecated
    public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(Specs.createMaterialSpec(material));
    }

    @Deprecated
    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        return bySpec(new AndSpecBuilder().and(Specs.createMaterialSpec(material))
                .and(Specs.belowArea(maxBuildingArea)).build());
    }

    @Deprecated
    public List<RealEstate> byPlacement(EstatePlacement placement){
        return bySpec(Specs.createPlacementSpec(placement));
    }

    @Deprecated
    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        return bySpec(Specs.createNotSpec(Specs.createPlacementSpec(placement)));
    }

    @Deprecated
    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        return bySpec(createAreaRangeSpec(minArea, maxArea));
    }

    @Deprecated
    public List<RealEstate> byType(EstateType type){
        return bySpec(createTypeSpec(type));
    }

    @Deprecated
    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material){

        return bySpec(new AndSpecBuilder().and(createTypeSpec(type))
                .and(Specs.createPlacementSpec(placement))
                .and(Specs.createMaterialSpec(material)).build());
    }

}

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.emerging;

import pl.refactoring.interpreter.emerging.specs.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea){
        return bySpec(new BelowAreaSpec(maxBuildingArea));
    }

    public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(new MaterialSpec(material));

    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        Spec materialSpec = new MaterialSpec(material);
        Spec belowAreaSpec = new BelowAreaSpec(maxBuildingArea);

        return bySpec(new AndSpec(materialSpec, belowAreaSpec));
    }

    public List<RealEstate> byPlacement(EstatePlacement placement){
        return bySpec(new PlacementSpec(placement));
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        return bySpec(new NotSpec(new PlacementSpec(placement)));
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        return bySpec(new AreaRangeSpec(minArea,maxArea));
    }

    public List<RealEstate> byType(EstateType type){
        return  bySpec(new EstateTypeSpec(type));
    }

    public List<RealEstate> byEstateTypeAndPlacementAndMaterial(EstateType type, EstatePlacement placement, EstateMaterial material){

        Spec andSpec = new AndSpec(new EstateTypeSpec(type), new PlacementSpec(placement),
                new MaterialSpec(material));

        return bySpec(andSpec);
    }

}

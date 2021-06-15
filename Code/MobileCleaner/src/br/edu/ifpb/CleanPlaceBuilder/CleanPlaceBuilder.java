package br.edu.ifpb.CleanPlaceBuilder;

import br.edu.ifpb.Model.CleanPlace.CleanPlace;

public class CleanPlaceBuilder implements ICleanPlaceBuilder {

    private String name;
    private String sector;

    @Override
    public ICleanPlaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ICleanPlaceBuilder setSector(String sector) {
        this.sector = sector;
        return this;
    }

    @Override
    public CleanPlace builder() {
        CleanPlace cleanPlace = new CleanPlace(this.name, this.sector);
        return cleanPlace;
    }
}

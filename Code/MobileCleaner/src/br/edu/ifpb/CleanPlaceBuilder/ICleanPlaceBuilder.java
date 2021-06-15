package br.edu.ifpb.CleanPlaceBuilder;

import br.edu.ifpb.Model.CleanPlace.CleanPlace;

public interface ICleanPlaceBuilder {

    public ICleanPlaceBuilder setName(String name);
    public ICleanPlaceBuilder setSector(String sector);

    public CleanPlace builder();

}

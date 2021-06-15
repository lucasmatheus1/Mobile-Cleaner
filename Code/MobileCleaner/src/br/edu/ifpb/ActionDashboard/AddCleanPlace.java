package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.CleanPlace.CleanPlace;
import br.edu.ifpb.Model.CleanPlace.CleanPlaceManager;

public class AddCleanPlace {

    CleanPlaceManager cleanPlaceManager;

    public AddCleanPlace(CleanPlaceManager cleanPlaceManager) {
        this.cleanPlaceManager = cleanPlaceManager;
    }


    public boolean add(CleanPlace cleanPlace) {
        return this.cleanPlaceManager.addPlace(cleanPlace);
    }

}

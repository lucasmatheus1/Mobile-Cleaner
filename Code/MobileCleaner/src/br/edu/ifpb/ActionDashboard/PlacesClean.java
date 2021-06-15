package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.CleanPlace.CleanPlace;
import br.edu.ifpb.Model.CleanPlace.CleanPlaceManager;

import java.util.List;

public class PlacesClean {

    CleanPlaceManager cleanPlaceManager;

    public PlacesClean(CleanPlaceManager cleanPlaceManager) {
        this.cleanPlaceManager = cleanPlaceManager;
    }

    public List<CleanPlace> show() {
        return this.cleanPlaceManager.getCleanPlaceList();
    }
}

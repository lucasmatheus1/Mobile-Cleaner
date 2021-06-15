package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.ActionDashboard.CleaningTipsStrategy.CleaningTipsStrategy;
import br.edu.ifpb.ActionDashboard.Proxy.AddAdmin;
import br.edu.ifpb.Model.CleanPlace.CleanPlaceManager;
import br.edu.ifpb.Model.User.UserManager;

public class ActionDashboardFacade implements IActionDashboard{

    UserManager userManager;

    public ActionDashboardFacade(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserList showUserList(UserManager userManager) {
        return new UserList(userManager);
    }

    @Override
    public SendMessage sendMessage(UserManager userManager) {
        return new SendMessage(userManager);
    }

    @Override
    public ListUserBehind listUserBehind(UserManager userManager) {
        return new ListUserBehind(userManager);
    }

    @Override
    public CleanUp cleanUp(UserManager userManager) {
        return new CleanUp(userManager);
    }

    @Override
    public DateNextClean dateNextClean(UserManager userManager) {
        return new DateNextClean(this.userManager);
    }

    @Override
    public VerifyNotification verifyNotification(UserManager userManager) {
        return new VerifyNotification(userManager);
    }

    @Override
    public PlacesClean placesClean(CleanPlaceManager cleanPlaceManager) {
        return new PlacesClean(cleanPlaceManager);
    }

    @Override
    public AddCleanPlace addCleanPlace(CleanPlaceManager cleanPlaceManager) {
        return new AddCleanPlace(cleanPlaceManager);
    }

    @Override
    public AddAdmin addAdmin(UserManager userManager) {
        return new AddAdmin(this.userManager);
    }

    @Override
    public CleaningTipsStrategy cleaningTips(String modelSmartphone) {
        return new CleaningTipsStrategy(modelSmartphone);
    }
}

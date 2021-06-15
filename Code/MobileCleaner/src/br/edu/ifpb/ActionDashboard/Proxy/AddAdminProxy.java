package br.edu.ifpb.ActionDashboard.Proxy;


import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;


public class AddAdminProxy extends AddAdmin{

    protected String codigoAdmin;

    public AddAdminProxy(UserManager userManager, String codigoAdmin) {
        super(userManager);
        this.codigoAdmin = codigoAdmin;
    }

    @Override
    public boolean enter(User user) {
        if (temPermissao()){
            user.setPermission("admin");
            return super.enter(user);
        } else {
            return false;
        }

    }

    private boolean temPermissao() {
        return this.codigoAdmin.equals("PP100");
    }
}

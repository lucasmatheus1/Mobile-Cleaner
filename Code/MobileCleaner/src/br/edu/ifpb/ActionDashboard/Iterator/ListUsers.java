package br.edu.ifpb.ActionDashboard.Iterator;

import br.edu.ifpb.Model.User.User;

import java.util.List;

public class ListUsers implements IteratorList{

    List<User> list;
    int position = 0;

    public ListUsers(List<User> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.size() || list.get(position) == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Object next() {
        User user = list.get(position);
        position++;
        return user;
    }
}

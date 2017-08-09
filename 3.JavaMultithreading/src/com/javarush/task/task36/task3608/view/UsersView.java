package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:"
        );
        for (User user : modelData.getUsers()) {
            stringBuilder.append("\n\t").append(user.toString());
        }
        stringBuilder.append("\n===================================================");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}

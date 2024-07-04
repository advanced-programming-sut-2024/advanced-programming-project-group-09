package Sample.Network.Client.controller.UserControllers;

import Sample.Model.User;

public class AvatarController {
    private final User currentUser;

    public AvatarController(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setAvatar(String avatarPath){
        currentUser.setAvatarPath(avatarPath);
    }
}

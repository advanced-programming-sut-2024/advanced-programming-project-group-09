module approj1 {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.controls;
    requires java.base;
    requires com.google.gson;
    requires jjwt.api;
    requires javafx.swing;
    requires de.jensd.fx.glyphs.fontawesome;
//    requires javafx.Controls;
//    requires javafx.fxml;
//    requires javafx.media;

    exports Sample.Network.Client.view;
    opens Sample.Network.Client.view to javafx.fxml;
    exports Sample.Network.Client.controller.UserAndGameControllers;
    opens Sample.Network.Client.controller.UserAndGameControllers to javafx.fxml;
    opens Sample.Network.Client.model to com.google.gson, javafx.base;
    opens Sample.Network.Client.CardEnums to com.google.gson;

    exports Sample.Network.Client.model;
    exports Sample.Network.Client.controller.UserAndGameControllers.ChooseCard;
    opens Sample.Network.Client.controller.UserAndGameControllers.ChooseCard to javafx.fxml;
    exports Sample.Network.Client.view.UserAndGameMenus.ChooseCard;
    opens Sample.Network.Client.view.UserAndGameMenus.ChooseCard to javafx.fxml;

// the new ones down below, some of which may be deleted later!

    exports Sample.Network.Client.model.Television to  com.google.gson;
    opens Sample.Network.Client.model.Television to javafx.fxml;
    opens Sample.Network.Client to com.google.gson;
    opens Sample.Network.Client.model.User to com.google.gson, javafx.fxml;
    opens Sample.Network.Client.utils to com.google.gson;
//    opens Sample.Network.Client.controller.UserAndGameControllers to com.google.gson;
    opens Sample.Network.Client.model.chatRoom to com.google.gson;
    opens Sample.Network.Client.view.UserAndGameMenus to javafx.fxml;

    exports Sample.Network.Client.view.UserAndGameMenus;
    exports Sample.Network.Client.view.ChatMenus;
    exports Sample.Network.Client.model.User;
    exports Sample.Network.Client.model.chatRoom;
    exports Sample.Network.Client.utils;
    exports Sample.Network.Client.controller.ChatControllers;
    opens Sample.Network.Client.model.Lobby to com.google.gson;
    exports Sample.Network.Client.view.LobbyMenus;
    opens Sample.Network.Client.view.LobbyMenus to javafx.fxml;
}
module approj1 {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.controls;
    requires java.base;
    requires com.google.gson;
//    requires javafx.Controls;
//    requires javafx.fxml;
//    requires javafx.media;

    exports Sample.View;
    opens Sample.View to javafx.fxml;
    exports Sample.Controller;
    opens Sample.Controller to javafx.fxml;
    opens Sample.Model to com.google.gson, javafx.base;
    opens Sample.CardEnums to com.google.gson;

    exports Sample.Model;
    exports Sample.Controller.ChooseCard;
    opens Sample.Controller.ChooseCard to javafx.fxml;
    exports Sample.View.ChooseCard;
    opens Sample.View.ChooseCard to javafx.fxml;
}
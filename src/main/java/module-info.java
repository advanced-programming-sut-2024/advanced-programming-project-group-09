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
    opens Sample.Model to javafx.base;

    exports Sample.Model;
}
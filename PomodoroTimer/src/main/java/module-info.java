module com.example.pomodorotimer {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.pomodorotimer to javafx.fxml;
    exports com.example.pomodorotimer;
}
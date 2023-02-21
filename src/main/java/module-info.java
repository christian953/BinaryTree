module com.example.binarytree {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binarytree to javafx.fxml;
    exports com.example.binarytree;
}
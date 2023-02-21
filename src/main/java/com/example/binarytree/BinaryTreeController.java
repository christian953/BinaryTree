package com.example.binarytree;

import com.example.binarytree.modelclasses.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BinaryTreeController {

    public TextField termInputTextField;
    public Canvas binaryTreeCanvas;
    private GraphicsContext graphicsContext;

    Operator testRoot = new Divide(new Value(5f), new Multiply(new Value(5f), new Value(6f)));

    @FXML
    private void initialize(){
        graphicsContext = binaryTreeCanvas.getGraphicsContext2D();
        drawBinaryTree(testRoot, 200, 100);
    }
    private void drawBinaryTree(Operator root, double xCoordinate, double yCoordinate) {
        drawNodes(root, xCoordinate, yCoordinate, 0);
    }

    private void drawNodes(Node node, double x, double y, int depth) {
        if(node instanceof  Operator){
            double xSpaceBetweenNodes = depth * 20;
            double ySpaceBetweenNodes = 20;
            depth +=1;
            drawNodes(((Operator) node).getLeftValue(),x, y, depth);
            drawNodes(((Operator) node).getRightValue(), x + xSpaceBetweenNodes, y, depth);
            graphicsContext.strokeText(getNodeText(node),  x + xSpaceBetweenNodes / 2,y + 20, depth);
        }
        else {
            System.out.println(getNodeText(node));
            graphicsContext.strokeText(getNodeText(node), x, y);
        }
    }



    private String getNodeText(Node node) {
        if(node instanceof Operator){
            return getOperatorNodeText((Operator) node);
        }
        else{
            return Double.toString(node.getValue());
        }
    }

    private String getOperatorNodeText(Operator operator) {
        if(operator instanceof Add){
            return "+";
        }
        if(operator instanceof Subtract){
            return "-";
        }
        if(operator instanceof Multiply){
            return "*";
        }
        if(operator instanceof Divide){
            return ":";
        }
        if(operator instanceof Power){
            return "*";
        }
        return null;
    }

    private void getDepth(Node node){
    }
}

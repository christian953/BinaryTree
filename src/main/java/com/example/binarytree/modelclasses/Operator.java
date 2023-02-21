package com.example.binarytree.modelclasses;

public abstract class Operator implements Node{
    protected final Node leftValue;
    protected final Node rightValue;

    public Node getLeftValue() {
        return leftValue;
    }

    public Node getRightValue() {
        return rightValue;
    }

    public Operator(Node leftValue, Node rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }
        }



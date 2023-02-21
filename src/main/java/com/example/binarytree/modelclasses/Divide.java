package com.example.binarytree.modelclasses;

public class Divide extends Operator {
    public Divide(Node leftValue, Node rightValue){
        super(leftValue, rightValue);
    }
    @Override
    public double getValue() {
        return this.leftValue.getValue() / this.rightValue.getValue();
    }
}

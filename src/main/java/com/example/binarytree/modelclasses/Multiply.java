package com.example.binarytree.modelclasses;

public class Multiply extends Operator {
    public Multiply(Node leftValue, Node rightValue){
        super(leftValue, rightValue);
    }
    @Override
    public double getValue() {
        return this.leftValue.getValue() * this.rightValue.getValue();
    }
}

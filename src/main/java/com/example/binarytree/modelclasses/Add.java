package com.example.binarytree.modelclasses;

public class Add extends Operator {
    public Add(Node leftValue, Node rightValue){
        super(leftValue, rightValue);
    }
    @Override
    public double getValue() {
        return this.leftValue.getValue() + this.rightValue.getValue();
    }
}

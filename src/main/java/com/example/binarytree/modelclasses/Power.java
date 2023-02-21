package com.example.binarytree.modelclasses;

import java.lang.Math;
public class Power extends Operator {
    public Power(Node leftValue, Node rightValue){
        super(leftValue, rightValue);
    }
    @Override
    public double getValue() {
        return Math.pow(this.leftValue.getValue(), this.rightValue.getValue());
    }
}

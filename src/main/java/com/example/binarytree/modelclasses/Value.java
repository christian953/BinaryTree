package com.example.binarytree.modelclasses;

public class Value implements Node{
    private final float value;
    public Value(float value){
        this.value = value;
    }
    @Override
    public double getValue() {
        return value;
    }

}

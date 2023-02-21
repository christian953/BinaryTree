package com.example.binarytree.modelclasses;

import java.util.*;

public class TermParser {
    private final char[] operators = {'+', '-', '*', '/', '^'};
    private final char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public Node parse(String term){

        term = term.replace(" ", "");
        for(int i = 0; i < term.length(); i++) {
            if(term.charAt(i) == '*' || term.charAt(i) == '/' || term.charAt(i) == '+'||term.charAt(i) == '-' || term.charAt(i) == '^' || term.charAt(i) == '(' || term.charAt(i) == ')'){
                term = term.substring(0,i) + ' ' +term.charAt(i) + ' ' + term.substring(i+1);
                i += 2;
            }

        }
        String[] termArray = term.split(" +");
        ArrayList<String> termArrayList = new ArrayList<String>(Arrays.asList(termArray));
        ArrayList<String> newTermArrayList = new ArrayList<>();
        for(int i = 0; i < termArrayList.size(); i++){
            if( i == 0 && Objects.equals(termArrayList.get(0), "-")){
                newTermArrayList.add(termArrayList.get(i) + termArrayList.get(i+1));
            }
            else if (i == 0) {
                ;newTermArrayList.add(termArrayList.get(i));
            }
            else {
                if ((Objects.equals(termArrayList.get(i - 1), "+") | Objects.equals(termArrayList.get(i - 1), "-") | Objects.equals(termArrayList.get(i - 1), "*") | Objects.equals(termArrayList.get(i - 1), "/") | Objects.equals(termArrayList.get(i - 1), "^") && termArrayList.get(i).equals("-"))) {
                    newTermArrayList.add(termArrayList.get(i) + termArrayList.get(i+1));
                    i += 1;
                }
                else {
                    newTermArrayList.add(termArrayList.get(i));
                }
        }}
        termArrayList = newTermArrayList;
        //
        Stack<String> outputStack = new Stack<String>();
        Stack<String> operatorStack = new Stack<String>();
        for (String s : termArrayList) {
            if (isNumber(s)) {
                outputStack.add(s);
                continue;
            } else if (isOperator(s)) {
                while (!operatorStack.isEmpty() && !isRightAssociative(s) &
                        getPrecedence(s) <= getPrecedence(operatorStack.peek())
                        | isRightAssociative(s) & getPrecedence(s) < getPrecedence(operatorStack.peek())) {
                    outputStack.add(operatorStack.pop());
                }
                operatorStack.add(s);
            }
        }
        while (!operatorStack.isEmpty()){
            outputStack.add(operatorStack.pop());
        }
        return createTree(outputStack);
    }
    private Node createTree(Stack<String> postfixTerm){
        Node root = null;
        Node node1;
        Node node2;
        System.out.println(postfixTerm);
        String op = postfixTerm.pop();
        if(isOperator(postfixTerm.peek())){
             node1 = createTree(postfixTerm);
        }
        else{
             node1 = new Value(Float.parseFloat(postfixTerm.pop()));
        }
        if(isOperator(postfixTerm.peek())){
             node2 = createTree(postfixTerm);
        }
        else{
             node2 = new Value(Float.parseFloat(postfixTerm.pop()));
        }
        switch (op) {
            case "+":
                root = new Add(node1, node2);
                break;
            case "-":
                root = new Subtract(node1, node2);
                break;
            case "*":
                root = new Multiply(node1, node2);
                break;
            case "/":
                root = new Divide(node1, node2);
                break;
            case "^":
                root = new Power(node1, node2);
                break;
        }
        return root;
    }
    private static boolean isNumber(String stringToBeChecked){
        try {
            Integer.parseInt(stringToBeChecked);
            return true;}

        catch (NumberFormatException a){
            return false;
        }
    }
    private static int getPrecedence(String operator){
        if(Objects.equals(operator, "+") | Objects.equals(operator, "-")){
            return 0;
        }
        if(Objects.equals(operator, "/") | Objects.equals(operator, "*")){
            return 5;
        }
        if(Objects.equals(operator, "^")){
            return 10;
        }
        else return -1;
    }
    private static boolean isOperator(String stringToBeChecked){
        return stringToBeChecked.equals("+") | stringToBeChecked.equals("-") | stringToBeChecked.equals("*") | stringToBeChecked.equals("/") | stringToBeChecked.equals("^");

    }
    private static boolean isRightAssociative(String operator){
        return operator.equals("^");
    }
}

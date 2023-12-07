package dev.kailas.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaConcept {


    /*
     Lambda Concept:

     Lambda expressions are anonymous functions.
     Lambda expressions basically express instance of functional interface.
     Note: Lambda expressions are just like functions and they accept parameters just like functions.

     */

    /*
    Scope of a Lambda Expression:
    - The body of lambda expression has same scope as a nested block.
    - The same rule for name conflict and shadowing applies.
    - It is illegal to declare parameter or local variable in the lambda
      that has the same name as Local variable.
    // See below Comparator example in localVariableScope() method, if you update
    // f1 variable name to first compile will not happy :)
    // Compiler will say, Variable 'first' is already defined in the scope
    Variable used in lambda expression should be final or effectively final
    */
    public void localVariableScope(){
        int first = 10 ;
        Comparator<String> comparator = (f1, second) -> f1.length() - second.length();
    }


    // Scope of a Lambda Expression

    public static void main(String[] args) {
        LambdaConcept lambdaConcept = new LambdaConcept();
        lambdaConcept.lambdaSyntax();
    }
private int variable = 90 ;
    public void lambdaSyntax(){
        int variable = 20 ;
        LambdaConcept instance = new LambdaConcept();
        Runnable consumer = () -> {
           int variable2  = variable + 10 ;
           instance.variable = 100;
           // variable = 30 ;  Variable used in lambda expression should be final or effectively final
        };
        consumer.run();
        /*
        * Note: It is important to emphasize that a lambda expression can use and modify an instance variable from its invoking class.
        * It just can’t use a local variable of its enclosing scope unless that variable is effectively final.
        *
        * */
        System.out.println(variable);
        System.out.println(instance.variable);
    }
}

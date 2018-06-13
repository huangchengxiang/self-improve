package com.aibank.jdk8.functioninterface.optional;

public class Student {

    private Bag bag;

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public static void main (String[] args) {

    }

    public static String getBookName(Student student){
        if(null != student) {

            Bag bag = student.getBag();

            if(null != bag) {

                Book book = bag.getBook();

                if(null != null) {

                    return book.getName();
                }

            }

        }

        return "UnKnown";
    }
}

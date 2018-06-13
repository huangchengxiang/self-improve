package com.aibank.jdk8.functioninterface.optional;

import java.util.Optional;

public class NewStudent {

    private Optional<Bag>  bag;

    public Optional<Bag> getBag() {
        return bag;
    }

    public void setBag(Optional<Bag> bag) {
        this.bag = bag;
    }
}

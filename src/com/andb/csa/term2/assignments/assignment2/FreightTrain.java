package com.andb.csa.term2.assignments.assignment2;

import java.util.ArrayList;

public class FreightTrain {
    /**
     * An ArrayList that stores a train with multiple boxcars
     */
    ArrayList<Boxcar> train = new ArrayList<>();

    /**
     * Default constructor that sets train to an ArrayList holding one
     * boxcar containing 5 gizmos, that is not in repair.
     */
    public FreightTrain() {
        this.train.add(new Boxcar());
    }

    /**
     * A constructor that sets train to an ArrayList of size n, holding
     * n boxcars, that are all hold 5 gizmos and are not in repair. If n <= 0,
     * then the train should be set to size one, with a single boxcar containing
     * 5 gizmos and not in repair.
     *
     * @param n number of cars to add to the train
     */
    public FreightTrain(int n) {
        if (n <= 0) {
            n = 1;
        }
        for (int i = 0; i < n; i++) {
            this.train.add(new Boxcar());
        }
    }

    /**
     * sets the cargo type of all the boxcars in the entire train.
     *
     * @param c type of cargo to set train carrying - one of:
     *          Boxcar.TYPE_GIZMOS,
     *          Boxcar.TYPE_GADGETS,
     *          Boxcar.TYPE_WIDGETS,
     *          Boxcar.TYPE_WADGETS
     */
    public void setCargo(String c) {
        train.forEach(b -> b.setCargo(c));
    }


    /**
     * sets the boxcars to the pattern "gizmos", "gadgets", "widgets",
     * "wadgets", "gizmos", "gadgets", "widgets", "wadgets", ...
     * until the end of the train.
     */
    public void setMultiCargo() {
        String[] cargoTypes = {"gizmos", "gadgets", "widgets", "wadgets"};
        for (int i = 0; i < train.size(); i++) {
            train.get(i).setCargo(cargoTypes[i % 4]);
        }
    }

    /**
     * fills every boxcar in the train to max capacity of 10.
     * Each individual boxcar can only hold cargo if its
     * repair variable is false.
     */
    public void fillTrain() {
        train.forEach(b -> {
            while (!b.isFull()) b.loadCargo();
        });
    }

    /**
     * sets the Boxcar at location i’s repair variable to true.
     *
     * @param i car of train to repair
     */
    void callForRepair(int i) {
        train.get(i).callForRepair();
    }

    /**
     * returns a String representation of the
     * Boxcar objects in the ArrayList, one per line. For example,
     * here is the String returned when toString is called on a
     * FreightTrain with 5 boxcars:
     * <p>
     * 3 gadgets    in service
     * 2 wadgets    in service
     * 0 gizmos    in repair
     * 7 gadgets    in service
     * 0 gadgets    in repair
     * <p>
     * Note: there is one space between the number of units and
     * the cargo type, and a tab between the cargo type and
     * "in repair"/"in service".
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boxcar boxcar : train) {
            sb.append(boxcar.toString()).append("\n");
        }
        return sb.toString();
    }
}

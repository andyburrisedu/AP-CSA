package com.andb.csa.term2.assignments.assignment2;

public class Boxcar {
    public static final String TYPE_GIZMOS = "gizmos";
    public static final String TYPE_GADGETS = "gadgets";
    public static final String TYPE_WIDGETS = "widgets";
    public static final String TYPE_WADGETS = "wadgets";

    /**
     * Variables that will be initialized in the Boxcar constructors.
     */
    private String cargo;
    private int numUnits;
    private boolean repair;

    /**
     * Default constructor that sets the boxcar to "gizmos", 5, and false.
     */
    public Boxcar() {
        this.cargo = TYPE_GIZMOS;
        this.numUnits = 5;
        this.repair = false;
    }

    /**
     * This constructor sets the cargo variable to the parameter c, but only if
     * c is "gizmos", "gadgets", "widgets", or "wadgets". The constructor ignores
     * the case of of the value in c. If c holds any value other than
     * "gizmos", "gadgets", "widgets", or "wadgets", the constructor sets cargo
     * to "gizmos". The numUnits variable is set to the parameter u. If u is less than
     * 0 or higher than the maximum capacity of 10 units, numUnits is set to 0. The repair
     * variable is set to the parameter r. If repair is true, numUnits is set to 0
     * no matter what value is stored in the u parameter.
     */
    public Boxcar(String cargo, int numUnits, boolean repair) {
        setCargo(cargo);
        this.repair = repair;
        if (repair || numUnits > 10 || numUnits < 0) {
            this.numUnits = 0;
        } else {
            this.numUnits = numUnits;
        }
    }

    /**
     * This method adds 1 to the number of units in the BoxCar. The maximum
     * capacity of a boxcar is 10 units. If increasing the number of units
     * would go beyond the maximum, keep numUnits at the max capacity.
     * If the repair variable is true, then numUnits may only be set to 0.
     */
    public void loadCargo() {
        if (!repair && numUnits < 10) {
            numUnits++;
        }
    }

    /**
     * The getCargo method returns the cargo of the boxcar.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * The setCargo method sets the cargo type of the boxcar. The cargo variable is
     * set to c only if c is "gizmos", "gadgets", "widgets", or "wadgets".
     * The method ignores the case of of the value in c. If c holds any value other than
     * "gizmos", "gadgets", "widgets", or "wadgets" (ignoring case), the method sets cargo
     * to "gizmos".
     */
    void setCargo(String cargo) {
        cargo = cargo.toLowerCase();
        if (cargo.equals(TYPE_GIZMOS) || cargo.equals(TYPE_GADGETS) || cargo.equals(TYPE_WIDGETS) || cargo.equals(TYPE_WADGETS)) {
            this.cargo = cargo.toLowerCase();
        } else {
            this.cargo = TYPE_GIZMOS;
        }
    }

    /**
     * The isFull method returns true if numUnits is equal to 10, false otherwise.
     */
    boolean isFull() {
        return numUnits == 10;
    }

    /**
     * The callForRepair method sets the variable repair to true, and numUnits to 0.
     */
    void callForRepair() {
        repair = true;
        numUnits = 0;
    }

    /**
     * Gets a string representation of the repair status - either "in repair" or "in service"
     *
     * @return repair status as string
     */
    private String repairStatus() {
        if (repair) {
            return "in repair";
        } else {
            return "in service";
        }
    }

    /**
     * The toString method returns a String with the Boxcar in the format:
     * 5 gizmos    in service
     * 10 widgets    in service
     * 0 gadgets    in repair
     * <p>
     * Notice there is one space in between the number of units and the cargo
     * and a tab between the value for cargo and "in repair"/"in service"
     */
    @Override
    public String toString() {
        return Integer.toString(numUnits) + " " + cargo + "\t" + repairStatus();
    }
}

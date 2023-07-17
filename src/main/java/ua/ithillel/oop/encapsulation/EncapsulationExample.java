package ua.ithillel.oop.encapsulation;

public class EncapsulationExample {

    public int publicVariable;
    protected int protectedVariable;
    int defaultVariable;
    private int privateVariable;

    protected int getPrivateVariable() {
        return privateVariable;
    }

    protected void setPrivateVariable(int privateVariable) {
        this.privateVariable = privateVariable;
    }

    public void publicMethod() {
    }

    protected void protectedMethod() {
    }

    void defaultMethod() {
    }

    private void privateMethod() {
    }

}

package candidatura.model;

public class Candidate {
    private String name;
    private double note;
    private double intendedSalary;

    private boolean optimalSalaryExpectations = false;

    public Candidate() {
    }

    public Candidate(String name, double note, double intendedSalary) {
        this.name = name;
        this.note = note;
        this.intendedSalary = intendedSalary;
    }

    public void setOptimalSalaryExpectations(boolean optimalSalaryExpectations) {
        this.optimalSalaryExpectations = optimalSalaryExpectations;
    }

    public boolean isOptimalSalaryExpectations() {
        return optimalSalaryExpectations;
    }

    public double getIntendedSalary() {
        return intendedSalary;
    }

    public String getName() {
        return name;
    }

    public double getNote() {
        return note;
    }
}

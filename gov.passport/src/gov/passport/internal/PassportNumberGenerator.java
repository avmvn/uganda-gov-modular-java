package gov.passport.internal;

public class PassportNumberGenerator {

    private int counter = 1000;

    public String next() {
        counter++;
        return "B" + String.format("%07d", counter);
    }
}


public class FizzBuzz {

    public String calculate() {
        String seq = "";

        for (int i=1; i<100; i++) {
            seq += Integer.toString(i) + ",";
        }
        return seq + "100";
    }
}

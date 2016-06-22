
public class FizzBuzz {

    public String calculate() {
        String seq = "";

        for (int i=1; i<100; i++) {
            if (i==3) {
                seq += "fizz,";
            } else {
                seq += Integer.toString(i) + ",";
            }
        }
        return seq + "100";
    }
}

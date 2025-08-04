public class Payload {
    private String index;
    private String data1;
    private String data2;
    private String data3;

    public String[] split(String payload) {
        String[] parts = payload.split(" ");

        if (parts.length == 4) {
            index = parts[0].trim();
            data1 = parts[1].trim();
            data2 = parts[2].trim();
            data3 = parts[3].trim();
        }
        else if (parts.length == 3) {
            data1 = parts[0].trim();
            data2 = parts[1].trim();
            data3 = parts[2].trim();
        }
        else if (parts.length == 1) {
            index = parts[0].trim();
        }
        else {
            throw new IllegalArgumentException("Invalid payload... " +
                    "Add: <data1>, <data2>, <data3> Update: <index>, <data1>," +
                    " <data2>, <data3>, Delete: <index>");
        }
        return parts;
    }

    // Optionally add getters for each field
    public String getIndex() { return index; }
    public String getData1() { return data1; }
    public String getData2() { return data2; }
    public String getData3() { return data3; }

    @Override
    public String toString() {
        return String.join(" ", data1, data2, data3);
    }

}
import java.util.*;

class Location {
    private String city;
    private double longitude;
    private double latitude;

    public Location(String city, double longitude, double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setLogitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLatitude() {
        return latitude;
    }
}

public class P7_2 {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Location> locList = new ArrayList<Location>();

    private void read() {
        System.out.println("도시,경도,위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String text = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(text, ",");
            String city = st.nextToken().trim();
            double longitude = Double.parseDouble(st.nextToken().trim());
            double latitude = Double.parseDouble(st.nextToken().trim());
            Location loc = new Location(city, longitude, latitude);
            locList.add(loc);
        }
    }

    private void printAll() {
        System.out.println("---------------------------");
        for (Location loc : locList) {
            System.out.print(loc.getCity() + "\t");
            System.out.print(loc.getLongitude() + "\t");
            System.out.println(loc.getLatitude());
        }
        System.out.println("---------------------------");
    }

    private void processQuery() {
        while (true) {
            System.out.print("도시 이름 >> ");
            String city = scanner.nextLine();
            if (city.equals("그만"))
                return;

            Location foundLoc = null;
            for (Location loc : locList) {
                if (loc.getCity().equals(city)) {
                    foundLoc = loc;
                    break;
                }
            }
            if (foundLoc == null) {
                System.out.println(city + "는 없습니다.");
            } else {
                System.out.print(foundLoc.getCity() + "\t");
                System.out.print(foundLoc.getLongitude() + "\t");
                System.out.println(foundLoc.getLatitude());
            }
        }
    }

    public void run() {
        read();
        printAll();
        processQuery();
    }

    public static void main(String[] args) {
        P7_2 man = new P7_2();
        man.run();
    }
}

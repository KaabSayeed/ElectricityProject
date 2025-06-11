import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElectricityBoardMain board = new ElectricityBoardMain();
        Map<String, String> map = new LinkedHashMap<>();

        System.out.println("Enter the number of connection records to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the connection records (ConnectionId:Connectiontype)");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(":");
            if (input.length == 2) {
                map.put(input[0], input[1]);
            }
        }

        board.setElectricityMap(map);

       
        System.out.println("Enter the Connection type to be searched");
        String searchType = sc.nextLine();
        int count = board.findCountOfConnectionsBasedOnTheConnectionType(searchType);
        if (count == -1) {
            System.out.println("No Connection Ids were found for " + searchType);
        } else {
            System.out.println("The count of connection Ids based on " + searchType.toUpperCase() + " are " + count);
        }

        
        System.out.println("Enter the Connection type to identify the Connection Ids");
        String filterType = sc.nextLine();
        List<String> ids = board.findConnectionIdsBasedOnTheConnectionType(filterType);
        if (ids.isEmpty()) {
            System.out.println("No Connection Ids were found for the " + filterType);
        } else {
            System.out.println("Connection Ids based on the " + filterType.toUpperCase() + " are");
            for (String id : ids) {
                System.out.println(id);
            }
        }

        sc.close();
    }
}

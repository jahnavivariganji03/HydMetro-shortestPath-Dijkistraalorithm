import java.util.*;

class Main {
    static public void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src, int dest) {
        int[] dist = new int[N];
        for (int i = 0; i < N; i++)
            dist[i] = 1000000000;

        Queue<Integer> q = new LinkedList<>();

        dist[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        String[] stations = { "LBnagar", "Victoria_memorial", "chaitanyapuri", "Dilshukhnagar", "moosrambagh",
                "NewMarket", "malakpet", "MGbusstation", "Osmania_medical", "Gandhibhavan", "Nampally", "Assembly",
                "Lakdikapool", "Khairtabad", "Irrummanzil", "Panjagutta", "Ameerpet", "SRnagar", "ESIhospital",
                "Erragadda", "Bharatnagar", "Moosapet", "DR_BRambedkar", "Kukatpally", "KPHBcolony", "JNTUcollege",
                "Miyapur", "Sultanbazar", "Narayanguda", "Chikkadpali", "RTCxroads", "Musheerabad", "Gandhihospital",
                "Secbadwest", "Paradeground", "Nagole", "Uppal", "stadium", "NGRI", "Habsiguda", "Tarnaka",
                "Mettuguda", "Secbadeast", "Paradise", "Rasoolpura", "PrakashNagar", "Begumpet", "MathuraNagar",
                "Yusufguda", "Jubliehills", "JH-checkpost", "Peddamagudi", "Madhapur", "Dugamcheruvu", "Hitechcity",
                "raidurg" };

        System.out.println("Shortest path from " + stations[src] + " to " + stations[dest] + ":");
        System.out.println(getPath(adj, src, dest, dist, stations));
    }

    static public String getPath(ArrayList<ArrayList<Integer>> adj, int src, int dest, int[] dist, String[] stations) {
        if (dist[dest] == 1000000000) {
            return "No path exists.";
        }

        ArrayList<Integer> path = new ArrayList<>();
        int current = dest;
        path.add(current);

        while (current != src) {
            for (int neighbor : adj.get(current)) {
                if (dist[neighbor] == dist[current] - 1) {
                    path.add(neighbor);
                    current = neighbor;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stations[src]);
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(" -> ").append(stations[path.get(i)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 56;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);

        for (int i = 1; i <= 7; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(8).add(7);
        adj.get(8).add(27);
        adj.get(8).add(9);

        for (int i = 9; i <= 15; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(16).add(15);
        adj.get(16).add(46);
        adj.get(16).add(17);
        adj.get(16).add(47);

        for (int i = 17; i <= 25; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(26).add(25);

        adj.get(27).add(9);
        adj.get(27).add(28);

        for (int i = 28; i <= 33; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(34).add(42);
        adj.get(34).add(33);
        adj.get(34).add(43);

        adj.get(35).add(36);

        for (int i = 36; i <= 41; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(42).add(41);
        adj.get(42).add(34);

        adj.get(43).add(34);
        adj.get(43).add(44);

        for (int i = 44; i <= 54; i++) {
            adj.get(i).add(i - 1);
            adj.get(i).add(i + 1);
        }

        adj.get(55).add(54);

        Scanner sc = new Scanner(System.in);
        
        String[] stations = { "LBnagar", "Victoria_memorial", "chaitanyapuri", "Dilshukhnagar", "moosrambagh",
                "NewMarket", "malakpet", "MGbusstation", "Osmania_medical", "Gandhibhavan", "Nampally", "Assembly",
                "Lakdikapool", "Khairtabad", "Irrummanzil", "Panjagutta", "Ameerpet", "SRnagar", "ESIhospital",
                "Erragadda", "Bharatnagar", "Moosapet", "DR_BRambedkar", "Kukatpally", "KPHBcolony", "JNTUcollege",
                "Miyapur", "Sultanbazar", "Narayanguda", "Chikkadpali", "RTCxroads", "Musheerabad", "Gandhihospital",
                "Secbadwest", "Paradeground", "Nagole", "Uppal", "stadium", "NGRI", "Habsiguda", "Tarnaka",
                "Mettuguda", "Secbadeast", "Paradise", "Rasoolpura", "PrakashNagar", "Begumpet", "MathuraNagar",
                "Yusufguda", "Jubliehills", "JH-checkpost", "Peddamagudi", "Madhapur", "Dugamcheruvu", "Hitechcity",
                "raidurg"};
                
        System.out.println("PLEASE SELECT YOUR SOURCE STATION NUMBER FROM THE BELOW OPTIONS");

        for (int i = 0; i < 56; i++) {
            System.out.println("Enter value " + i + " for " + stations[i] + " Station");
        }

        System.out.println("Enter the source STATION:");
        int src = sc.nextInt(); // Adjust the station index by subtracting 1

        System.out.println("Enter the destination STATION:");
        int dest = sc.nextInt(); // Adjust the station index by subtracting 1

        shortestPath(adj, n, src, dest);

        sc.close();
    }
}

# HydMetro-shortestPath-Dijkistraalorithm
The provided code implements Dijkstra's algorithm to find the shortest path between 
two stations in a transportation network. It uses an adjacency list to represent the 
network and calculates the shortest distances from the source station to all other stations. 
The code then retrieves the shortest path using the calculated distances and prints it as output. 
The main method prompts the user to select the source and destination stations, and the shortest path is displayed.

The Dij class contains the main logic for finding the shortest path.
The shortestPath method takes an adjacency list representing the transportation network, the number of stations, source station index, and destination station index as inputs.
It initializes an array dist to store the shortest distances from the source station to all other stations. The initial value for each station is set to a large value (1000000000).
It uses a queue q to perform breadth-first search (BFS) traversal of the network starting from the source station.
The BFS traversal updates the shortest distances in the dist array. If a shorter path is found, the distance is updated and the station is added to the queue for further exploration.
The getPath method is used to retrieve the shortest path from the source station to the destination station based on the dist array and the adjacency list.
The getPath method starts from the destination station and iteratively finds the previous station in the shortest path until it reaches the source station.
The path is stored in an ArrayList and then converted into a string representation using the stations array, which contains the names of all the stations.
The main method is responsible for inputting the source and destination stations from the user and calling the shortestPath method.
It creates the adjacency list adj representing the transportation network.
It initializes a Scanner object to read input from the user.
It prompts the user to select the source station by entering a corresponding value.
It prompts the user to select the destination station by entering a corresponding value.
It calls the shortestPath method with the provided arguments.
The shortest path from the source station to the destination station is printed as output.

package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Tunnel implements Comparable<Tunnel>{
    private int cost;
    private int planetA;
    private int planetB;

    public Tunnel(int cost, int planetA, int planetB) {
        this.cost = cost;
        this.planetA = planetA;
        this.planetB = planetB;
    }

    public int getCost() {
        return cost;
    }

    public int getPlanetA() {
        return planetA;
    }

    public int getPlanetB() {
        return planetB;
    }

    @Override
    public int compareTo(Tunnel o) {
        if (this.cost > o.getCost()){
            return 1;
        }
        return -1;
    }
}

class Planet{
    private int x;
    private int y;
    private int z;

    public Planet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
public class ch18_4 {

    static int[] parent;

    static int find(int n){
        if (parent[n] != n){
            return parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        ArrayList<Planet> planets = new ArrayList<>();
        int x, y, z;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(x, y, z));
        }

        ArrayList<Tunnel> tunnels = new ArrayList<>();
        int a,b,c,min;
        for (int i = 0; i < n; i++) {
            Planet planetA = planets.get(i);
            for (int j = i+1; j < n; j++) {
                Planet planetB = planets.get(j);
                a = Math.abs(planetA.getX() - planetB.getX());
                b = Math.abs(planetA.getY() - planetB.getY());
                c = Math.abs(planetA.getZ() - planetB.getZ());
                min = Math.min(a, Math.min(b, c));
                tunnels.add(new Tunnel(min, i, j));
            }
        }

        Collections.sort(tunnels);

        int result = 0;
        for (int i = 0; i < tunnels.size(); i++) {
            Tunnel minT = tunnels.get(i);
            if (find(minT.getPlanetA()) == find(minT.getPlanetB())) continue;
            union(minT.getPlanetA(), minT.getPlanetB());
            result += minT.getCost();
        }
        System.out.println(result);
    }
}

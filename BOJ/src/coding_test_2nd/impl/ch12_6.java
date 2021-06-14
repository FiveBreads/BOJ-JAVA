package coding_test_2nd.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


class Structure implements Comparable<Structure>{
    private int x;
    private int y;
    private int type;

    public Structure(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Structure structure = (Structure) o;
        return x == structure.x && y == structure.y && type == structure.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, type);
    }

    @Override
    public int compareTo(Structure o) {
        if (this.getX() == o.getX()){
            if (this.getY() == o.getY()){
                return Integer.compare(this.type, o.type);
            }
            return Integer.compare(this.y, o.y);
        }
        return Integer.compare(this.x, o.x);
    }
}
public class ch12_6 {

    static ArrayList<Structure> map = new ArrayList<>();

    static boolean checkBuild(Structure structure){
        if (structure.getType() == 0){
            return checkPillar(structure);
        }else {
            return checkBo(structure);
        }
    }

    static boolean checkPillar(Structure structure){
        if(
            structure.getY() == 0
            || map.contains(new Structure(structure.getX(), structure.getY() - 1, structure.getType()))
            || map.contains(new Structure(structure.getX() - 1, structure.getY(), 1))
            || map.contains(new Structure(structure.getX(), structure.getY(), 1))
        ) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean checkBo(Structure structure){
        if (map.contains(new Structure(structure.getX(), structure.getY() - 1, 0))
            || map.contains(new Structure(structure.getX() + 1, structure.getY() - 1, 0))
        ){
           return true;
        }
        if (map.contains(new Structure(structure.getX() + 1, structure.getY(), structure.getType()))
            && map.contains(new Structure(structure.getX() - 1, structure.getY(), structure.getType()))
        ){
            return true;
        }
        return false;
    }


    public static int[][] solution(int n, int[][] build_frame){
        for (int i = 0; i < build_frame.length; i++) {
            Structure structure = new Structure(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
            if (build_frame[i][3] == 1){ //생성
                if (checkBuild(structure)){
                    map.add(structure);
                }
            }else{ //제거
                map.remove(structure);
                for (int j = 0; j < map.size(); j++) {
                    if (!checkBuild(map.get(j))) {
                        map.add(structure);
                        break;
                    }
                }
            }
        }
        Collections.sort(map);
        int [][] result = new int[map.size()][3];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = map.get(i).getX();
            result[i][1] = map.get(i).getY();
            result[i][2] = map.get(i).getType();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        /*{
            {1,0,0,1},
            {1,1,1,1},
            {2,1,0,1},
            {2,2,1,1},
            {5,0,0,1},
            {5,1,0,1},
            {4,2,1,1},
            {3,2,1,1}
        };*/
        int[][] result = solution(n, build_frame);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

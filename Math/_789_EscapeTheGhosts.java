package Math;

public class _789_EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int base = getDistance(new int[]{0, 0}, target);
        for(int[] ghost : ghosts){
            int temp = getDistance(ghost, target);
            if(temp <= base)return false;
        }
        return true;
    }

    public int getDistance(int[] start, int[] target){
        return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
    }
}

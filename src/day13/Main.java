package day13;

import com.mysql.cj.protocol.a.NativeConstants;

import java.util.*;

/**
 * @author zhougy
 * @create 2022-03-02 8:40
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(triangle.get(0).get(0));
        lists.add(list1);
        if (triangle.size() == 1)
            return lists.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) {
                    list.add(triangle.get(i).get(j) + lists.get(i - 1).get(lists.get(i - 1).size() - 1));
                } else if (j == 0) {
                    list.add(triangle.get(i).get(j) + lists.get(i - 1).get(j));
                } else {
                    list.add(Math.min(triangle.get(i).get(j) + lists.get(i - 1).get(j), triangle.get(i).get(j) + lists.get(i - 1).get(j - 1)));
                }
                if (i == triangle.size() - 1 && list.get(list.size() - 1) < min) {
                    min = list.get(list.size() - 1);
                }
            }
            lists.add(list);
        }
        return min;
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] new_grid = new int[grid.length][grid[0].length];
        int countOf1 = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    new_grid[i][j] = 0;
                } else {
                    new_grid[i][j] = -1;
                }
                if (grid[i][j] == 1)
                    countOf1++;
            }
        }
        int[][] a = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            for (int i = 0; i < a.length; i++) {
                int new_x = x + a[i][0];
                int new_y = y + a[i][1];
                if (new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length && grid[new_x][new_y] == 1) {
                    countOf1--;
                    grid[new_x][new_y] = 2;
                    new_grid[new_x][new_y] = new_grid[x][y] + 1;
                    queue.add(new int[]{new_x, new_y});
                    if (new_grid[new_x][new_y] > count)
                        count = new_grid[new_x][new_y];
                }
            }
        }
        return countOf1 == 0 ? count : -1;
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] new_matrix = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                new_matrix[i][j] = Integer.MAX_VALUE - 100000;
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int x = 0;
        int y = 0;
        int[][] a = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.poll()[1];
            if (mat[x][y] == 0) {
                new_matrix[x][y] = 0;
                for (int i = 0; i < a.length; i++) {
                    int dx = a[i][0];
                    int dy = a[i][1];
                    int new_x = x + dx;
                    int new_y = y + dy;
                    if (new_x < mat.length && new_x >= 0 && new_y < mat[0].length && new_y >= 0 && mat[new_x][new_y] != 0) {
                        new_matrix[new_x][new_y] = 1;
                        queue.add(new int[]{new_x, new_y});
                    }
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                    int dx = a[i][0];
                    int dy = a[i][1];
                    int new_x = x + dx;
                    int new_y = y + dy;
                    if (new_x < mat.length && new_x >= 0 && new_y < mat[0].length && new_y >= 0 && mat[new_x][new_y] != 0) {
                        if (new_matrix[new_x][new_y] > new_matrix[x][y] + 1) {
                            new_matrix[new_x][new_y] = new_matrix[x][y] + 1;
                            queue.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        }
        return new_matrix;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char i : magazine.toCharArray()) {
            chars[i - 'a']++;
        }
        for (char i : ransomNote.toCharArray()) {
            chars[i - 'a']--;
        }
        for (int i : chars) {
            if (i < 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(chars1, chars2);
    }

    public static int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

}

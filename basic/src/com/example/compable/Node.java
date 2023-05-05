package com.example.compable;

public class Node implements Comparable<Node>{

    private String name;

    public String getName() {
        return name;
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node node) {
        String s1 = getName();
        String s2 = node.getName();

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        /** 한글, 영어, 숫자 순서로 정렬 */
        if (Character.getType(c1) != Character.getType(c2)) {
            if (Character.getType(c1) == Character.OTHER_LETTER) {
                return -1;
            } else if (Character.getType(c2) == Character.OTHER_LETTER) {
                return 1;
            } else if (Character.isLetter(c1)) {
                return -1;
            } else if (Character.isLetter(c2)) {
                return  1;
            } else {
                return 1;
            }
        } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
            return Integer.compare(Character.getNumericValue(c1), Character.getNumericValue(c2));
        } else {
            return s1.compareTo(s2);
        }
    }
}

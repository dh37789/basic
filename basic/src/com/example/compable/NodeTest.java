package com.example.compable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void 한글_영어_숫자_정렬테스트() {
        Node nodeKorean_가 = new Node("가가가aa");
        Node nodeEnglish_c = new Node("ccc22");
        Node nodeNumber_3 = new Node("3초는 어떻게 기다려");
        Node nodeKorean_나 = new Node("나나나vv");
        Node nodeKorean_하 = new Node("하하하송");
        Node nodeEnglish_g = new Node("ggg11");
        Node nodeEnglish_z = new Node("zi존법사");
        Node nodeNumber_5 = new Node("5늘은 말할꺼야");
        Node nodeNumber_1 = new Node("1초라도 안보이면");

        List<Node> nodes = Arrays.asList(nodeKorean_가, nodeEnglish_c, nodeNumber_3, nodeKorean_나, nodeEnglish_g, nodeNumber_5, nodeNumber_1, nodeKorean_하, nodeEnglish_z);
        Collections.sort(nodes);

        assertEquals(nodes.get(0).getName(), nodeKorean_가.getName());
        assertEquals(nodes.get(1).getName(), nodeKorean_나.getName());
        assertEquals(nodes.get(2).getName(), nodeKorean_하.getName());
        assertEquals(nodes.get(3).getName(), nodeEnglish_c.getName());
        assertEquals(nodes.get(4).getName(), nodeEnglish_g.getName());
        assertEquals(nodes.get(5).getName(), nodeEnglish_z.getName());
        assertEquals(nodes.get(6).getName(), nodeNumber_1.getName());
        assertEquals(nodes.get(7).getName(), nodeNumber_3.getName());
        assertEquals(nodes.get(8).getName(), nodeNumber_5.getName());
    }

    @Test
    void arrayTest() {
        Integer[] integerArray = new Integer[]{1, 3, 5, 7};
        printArrays(integerArray);
    }

    private void printArrays(Object[] integerArray) {
        for (Object obj : integerArray)
            System.out.println(obj);
    }

    @Test
    void genericTest() {
        List<Integer> integers = List.of(1, 3, 5, 7);
//        printList(integers);
    }

    private void printList(List<Object> integers) {
        for (Object obj : integers)
            System.out.println(obj);
    }

}
package com.pq;

import com.pq.util.structure.tuple.Tuple;
import com.pq.util.structure.tuple.Tuple2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TupleTest {
    @Test
    public void tupleTest(){
        List<Tuple> list = new ArrayList<>();
        list.add(Tuple.of("asd", "qwe"));
    }
}

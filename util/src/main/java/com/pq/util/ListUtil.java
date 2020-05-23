package com.pq.util;

import com.google.common.collect.Lists;
import com.pq.util.structure.tuple.Tuple;
import com.pq.util.structure.tuple.Tuple2;

import java.util.ArrayList;

public class ListUtil<T> {
    public static void main(String[] args) {
        ArrayList<Tuple2<String, String>> tuples = Lists.newArrayList(Tuple2.of("", ""), Tuple2.of("", ""), Tuple2.of("", ""));
        String str = tuples.get(0)._1().get();
    }
}

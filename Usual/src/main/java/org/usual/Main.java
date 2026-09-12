package org.usual;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Integer>[] result = new List[2];
        result[0] = new ArrayList<>();
        result[0].add(1);
        result[0].add(2);
    }
}

package br.edu.ifpb.domain;
import javafx.util.Pair;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {


    @Override
    public int compare(Pair p1, Pair p2) {
        int d1 = (int) p1.getValue();
        int d2 = (int) p2.getValue();
        if (d1 == d2) return 0;
        return d1 > d2 ? 1 : -1;
    }
}

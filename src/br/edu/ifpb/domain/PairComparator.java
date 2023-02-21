package br.edu.ifpb.domain;
import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair p1, Pair p2) {
        int d1 = p1.value;
        int d2 = p2.value;
        if (d1 == d2) return 0;
        return d1 > d2 ? 1 : -1;
    }
}

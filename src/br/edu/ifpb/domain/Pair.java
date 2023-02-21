package br.edu.ifpb.domain;

public class Pair {
    // segunda opção de ordenação
    // pela carga de trabalho mais alta.

    public int index;
    public int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + index + ", " + value + ')';
    }
}

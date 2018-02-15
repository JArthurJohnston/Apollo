package com.paratussoftware.apollo.musical;

public class Melody {
    private final Tab[] tabs;
    private final String name;

    public Melody(final String name, final Tab... tabs) {
        this.name = name;
        this.tabs = tabs;
    }

    public String getName() {
        return this.name;
    }

    public Tab[] getTabs() {
        return this.tabs;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append("\n");
        for (final Tab tab : this.tabs) {
            stringBuilder.append(tab.name()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public enum Tab {
        C, D, E, F, G, A, B, CC
    }

}

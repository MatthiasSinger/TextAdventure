package textadventure;

import java.util.ArrayList;
import java.util.Arrays;

public class Szene {
    private ArrayList<String> text;
    final ArrayList<Integer> optionen = new ArrayList<>();

    public void setText(String text) {
        String[] split = text.split("[\r\n]");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        this.text = new ArrayList<String>(Arrays.asList(split));
    }

    public void setOptions(ArrayList<String> optionen) {
        for (String s : optionen) {
            this.optionen.add(Integer.valueOf(s));
        }
    }

    public void printText() {
        for (String s : text) {
            System.out.println(s);
        }
    }
}

package Classes;


import java.util.ArrayList;
import java.util.List;

public class Triagles_List {

private final List <Triangle> figure;

    public Triagles_List() {
        figure = new ArrayList<>();
    }


    public void add(Triangle triangle) {
        figure.add(triangle);
    }

    public void remove(Triangle triangle) {
        figure.remove(triangle);
    }

    public void remove(int number) {
        if (number < figure.size())
            figure.remove(number);
    }

    public int getSize() {
        return this.figure.size();
    }

    public int countOf(String type) {

        return getListOf(type).getSize();

    }

    public Triagles_List getListOf(String type) {
        Triagles_List result = new Triagles_List();

        for (Triangle item : figure) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(type))
                result.add(item);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Triangles{" + figure + '}';
    }
}

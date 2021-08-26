package pl.coderslab.virtual;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new A();
        list.add(a);
        A b = new B();
        list.add(b);
        list.forEach(el -> el.a());

        a.A();
        b.A();
    }
}

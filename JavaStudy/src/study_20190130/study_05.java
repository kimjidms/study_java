package study_20190130;

class study_05 {
    public static void main(String[] args) {

        StringArrayList list = new StringArrayList(0);
        list.add("a"); // [a]
        print("add(a)", list);

        StringArrayList another = new StringArrayList();
        print("another", another);

        list.add(0, "b"); // [b, a]
        print("add(0, b)", list);

        list.add(1, "c"); // [b, c, a];
        print("add(1, c)", list);

        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        print("add numbers", list);

        list.remove(0); // [c, a, 0, ... ]
        print("remove(0)", list);

        list.remove(list.size() - 1);
        print("remove last", list);

        list.remove(1); // [c, 0, ... ]
        print("remove(1)", list);

    }

    private static void print(String name, StringArrayList list) {

        System.out.println(name);
        System.out.print("size = " + list.size() + ", [");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }

        System.out.println("]");
        System.out.println("-----------------");

    }
}
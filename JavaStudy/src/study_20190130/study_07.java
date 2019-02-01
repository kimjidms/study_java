package study_20190130;

class Parents {
    private void method1() {
        System.out.println("method1() in Parent");
    }

    void method2() {
        System.out.println("method2() in Parent");
    }

    void printInParent() {
        method1();
        method2();
    }
}

class Childs extends Parents {
    void method1() {
        System.out.println("method1() in Child");
    }

    void method2() {
        System.out.println("method2() in Child");
    }

    void printInChild() {
        method1();
        method2();
    }
}

class study_07 {
    public static void main(String[] args) {

        Childs c = new Childs();

        System.out.println("printInParent");
        c.printInParent();

        System.out.println("printInChild");
        c.printInChild();
    }
}
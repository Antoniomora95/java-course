public class Main {
    private final int prop = 2;
    private double res = 0;

    private int getFactorial(int num) {
        if (num == 1 || num == 0) {
            return num;
        }
        return num * getFactorial(num -1);
    }
    // 5 * getFactorial(4)
    // 4 * getFactorial(3)
    // 3 * getFactorial(2)
    // 2 * getFactorial(1)
    // 1

    // return 1
    // return 2 * 1
    // return 3 * 2
    // return 4 * 6
    // return 5 * 24
    // return 120

    private Main sum (int n) {
        this.res = (byte) (res + n);
        return this;
    }

    private Main res (int n) {
        this.res = res - n;
        return this;
    }

    private Main mult (int n) {
        this.res = res * n;
        return this;
    }

    private Main divide (int n) {
        System.out.println(this.res);
        this.res = res / n;
        System.out.println(this.res);
        return this;
    }

    public static void main(String[] args) {
        Main test = new Main();
//        byte x = 2, y = 3, z = 123;
//        System.out.println(x);
//        System.out.println("Hello world: "+args[1]);


        int res = test.getFactorial(4);

        Main fin = test.sum(3).res(5).mult(2).divide(3);


        String message = String.format("The factorial for %s is %s", 4, res);
        String message1 = String.format("The fn res is%s", fin.res);

        System.out.println(message);
        System.out.println(message1);


        int x = 1, y = 1, z = 0;
        if (x == y | x < ++y) {
            z = x+y;
        }
        else{
            z = 1;
        }
        char midInt = '2';
        System.out.println(midInt);
        System.out.println(z);
    }
}
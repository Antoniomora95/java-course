public class TypeCasting {
    public static void main(String[] args) {
        System.out.println("this is my first program in months");

        byte a = 127;
        byte small = -128;
        byte b = 2;
        byte c = (byte) (b + a);

        char someChar = 'k';
        // here the + symbol casts char into an integer
        int isInt = someChar +1;
        //here you are forcing to get the char for the number which results from
        // someChar + 1 -> ascci code + 1
        char isG = (char) (someChar+1);
        //this is how String.format method would work
        // basically %s helps you to attach your arguments to the string, in the order you passed them
        // to the function
        System.out.printf("this is a number %s, and %s is the char next to %s%n", isInt, isG, someChar);
        String test = "This is an string";
        System.out.println(test.length());
    }
}

/*
* 0000 -> 0
* 0001 -> 1
* 0010 -> 2
* 0011 -> 3
* 0100 -> 4
* 0101 -> 5
* 0110 -> 6
* 0111 -> 7
* 1000 -> 8
* 1001 -> 9
* 1010 -> 10
* 1011 -> 11
* 1100 -> 12
* 1101 -> 13
* 1110 -> 14
* 1111 -> 15
* */

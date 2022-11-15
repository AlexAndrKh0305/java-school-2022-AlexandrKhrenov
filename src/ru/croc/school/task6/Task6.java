package ru.croc.school.task6;

public class Task6 {

    public static void main(String[] args) {

        String source = "/**\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n"; // test data
        String noComments = Parser.removeJavaComments(source);
        System.out.println(noComments);


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Day {

    void run() {
        System.out.println(problem1());
        System.out.println(problem2());
    }

    Scanner getInput() {
        try {
            return new Scanner(new File("src/" + this.getClass().getSimpleName() + ".txt"));
        } catch (FileNotFoundException ex) {

            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    abstract Object problem1();

    abstract Object problem2();
}

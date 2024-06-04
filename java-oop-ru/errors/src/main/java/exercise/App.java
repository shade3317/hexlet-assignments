package exercise;


// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException exception) {
            System.out.println(exception.getMessageError());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END

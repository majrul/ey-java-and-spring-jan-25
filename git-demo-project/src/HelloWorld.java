import java.time.LocalDate;
import java.time.LocalTime;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		LocalDate d = LocalDate.now();
		System.out.println(d);
		LocalTime t = LocalTime.now();
		System.out.println(t);
	}
}

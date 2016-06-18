import java.util.Random;

public class TryPolymorphism {
	
	public static void main(String[] args) {

		// Create an array of three diff animals

		Animal[] theAnimals = { 
			new Dog("Rover", "Poodle"),
			new Cat("Max", "Abysinnian"),
			new Duck("Donald", "Aylesbury"),
			new Spaniel("Fido")
		};

		Animal petChoice;

		Random select = new Random();

		// Make five random choices

		for (int i = 0; i < 9; i++) {

			petChoice = theAnimals[select.nextInt(theAnimals.length)];

			System.out.println("\nYour choice:\n" + petChoice);

			petChoice.sound();

		}
	}

}

import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) {

		Fichero miFichero = new Fichero("datos/datos.txt");

		Lista miLista = new Lista();

		miLista.recogerAlumnosExistentes(miFichero);
		miLista.recogerGruposExistentes(miFichero);

		int eleccionUsuario;

		boolean salir = false;

		Scanner sc = new Scanner(System.in);

		do {

			mostrarMenu();

			do {

				eleccionUsuario = sc.nextInt();
				sc.nextLine();

				if (eleccionUsuario < 1 || eleccionUsuario > 10) {
					System.out.println("Numero introducido no valido");
				}

			} while (eleccionUsuario < 1 || eleccionUsuario > 10);

			switch (eleccionUsuario) {
			case 1:
				miLista.mostrarCumpleañosPorMes();
				break;
			case 2:
				miLista.mostrarMayorYMenor();
				break;
			case 3:
				miLista.mostrarMayoresDeEdad();
				break;
			case 4:
				miLista.mostrarEnRangoDeEdad();
				break;
			case 5:
				miLista.mostrarAlumnosPorEdad();
				break;
			case 6:
				miLista.mostrarMediaEdad();
				break;
			case 7:
				miLista.añadirAlumno(miFichero);
				break;
			case 8:
				miLista.mostrarGruposYAlumnos();
				break;
			case 9:
				miLista.modificarBorrarJugadores(miFichero);
				break;

			default:
				salir = true;
			}

		} while (!salir);

		System.out.println("Hasta pronto!! :D");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" + "░░░░░░░▄▄▄▄▄▄░░░░░░░░░░░░░░░░░░░\r\n"
				+ "░░░░░▄█████████▄▄░░░░░░░░▄▄░░░░░\r\n" + "░░░░███████████████▄▄░░░░▄██▄░░░\r\n"
				+ "░░░▄█████████████████████████░░░\r\n" + "░▄██████████████████████████▀░░░\r\n"
				+ "░███░░░░░░░░░░░░░░░░░░░█░░░░░░░░\r\n" + "░███░███████████████████░░░░░░░░\r\n"
				+ "░███░░▀████───████────█▀░░░░░░░░\r\n" + "░███░░░▀▄▄▄▄▄▀░▀▄▄▄▄▄▀▀▀▄░░░░░░░\r\n"
				+ "░░██░░░░░░░░░░░░░░░░░░░░░▀▄░░░░░\r\n" + "░░▄█░░░░░▄▀█▀▀▀▄▄▄░░░░░▄▀░░▀▄░░░\r\n"
				+ "░█░░░░░▄▀──█───█──▀█▄▄░▀▀░░░░▀▄░\r\n" + "░▀▄▄░░█────█───█───█──▀▀▄░░▄▀▀▀░\r\n"
				+ "░░░█░██▄▄▄▄█▄▄▄█▄▄▄█▄▄▄▄▄█▄▄▀░░░\r\n" + "░░░█░█████████████▄▄░░░░░░░░░░░░\r\n"
				+ "░░░█░█████████████████████████▄░\r\n" + "░░░█░███████████████▀▀░░░░░░░░█░\r\n"
				+ "░░░█░██████████▀▀░░░░░░░░░░░░░█░\r\n" + "░░░█░██████▀░░░░░░░░░░░░░░░░░░█░\r\n"
				+ "░░░█░███▀░░░░░░░░░░░░░░░░░░░░░█░\r\n" + "░░░█░█▀░░░░░░░░░░░░░░░░░░░░░░░█░\r\n"
				+ "░░░█░░░░░░░░░░░░░░▀▄░▀▄░░░░░░░█░\r\n" + "░░░█░░░░░░░░░░░░▄▄▄▀▄▄▀░░░░░░░█░\r\n"
				+ "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n" + "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n"
				+ "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n" + "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n"
				+ "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n" + "░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░█░\r\n"
				+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n"
				+ "░█▀▄░█░█▄░█░█░█░█░░█▀░█▀▄░█▀░█▀▄░▄▀▀░█░\r\n" + "░█░█░█░█▀██░█▀▄░█░░█▀░█▀▄░█▀░█▀▄░█░█░▀░\r\n"
				+ "░▀▀░░▀░▀░░▀░▀░▀░▀▀░▀▀░▀▀░░▀▀░▀░▀░░▀▀░▀░\r\n" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" + "");
		
		sc.close();
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("Que quiere hacer:");
		System.out.println("1.- Mostrar cumpleaños por mes");
		System.out.println("2.- Mostrar persona mas mayor y menor");
		System.out.println("3.- Mostrar mayores de edad");
		System.out.println("4.- Mostrar alumnos en un rango de edades");
		System.out.println("5.- Mostrar alumnos ordenados por edad");
		System.out.println("6.- Mostrar la media de edad");
		System.out.println("7.- Añadir alumno");
		System.out.println("8.- Mostrar grupos o alumnos");
		System.out.println("9.- Borrar/modificar alumnos");
		System.out.println("10.- Salir");
	}

}
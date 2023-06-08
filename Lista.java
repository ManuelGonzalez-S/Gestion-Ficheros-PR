import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Lista {

	private ArrayList<Alumno> lista = new ArrayList<Alumno>();

	private ArrayList<Grupo> misGrupos = new ArrayList<Grupo>();

	public Lista() {
		super();
	}

	public ArrayList<Alumno> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Alumno> lista) {
		this.lista = lista;
	}

	public ArrayList<Grupo> getMisGrupos() {
		return misGrupos;
	}

	public void setMisGrupos(ArrayList<Grupo> misGrupos) {
		this.misGrupos = misGrupos;
	}

	@Override
	public String toString() {
		return "Lista [lista=" + lista + ", misGrupos=" + misGrupos + "]";
	}

//	1.- Mostrar cumpleaños por mes
	public void mostrarCumpleañosPorMes() {

		ArrayList<String> misAlumnos = new ArrayList<String>();

		int añoActual = LocalDate.now().getYear();

		for (int i = 1; i <= 12; i++) {

			for (Alumno miAlumno : lista) {

				if (miAlumno.getFechaNac().getMonthValue() == i) {
					misAlumnos.add(
							miAlumno.getNombre() + ": " + (añoActual - miAlumno.getFechaNac().getYear()) + " años");
				}

			}

			if (misAlumnos.size() > 0) {
				mostrarMes(i);

				for (String miAlumno : misAlumnos) {
					System.out.println(miAlumno);
				}
			}

			misAlumnos.clear();

		}

	}

	private void mostrarMes(int mes) {
		System.out.println();
		switch (mes) {
		case 1:
			System.out.println("Enero:");
			break;

		case 2:
			System.out.println("Febrero: ");
			break;

		case 3:
			System.out.println("Marzo: ");
			break;

		case 4:
			System.out.println("Abril: ");
			break;

		case 5:
			System.out.println("Mayo: ");
			break;

		case 6:
			System.out.println("Junio: ");
			break;

		case 7:
			System.out.println("Julio: ");
			break;

		case 8:
			System.out.println("Agosto: ");
			break;

		case 9:
			System.out.println("Septiembre: ");
			break;

		case 10:
			System.out.println("Octubre: ");
			break;

		case 11:
			System.out.println("Noviembre: ");
			break;

		default:
			System.out.println("Diciembre: ");

		}
	}

//	2.- Mostrar persona mas mayor y menor
	public void mostrarMayorYMenor() {

		int edadMayor = Integer.MIN_VALUE;
		int edadMenor = Integer.MAX_VALUE;

		int añoActual = LocalDate.now().getYear();

		Alumno alumnoMayor = null;

		Alumno alumnoMenor = null;

		int edadAlumno;

		try {

			if (lista.size() > 0) {

				for (Alumno miAlumno : lista) {

					edadAlumno = añoActual - miAlumno.getFechaNac().getYear();

					if (edadAlumno > edadMayor) {
						alumnoMayor = miAlumno;
						edadMayor = edadAlumno;

					} else if (edadAlumno < edadMenor) {
						alumnoMenor = miAlumno;
						edadMenor = edadAlumno;
					}
				}

				if (alumnoMayor != null) {
					System.out.println(
							"El alumno más mayor es: " + alumnoMayor.getNombre() + " con " + edadMayor + " años");
				}

				if (alumnoMenor != null) {
					System.out.println(
							"El alumno mas pequeño es: " + alumnoMenor.getNombre() + " con " + edadMenor + " años");
				}
			} else {
				System.out.println("No hay datos disponibles, porfavor cree más alumnos y vuelva a intentarlo");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se pudo ejecutar la accion, porfavor intentelo de  nuevo");
		}
	}

	// 3.- Mostrar mayores de edad
	public void mostrarMayoresDeEdad() {

		int añoActual = LocalDate.now().getYear();

		int edadAlumno;

		if (lista.size() > 0) {
			System.out.println("Los mayores de edad son:");
			for (Alumno miAlumno : lista) {
				edadAlumno = añoActual - miAlumno.getFechaNac().getYear();
				if (edadAlumno >= 18) {
					System.out.println(miAlumno.getNombre() + " tiene " + edadAlumno + " años");
				}
			}
		} else {
			System.out.println("No hay datos disponibles para esta operacion");
			System.out.println("Por favor, introduce un alumno antes de volver a intentarlo");
		}
		System.out.println();
	}

	// 4.- Mostrar en un rango de edades
	public void mostrarEnRangoDeEdad() {

		Scanner sc = new Scanner(System.in);

		int edadPequeña;
		int edadMayor;

		int auxiliar;

		int edadAlumno;

		int añoActual = LocalDate.now().getYear();

		if (lista.size() > 0) {

			System.out.println("Dime la edad mayor");
			edadMayor = sc.nextInt();
			sc.nextLine();

			System.out.println("Dime la edad menor");
			edadPequeña = sc.nextInt();
			sc.nextLine();

			if (edadPequeña == edadMayor) {
				System.out.println("Edades no válidas");
			} else {
				
				if(edadPequeña > edadMayor) {
					System.out.println("Antes del intercambio:");
					System.out.println("Edad peque: " + edadPequeña);
					System.out.println("Edad mayor: " + edadMayor);
					auxiliar = edadMayor;
					edadMayor = edadPequeña;
					edadPequeña = auxiliar;
					
					System.out.println("Despues del intercambio:");
					System.out.println("Edad peque: " + edadPequeña);
					System.out.println("Edad mayor: " + edadMayor);
				}

				for (Alumno miAlumno : lista) {
					edadAlumno = añoActual - miAlumno.getFechaNac().getYear();
					if (edadAlumno > edadPequeña && edadAlumno < edadMayor) {
						System.out.println(miAlumno.getNombre() + " tiene " + edadAlumno + " años");
					}

				}
			}
		} else {
			System.out.println("No hay datos disponibles en la lista para esta operacion");
		}
		System.out.println();
	}

//	5.- Mostrar alumnos ordenados por edad
	public void mostrarAlumnosPorEdad() {

		ArrayList<Alumno> misAlumnos = lista;

		ArrayList<String> misAlumnoStrings = new ArrayList<String>();

		int añoActual = LocalDate.now().getYear();

		int edadAlumno;

		for (Alumno miAlumno : misAlumnos) {
			edadAlumno = añoActual - miAlumno.getFechaNac().getYear();
			misAlumnoStrings.add(edadAlumno + miAlumno.getNombre());
		}

		Collections.sort(misAlumnoStrings);

		for (String miAlumno : misAlumnoStrings) {
			System.out.println(miAlumno.substring(2) + ": " + miAlumno.substring(0, 2));
		}

	}

//	6.- Media de edad
	public void mostrarMediaEdad() {

		float mediaEdad;

		int totalEdad = 0;

		int edadAlumno;

		int añoActual = LocalDate.now().getYear();

		if (lista.size() > 0) {
			for (Alumno miAlumno : lista) {

				edadAlumno = añoActual - miAlumno.getFechaNac().getYear();

				totalEdad += edadAlumno;
			}

			mediaEdad = totalEdad / lista.size();

			System.out.println("La media de edad es de " + mediaEdad);

		} else {

			System.out.println("No hay datos disponibles, porfavor cree primero un alumno e intentelo de nuevo");
		}

	}

	// 7.- Añadir jugador a la lista y fichero
	public void añadirAlumno(Fichero miFichero) {

		String nombreAlumno;
		String grupoAlumno;

		int ano;
		int mes;
		int diaDelMes;

		int diasMaximosDelMes;

		int decisionUsuario;
		
		Alumno miAlumno;

//		Se añaden los dias que tiene cada mes
		ArrayList<Integer> meses = new ArrayList<Integer>();
		meses.add(31);
		meses.add(28);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(30);
		meses.add(31);

		try {

			Scanner sc = new Scanner(System.in);

//			Pide nombre y grupo del alumno
			System.out.println("Introduce el nombre del alumno");
			nombreAlumno = sc.nextLine().trim();

			System.out.println("Introduce el grupo del alumno");
			grupoAlumno = sc.nextLine().trim();

//			Si el grupo no existe, sale un menu
			if (!comprobarSiExisteGrupo(grupoAlumno)) {

				if (misGrupos.size() > 0) {
					System.out.println("El grupo no existe, que quiere hacer?");
					System.out.println("1.- Crear grupo nuevo en la base de datos");
					System.out.println("2.- Asignar a un grupo existente de la base de datos");

//					En caso de no ser un valor valido, se vuelve a pedir
					do {
						decisionUsuario = sc.nextInt();
						sc.nextLine();

//						Si es un numero no valido, se muestra un mensaje
						if (decisionUsuario < 1 || decisionUsuario > 2) {
							System.out.println("Valor no válido, el numero debe ser 1 o 2");
						}
					} while (decisionUsuario < 1 || decisionUsuario > 2);

				} else {
					decisionUsuario = 1;
				}

//				Si selecciona 1, se crea un nuevo grupo
				if (decisionUsuario == 1) {
					misGrupos.add(new Grupo(grupoAlumno));

				} else {

					if (misGrupos.size() == 1) {
						grupoAlumno = misGrupos.get(0).getNombre();
					} else {

						do {
//						Si no, se muestran los grupos
							System.out.println("Seleccione el nombre del grupo que quiere asignar al usuario:");
							for (Grupo miGrupo : misGrupos) {
								System.out.println(miGrupo.getNombre());
							}

//						Y se pide el nombre del grupo hasta que exista
							grupoAlumno = sc.nextLine();

//						Si no, se muestra un mensaje de error
							if (!comprobarSiExisteGrupo(grupoAlumno)) {
								System.out.println("Grupo no válido");
							}
						} while (!comprobarSiExisteGrupo(grupoAlumno));
					}
				}
			}

//			Se pide el año de nacimiento mientras que este fuera de dos baremos
			do {

				System.out.println("Introduce el año de nacimiento del alumno");
				ano = sc.nextInt();
				sc.nextLine();

//				Si no, se muestra un mensaje de error
				if (ano < 1920) {
					System.out.println("Ingrese un año más reciente");
				} else if (ano > 2015) {
					System.out.println("Ingrese un año más antiguo");
				}

			} while (ano < 1920 || ano > 2015);

//			Se pide el mes de nacimiento mientras que este fuera de entre 0 y 13, ambos inclusive
			do {

				System.out.println("Introduce el mes de nacimiento del alumno");
				mes = sc.nextInt();
				sc.nextLine();

				if (mes <= 0 || mes >= 13) {
					System.out.println("Mes introducido no valido");
				}

			} while (mes <= 0 || mes >= 13);

//			Se añade uno ya que el mes 0 sería el mes 1 (Enero)
			diasMaximosDelMes = meses.get(mes - 1);

//			Se pide el mes
			do {

				System.out.println("Introduce el dia del mes de nacimiento del alumno");
				diaDelMes = sc.nextInt();
				sc.nextLine();

//				Si es menor o igual que 0 o mayor que los dias máximos que tiene el mes, se muestra un mensaje de error y se vuelve a pedir 
				if (diaDelMes <= 0 || diaDelMes > diasMaximosDelMes) {
					System.out.println("Dia del mes introducido no valido");
					System.out.println("Tiene que ser un dia entre 1 y " + diasMaximosDelMes);
				}

			} while (diaDelMes <= 0 || diaDelMes > diasMaximosDelMes);

//			Se añade un alumno con los valores anteriormente pedidos
			
			miAlumno = new Alumno(nombreAlumno, grupoAlumno, LocalDate.of(ano, mes, diaDelMes));
			lista.add(miAlumno);
			
			miFichero.escribirFichero(miAlumno.toString());

//			Se da un mensaje de confirmacion al usuario
			System.out.println("Se ha añadido el jugador " + nombreAlumno + " a la base de datos");

		} catch (Exception e) {
			// TODO: handle exception
//			Si por algun caso ocurriera un error, se mostraria un mensaje de error y el error en cuestion
			System.out.println("No se pudo añadir al jugador: " + e);
		}

	}

	// 8.- Mostrar grupos / alumnos

	public void mostrarGruposYAlumnos() {

		int eleccionUsuario;

		Scanner sc = new Scanner(System.in);

		System.out.println("Quieres mostrar los grupos o alumnos?");
		System.out.println("1.- Grupos");
		System.out.println("2.- Alumnos");

		do {

			eleccionUsuario = sc.nextInt();
			sc.nextLine();

		} while (eleccionUsuario != 1 && eleccionUsuario != 2);

		if (eleccionUsuario == 1) {
			mostrarGrupos();
		} else {
			mostrarAlumnos();
		}
	}

	public void mostrarGrupos() {

		for (Grupo miGrupo : misGrupos) {
			System.out.println(miGrupo.toStringNombre());
		}

	}

	public void mostrarAlumnos() {

		int añoActual = LocalDate.now().getYear();

		int edadAlumno;

		for (Alumno miAlumno : lista) {

			edadAlumno = añoActual - miAlumno.getFechaNac().getYear();

			System.out.println(miAlumno.getNombre().toString() + ", " + edadAlumno + " años");

		}

	}

//	9.- Borrar/Modificar jugadores
	public void modificarBorrarJugadores(Fichero miFichero) {

		int eleccionUsuario;

		Scanner sc = new Scanner(System.in);

		System.out.println("Quiere borrar o modificar algun jugador?");
		System.out.println("1.- Borrar un jugador");
		System.out.println("2.- Modificar un jugador");

		do {

			eleccionUsuario = sc.nextInt();
			sc.nextLine();

			if (eleccionUsuario != 1 && eleccionUsuario != 2) {
				System.out.println("Numero introducido no valido");
			}

		} while (eleccionUsuario != 1 && eleccionUsuario != 2);

		if (eleccionUsuario == 1) {
			borrarAlumno(miFichero);
		} else {
			modificarAlumno(miFichero);
		}

	}

	private void borrarAlumno(Fichero miFichero) {

		Alumno miAlumno;

		int longitud = lista.size();

		int i = 0;

		String nombreBusca;

		boolean borrado = false;

		ArrayList<Alumno> miLista = new ArrayList<Alumno>();
		ArrayList<String> miListaStrings = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		System.out.println("A que alumno quiere borrar?");

		mostrarAlumnos();

		do {

			nombreBusca = sc.nextLine();

			miAlumno = buscarAlumno(nombreBusca);

		} while (miAlumno == null);

		do {

			if (lista.get(i) == miAlumno) {

				System.out.println("Encontrado: " + lista.get(i));
				lista.remove(i);
				longitud = lista.size();

				borrado = true;
			}

			i++;
		} while (i < longitud && !borrado);

		for (Alumno miAlumno2 : lista) {
			miLista.add(miAlumno2);

		}

		lista.clear();

		for (Alumno miAlumno2 : miLista) {
			miListaStrings.add(miAlumno2.toString());
		}

		miFichero.borrarContenidoFichero();

		miFichero.escribirFichero(miListaStrings);

		this.lista = miLista;

	}

	private Alumno buscarAlumno(String nombreBusca) {

		Alumno alumno = null;

		for (Alumno miAlumno : lista) {

			if (miAlumno.getNombre().equals(nombreBusca)) {
				alumno = miAlumno;
			}

		}

		return alumno;
	}

	private void modificarAlumno(Fichero miFichero) {

		ArrayList<String> misAlumnoStrings = new ArrayList<String>();

		ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();

		String nombreBusca;

		Alumno miAlumno;

		int eleccionUsuario;

		int ano;
		int mes;
		int dia;

		int diasMaximosDelMes;

		ArrayList<Integer> meses = new ArrayList<Integer>();
		meses.add(31);
		meses.add(28);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(31);
		meses.add(30);
		meses.add(31);
		meses.add(30);
		meses.add(31);

		boolean existe = false;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el nombre del alumno quiere modificar:");

		mostrarAlumnos();

		do {
			nombreBusca = sc.nextLine();

			miAlumno = buscarAlumno(nombreBusca);

			if (miAlumno == null) {
				System.out.println(
						"No se pudo encontrar el alumno, porfavor vuelva a introducir el nombre y asegurese de que esta escrito correctamente");
			}

		} while (miAlumno == null);

		System.out.println("Que quiere modificar:");
		System.out.println("1.- Nombre");
		System.out.println("2.- Grupo");
		System.out.println("3.- Fecha de nacimiento");

		do {

			eleccionUsuario = sc.nextInt();
			sc.nextLine();

			if (eleccionUsuario != 1 && eleccionUsuario != 2 && eleccionUsuario != 3) {
				System.out.println("Numero introducido no valido");
			}

		} while (eleccionUsuario != 1 && eleccionUsuario != 2 && eleccionUsuario != 3);

		misAlumnoStrings = miFichero.devolverFichero();

		if (eleccionUsuario == 1) {

			System.out.println("Introduzca el nuevo nombre para el alumno:");

			miAlumno.setNombre(sc.nextLine());

			miFichero.borrarContenidoFichero();

			miFichero.escribirFichero(misAlumnoStrings);

		} else if (eleccionUsuario == 2) {

			System.out.println("Introduzca el nuevo grupo");

			nombreBusca = sc.nextLine();

			existe = comprobarSiExisteGrupo(nombreBusca);

			if (existe) {
				miAlumno.setGrupo(nombreBusca);
			} else {

				if (misGrupos.size() == 1) {
					miAlumno.setGrupo(misGrupos.get(0).getNombre());
				} else {
					System.out.println("Que quiere hacer:");
					System.out.println("1.- Crear un nuevo grupo en la base de datos");
					System.out.println("2.- Asignar a un grupo ya creado en la base de datos");

					do {

						eleccionUsuario = sc.nextInt();
						sc.nextLine();

						if (eleccionUsuario != 1 && eleccionUsuario != 2) {
							System.out.println("Numeros introducidos no válidos, porfavor compruebe su eleccion");
						}

					} while (eleccionUsuario != 1 && eleccionUsuario != 2);

					if (eleccionUsuario == 1) {
						misGrupos.add(new Grupo(nombreBusca));
						miAlumno.setGrupo(nombreBusca);
					} else {

						System.out.println("A que grupo quiere asignar el usuario:");

						mostrarGrupos();

						do {

							nombreBusca = sc.nextLine();

							if (misGrupos.indexOf(nombreBusca) == -1) {
								System.out.println("Grupo introducido no valido, porfavor compruebe su respuesta");
							}

						} while (misGrupos.indexOf(nombreBusca) == -1);

						miAlumno.setGrupo(nombreBusca);
					}

				}
			}

			miFichero.borrarContenidoFichero();

			miFichero.escribirFichero(misAlumnoStrings);

			System.out.println("Se modifico el grupo de " + miAlumno.getNombre());

//		Modificar fecha de nacimiento
		} else {

			do {

				System.out.println("Introduce el año de nacimiento del alumno");
				ano = sc.nextInt();
				sc.nextLine();

//				Si no, se muestra un mensaje de error
				if (ano < 1920) {
					System.out.println("Ingrese un año más reciente");
				} else if (ano > 2015) {
					System.out.println("Ingrese un año más antiguo");
				}

			} while (ano < 1920 || ano > 2015);

			do {

				System.out.println("Introduce el mes de nacimiento del alumno");
				mes = sc.nextInt();
				sc.nextLine();

				if (mes <= 0 || mes >= 13) {
					System.out.println("Mes introducido no valido");
				}

			} while (mes <= 0 || mes >= 13);

			diasMaximosDelMes = meses.get(mes - 1);

			do {

				System.out.println("Introduce el dia del mes de nacimiento del alumno");
				dia = sc.nextInt();
				sc.nextLine();

//				Si es menor o igual que 0 o mayor que los dias máximos que tiene el mes, se muestra un mensaje de error y se vuelve a pedir 
				if (dia <= 0 || dia > diasMaximosDelMes) {
					System.out.println("Dia del mes introducido no valido");
					System.out.println("Tiene que ser un dia entre 1 y " + diasMaximosDelMes);
				}

			} while (dia <= 0 || dia > diasMaximosDelMes);

			miAlumno.setFechaNac(LocalDate.of(ano, mes, dia));

			miFichero.borrarContenidoFichero();

			miFichero.escribirFichero(misAlumnoStrings);

			System.out.println("Se modifico la fecha de nacimiento de " + miAlumno.getNombre());
		}

	}

	// Otros
	public boolean comprobarSiExisteGrupo(String nombreBusca) {

		boolean encontrado = false;

		int i = 0;

//		Si existe como minimo un grupo en la lista, se puede ejecutar el metodo
		if (misGrupos.size() > 0) {

//			Se busca el nombre dentro de la lista de grupos
			do {

//				Si se encuentra el nombre y coinciden, se sale del bucle y se cambia el valor de la booleana
				if (misGrupos.get(i).getNombre().equals(nombreBusca)) {
					encontrado = true;
				}
				i++;
			} while (!encontrado && i < misGrupos.size());
		}

//		Se devuelve el valor de la booleana
		return encontrado;
	}

	public void recogerAlumnosExistentes(Fichero miFichero) {

		ArrayList<String> miListaString = miFichero.devolverFichero();

		ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();

		String[] datos = new String[3];

		String fechaString;

		String ano;
		String mes;
		String dia;

		for (int i = 0; i < miListaString.size(); i++) {

			datos = miListaString.get(i).split(";");

			fechaString = datos[2];

			ano = fechaString.split("-")[0];
			mes = fechaString.split("-")[1];
			dia = fechaString.split("-")[2];

			misAlumnos.add(new Alumno(datos[0], datos[1],
					LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia))));
		}

		this.lista = misAlumnos;

	}

	public void recogerGruposExistentes(Fichero miFichero) {

		ArrayList<String> miListaString = miFichero.devolverFichero();

		ArrayList<Grupo> misGrupos = new ArrayList<Grupo>();

		String[] datos = new String[3];

		ArrayList<String> auxiliar = new ArrayList<String>();

		for (int i = 0; i < miListaString.size(); i++) {

			datos = miListaString.get(i).split(";");

			if (auxiliar.indexOf(datos[1]) == -1) {
				misGrupos.add(new Grupo(datos[1]));
				auxiliar.add(datos[1]);
			}

		}

		this.misGrupos = misGrupos;

	}

}

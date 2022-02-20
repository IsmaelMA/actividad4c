import java.util.Scanner;

/**

 * @author Granados Juárez, Fernando; Maldonado Aranda, Ismael; Hernández Valero, Álvaro
 * @version 20/02/2022

 */

public class BuscarSubcadenas
{
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		/*
		 * @brief Programa que pide por teclado una cadena y una subcadena, las valida y muestra el número de veces que se
		 * repite la subcadena dentro de la cadena y las posiciones en las que se producen.
		 */

		//Declaración de los Strings que almacenarán la cadena principal y la subcadena
		String cadena, subcadena;

		//Petición al usuario de la cadena principal
		System.out.println("Introduzca la cadena principal:");

		//Introducción de la cadena principal por teclado
		cadena = input.nextLine();

		//Llamada al método verificarCadena para verificar la cadena principal
		cadena = verificarCadena(cadena);

		//Petición al usuario de la subcadena
		System.out.println("Introduzca la subcadena:");

		//Introducción de la subcadena por teclado
		subcadena = input.nextLine();

		//Llamada al método verificarSubcadena para verificar la subcadena
		subcadena = verificarSubcadena(subcadena, cadena);

		//Llamada al método mostrarSubcadenas para mostrar las coincidencias de la subcadena en la cadena principal
		mostrarSubcadenas(cadena, subcadena);
	}
	/*
	 * @brief	Método estático que verifica una cadena introducida por teclado no esté vacía para hacer el papel de
	 * 			cadena principal. En caso contrario, vuelve a pedir que se introduzca la cadena por teclado hasta que
	 * 			sea una cadena válida.
	 * @param 	cad: cadena tipo String introducida por teclado para ser verificada en este método.
	 * @return 	Un String con el contenido de una cadena introducida por teclado que no esté vacía, que será
	 * 			la cadena principal.
	 */

	static String verificarCadena(String cad)
	{
		//Mientras cad esté vacía, pide que se introduzca una nueva cadena por teclado.
		while(cad.length() == 0)
		{
			System.out.println("La cadena no puede estar vacía. Introduzca una nueva cadena:");
			cad = input.nextLine();
		}
		return cad;
	}

	/*
	 * @brief	Método que verifica que la subcadena introducida por teclado sea válida, es decir, que ni esté vacía ni
	 * 			sea más larga que la cadena principal y, si no cumple ambas condiciones, sigue pidiendo la cadena por
	 * 			teclado hasta que las cumpla.
	 * @param	subcad: cadena tipo String introducida por teclado para ser verificada en este método.
	 * @param	cadPpal: cadena tipo String que hace el papel de cadena principal, la cual se asume que ya ha sido
	 * 			verificada previamente.
	 * @return 	Un String, con el contenido de una cadena introducida por teclado que no esté vacía y su longitud
	 * 			no sea superior a la de la cadena principal, que será la subcadena.
	 */

	static String verificarSubcadena(String subcad, String cadPpal)
	{
		/*
		 * Llama al método verificarCadena pasándole la subcadena como parámetro para comprobar que no es una cadena
		 * vacía y, en caso de serlo, pedir una cadena nueva hasta que deje de serlo.
		 */
		subcad = verificarCadena(subcad);

		/*
		 * Mientras la longitud de la subcadena supere la de la cadena principal, se pide una nueva subcadena y
		 * llama recursivamente a verificarSubcadena.
		 */
		while(subcad.length() > cadPpal.length())
		{
			System.out.println("La subcadena no puede ser más larga que la cadena principal.\nIntroduzca una nueva cadena:");
			subcad = verificarSubcadena(subcad, cadPpal);
		}
		return subcad;
	}

	/*
	 * Método que compara una subcadena con una cadena principal previamente validadas y muestra por pantalla el
	 * número de veces que se repite la subcadena en la cadena principal y en qué posiciones de la cadena principal
	 * se producen estas coincidencias.
	 * @param	subcad: cadena tipo String introducida por teclado para ser verificada como subcadena en este método.
	 * @param	cadPpal: cadena tipo String que hace el papel de cadena principal, la cual se asume que ha sido
	 * 			verificada previamente.
	 */
	static void mostrarSubcadenas(String cad, String subcad)
	{
		/*
		 * Variable tipo int que almacena la posición de la cadena principal en la que se almacena la posición de la
		 * cadena principal en la que se va buscar una posible coincidencia con la subcadena.
		 */
		int pos = 0;

		//Variable en la que se va a almacenar el número de veces que se encuentra la subcadena en la cadena principal.
		int numSubcadenas = 0;

		/*
		 * Mientras pos no sea negativo, se llama al método indexOf de la cadena pasándole como parámetros la subcadena
		 * y la posición almacenada en pos. Este método hará que pos sea negativo, cuando no encuentre la subcadena, o
		 * que valga el índice de la siguiente posición a comprobar, en caso de que se produzca una coincidencia.
		 */
		while(pos >= 0)
		{
			/*
			 * Se actualiza pos con la posición en la que se encuentra la siguiente coincidencia de la subcadena
			 * en la cadena principal empezando a buscar desde la posición pos de la cadena principal
			 */
			pos = cad.indexOf(subcad, pos);

			//Si pos es positivo significa que ha habido una coincidencia
			if(pos >= 0)
			{
				//Se incrementa en 1 el número de veces que se ha encontrado la subcadena en la cadena principal
				numSubcadenas++;

				//Se muestra por pantalla qué coincidencia y en qué posición se acaba de encontrar
				System.out.println(numSubcadenas + "ª coincidencia en la posición " + pos);

				//Se le suma a pos la longitud de la subcadena para buscar la próxima coincidencia
				pos += subcad.length();
			}
		}

		//Muestra por pantalla el número total de coincidencias de la subcadena en la cadena principal
		System.out.println("Número de coincidencias totales: " + numSubcadenas);
	}
}

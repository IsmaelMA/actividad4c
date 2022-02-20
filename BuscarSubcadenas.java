import java.util.Scanner;

public class BuscarSubcadenas 
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		String cadena, subcadena;
		System.out.println("Introduzca la cadena principal:");
		cadena = input.nextLine();
		cadena = verificarCadena(cadena);
		System.out.println("Introduzca la subcadena:");
		subcadena = input.nextLine();
		subcadena = verificarSubcadena(subcadena, cadena);
		mostrarSubcadenas(cadena, subcadena);
	}

	static String verificarCadena(String cad) 
	{

		while(cad.length() == 0)
		{
			System.out.println("La cadena no puede estar vac�a. Introduzca una nueva cadena:");
			cad = input.nextLine();
		}
		return cad;
	}

	static String verificarSubcadena(String subcad, String cadPpal)
	{
		subcad = verificarCadena(subcad);

		while(subcad.length() > cadPpal.length())
		{
			System.out.println("La subcadena no puede ser m�s larga que la cadena principal.\nIntroduzca una nueva cadena:");
			subcad = verificarSubcadena(subcad, cadPpal);
		}
		return subcad;
	}

	static void mostrarSubcadenas(String cad, String subcad)
	{

		int pos = 0;
		int numSubcadenas = 0;

		while(pos >= 0)
		{
			pos = cad.indexOf(subcad, pos);

			if(pos >= 0)
			{
				numSubcadenas++;
				System.out.println(numSubcadenas + "� coincidencia en la posici�n " + pos);
				pos += subcad.length();
			}
		}

		System.out.println("N�mero de coincidencias totales: " + numSubcadenas);
	}
}

import java.util.Scanner;

public class Principal {
	
	public static void main(String [] args){

		int opcion = 0;
		
        Switch caso1 = new Caso1();
        Switch caso2 = new Caso2();
        Switch caso3 = new Caso2();
        Switch defecto = new Default();

        Scanner entradaEscaner = new Scanner (System.in);
        System.out.println ("Ingrese opcion:");
        opcion = Integer.parseInt(entradaEscaner.nextLine()); 
        
        caso1.establecerProximo(caso2);
        caso2.establecerProximo(caso3);
        caso3.establecerProximo(defecto);
        
        caso1.manejarCaso(opcion);

        entradaEscaner.close();
}

}

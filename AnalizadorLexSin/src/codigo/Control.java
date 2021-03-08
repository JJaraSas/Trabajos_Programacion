package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java_cup.runtime.Symbol;

public class Control {
	
	String txtConsola = "";

	public void analisis() throws IOException {
		
		String ruta1 = "C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/Sintax.cup"};
        //   generar(ruta1, ruta2, rutaS);
        System.out.println("Se crearon los archivos");
        txtConsola = txtConsola + "Se crearon los archivos\n";
	    //-------------------Análisis Sintáctico -----------_-----------
	   	try {
	   	Reader lector2 = new BufferedReader(new FileReader("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/test.txt"));
	   	Sintax s = new Sintax(new LexerCup(lector2));
	   	System.out.println("Análisis Sintáctico");
	   	txtConsola = txtConsola + "Análisis Sintáctico\n";
	   	//VPpal.txtIngreso.add
	   	try {
	   		s.parse();
	   		System.out.println("Analisis realizado correctamente");
	   		txtConsola = txtConsola + "Analisis realizado correctamente\n";
	   	}catch (Exception ex) {
	   		Symbol sym = s.getS();
	   		System.out.println("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
	   		txtConsola = txtConsola + "Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"";
	   	}
	   	
	   	
	   	}catch (FileNotFoundException e) {
	   		System.out.println("ERROR");
	   		// TODO Auto-generated catch block
	      		e.printStackTrace();
	   	
	   	}
	   	
	   
	   //-----------------------------------------------------------------	
	       
	     //++++++++++++++++++++++++++ Análisis Léxico ++++++++++++
	   	try {
	   		Reader lector = new BufferedReader(new FileReader("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/test.txt"));
	   		Lexer lexer = new Lexer(lector);
	   		System.out.println("Análisis Léxico");
	   		int cont = 1; 
	   	    String resultado = "LINEA "+ cont + "\t\tSIMBOLO\n";
	   	    while (true) {
	   	    	Tokens token = lexer.yylex();
	   	        if (token == null) {
	   	            resultado += "FIN";
	   	            System.out.println(resultado.toString());
	   	            txtConsola = txtConsola + resultado;
	   	            return;
	   	        }
	   	        switch (token) {
	               case Linea:
	                   cont++;
	                   resultado += "LINEA " + cont + "\n";
	                   break;
	               case Comillas:
	                   resultado += "  <Comillas>\t" + lexer.lexeme + "\n";
	                   break;
	               case Cadena:
	                   resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
	                   break;
	               case T_dato:
	                   resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
	                   break;
	               case If:
	                   resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
	                   break;
	               case Else:
	                   resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
	                   break;
	               case Do:
	                   resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
	                   break;
	               case While:
	                   resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
	                   break;
	               case For:
	                   resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
	                   break;
	               case Igual:
	                   resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
	                   break;
	               case Suma:
	                   resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
	                   break;
	               case Resta:
	                   resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
	                   break;
	               case Multiplicacion:
	                   resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
	                   break;
	               case Division:
	                   resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
	                   break;
	               case Op_logico:
	                   resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
	                   break;
	               case Op_incremento:
	                   resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
	                   break;
	               case Op_relacional:
	                   resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
	                   break;
	               case Op_atribucion:
	                   resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
	                   break;
	               case Op_booleano:
	                   resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
	                   break;
	               case Parentesis_a:
	                   resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
	                   break;
	               case Parentesis_c:
	                   resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
	                   break;
	               case Llave_a:
	                   resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
	                   break;
	               case Llave_c:
	                   resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
	                   break;
	               case Corchete_a:
	                   resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
	                   break;
	               case Corchete_c:
	                   resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
	                   break;
	               case Main:
	                   resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
	                   break;
	               case P_coma:
	                   resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
	                   break;
	               case Identificador:
	                   resultado += "  <Identificador>\t" + lexer.lexeme + "\n";
	                   break;
	               case Numero:
	                   resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
	                   break;
	               case ERROR:
	                   resultado += "  <Simbolo no definido>\n";
	                   break;
	               default:
	                   resultado += "  < " + lexer.lexeme + " >\n";
	                   break;
	   	        }
	   	    }
	   	       	     
	   	}catch (FileNotFoundException e) {
	   		// TODO Auto-generated catch block
	   		e.printStackTrace();
	   	}

	   	
	   	
	}
	  	
   	//----------------------------

	public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
            File archivo;
            archivo = new File(ruta1);
            JFlex.Main.generate(archivo);
            archivo = new File(ruta2);
            JFlex.Main.generate(archivo);
            java_cup.Main.main(rutaS);
            
            Path rutaSym = Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/sym.java");
            if (Files.exists(rutaSym)) {
                Files.delete(rutaSym);
            }
            Files.move(
                    Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/sym.java"), 
                    Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/sym.java")
            );
            Path rutaSin = Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/Sintax.java");
            if (Files.exists(rutaSin)) {
                Files.delete(rutaSin);
            }
            Files.move(
                    Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/Sintax.java"), 
                    Paths.get("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/Sintax.java")
            );
        
	}
	
	//Guardar en txt el codigo
    public void guardar(String texto){

    	FileWriter fw;

    	try{
    		fw= new FileWriter("C:/Users/Jeison/eclipse-workspace/AnalizadorLexSin/src/codigo/test.txt");
    	}catch(IOException io) {
            System.out.println("Error al abrir el fichero");
            return;
    	}
    	
    	//Escribimos
    	try{
            fw.write(texto);
            System.out.println("Fichero guardado");
    	}catch(IOException io){
    		System.out.println("Error al escribir");
    	}

    	//Cerramos el fichero
    	try{
            fw.close();
    	}catch(IOException io){
    		System.out.println("Error al cerrar el archivo");
    	}             

    }
	
    public String consola(){
    	
		return txtConsola;
    	
    }
}

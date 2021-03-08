
public class Caso3 extends Switch{

        private String caso3 = "Este es el Caso 3";
        
 		public void manejarCaso(int caso) {
			if(caso == 2) {
				System.out.println(caso3);
			}else {
				this.proximo.manejarCaso(caso);
			}

		}
 		
}
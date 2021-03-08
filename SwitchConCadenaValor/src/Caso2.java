
public class Caso2 extends Switch{

        private String caso2 = "Este es el Caso 2";
        
 		public void manejarCaso(int caso) {
			if(caso == 2) {
				System.out.println(caso2);
			}else {
				this.proximo.manejarCaso(caso);
			}

		}
 		
}


public class Caso1 extends Switch{

        private String caso1 = "Este es el Caso 1";
        
 		public void manejarCaso(int caso) {
			if(caso == 1) {
				System.out.println(caso1);
			}else {
				this.proximo.manejarCaso(caso);
			}

		}
 		
}

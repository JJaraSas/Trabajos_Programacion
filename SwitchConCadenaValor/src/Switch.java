
public abstract class Switch{

	Switch proximo;
	
	public void establecerProximo(Switch proximo){
	        this.proximo = proximo;
	}

    public abstract void manejarCaso(int caso);

}
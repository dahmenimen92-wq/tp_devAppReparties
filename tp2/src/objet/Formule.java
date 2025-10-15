package objet;
import java.io.*;

public class Formule implements Serializable
{
	int premier;
    String op;
    int deuxieme;
    public Formule(int x,String y,int z)
    {
		premier=x;
		op=y;
		deuxieme=z;
    }
	public int getPremier() {
		return premier;
	}
	public String getOp() {
		return op;
	}
	public int getDeuxieme() {
		return deuxieme;
	}

}

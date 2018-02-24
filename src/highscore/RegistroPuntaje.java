package highscore;

public class RegistroPuntaje {
	public int puntaje;
	private char[] nombre;
	private char[] cancion;
	//int ID;
	
	
	String getNombre(){
		String a="";
		for (int i=0;i<nombre.length;i++){
			a+=nombre[i];
		}
		return a;
	}
	int getPuntaje(){
		return puntaje;
	}
	String getCancion(){
		String a="";
		for (int i=0;i<cancion.length;i++){
			a+=cancion[i];
		}
		return a;
	}
	
	
	public void setNombre(String a){
		nombre=a.toCharArray();
	}
	
	public void setPuntaje(int a){
		puntaje=a;
	}
	
	public void setCancion(String a){
		cancion=a.toCharArray();
	}	
	/*
	public void setID(int i){
		ID=i;
	}
	
	public int getID(){
		return ID;
	}
	*/
}

package highscore;
import java.util.*;
import java.io.*;
public class TabladeRegistros{
	
	ArrayList<RegistroPuntaje> myList = new ArrayList<RegistroPuntaje>();
	File f= new File(".\\Resources\\LosMejores.txt");
	FileInputStream fis=null;
	
	
	public String mostrar(int indice){
		myList=this.LeerTabla();
		int i=indice-1;
		myList.sort((b,a)->Integer.compare(a.puntaje, b.puntaje));
			if(indice<=myList.size())
				return /*myList.get(i).getNombre() + "---"+*/myList.get(i).getCancion()+ "---"+myList.get(i).getPuntaje();	
			else
				return "";
	}
	
	public void escribir(String a){
		char[] str=a.toCharArray();
		try{
			//Intentamos crear objeto de lectura para el archivo
			fis=new FileInputStream(f);
			
		}catch (FileNotFoundException fnfe){
			System.out.println("File not found =(");
		}
		
		
		FileOutputStream fos=null;
		try{
			 fos=new FileOutputStream(f,true/*Concatena texto o sobreescribe*/);
			 for(int i=0;i<str.length;i++){
				 fos.write((int) str[i]);
			 }
			 
			// fos.write((int) "El texto funciona correctamente");  buscar api / pedir presentación a Javier
		}catch(FileNotFoundException fnfe){
			System.out.println("No se encontró el archivo a escribir...");
		}catch(IOException ieo){
			System.out.println("No se pudo escribir en el arvhivo...");
		}
	}
	
	public void VaciarTabla(){
		
		myList.sort((b,a)->Integer.compare(a.puntaje, b.puntaje));
		int j=0;
		
		for(int i=0;i<myList.size();i++){			
			if(j<5){
				this.escribir(myList.get(i).getNombre());
				this.escribir("&");
				this.escribir(Integer.toString(myList.get(i).getPuntaje()));
				this.escribir("#");
				this.escribir(myList.get(i).getCancion());
				this.escribir("~");	
				j++;
			}
			//falta agregar funcion que escribe en el archivo
		
		}
		
	}
	
	public ArrayList<RegistroPuntaje>  LeerTabla(){
		ArrayList<RegistroPuntaje> lista = new ArrayList<RegistroPuntaje>();
		int j=0;
		String dato="";
		RegistroPuntaje var=new RegistroPuntaje();
		char[] total=new char[(int)f.length()];
		try{
			//Intentamos crear objeto de lectura para el archivo
			fis=new FileInputStream(f);
			
		}catch (FileNotFoundException fnfe){
			System.out.println("File not found =(");
		}
		if(fis!=null){
			try{
				for(int i=0;i<f.length();i++){
					//Leemos el archivo a nivel de bytes
					int leido=fis.read();
					total[i]=(char)leido;
				}
			}catch(IOException ioe){
				System.out.println("No se pudo leer el archivo");
			}
		}
		for(int i=0;i<total.length;i++){
			if(total[i]=='&'){
				while(j<i){
					dato+=total[j];
					j++;
				}
				j=i+1;
				var.setNombre(dato);
				dato="";
			}
			if(total[i]=='#'){
				while(j<i){
					dato+=total[j];
					j++;
				}
				j=i+1;
				var.setPuntaje(Integer.parseInt(dato));
				dato="";
			}
			if(total[i]=='~'){
				while(j<i){
					dato+=total[j];
					j++;
				}
				j=i+1;
				var.setCancion(dato);;
				dato="";
				lista.add(var);
				var=new RegistroPuntaje();
			}
		}
		return lista;
	}
	
	public void AgregarPuntuacion(String nombre,String song,int puntuacion ){
		this.escribir(nombre);
		this.escribir("&");
		this.escribir(Integer.toString(puntuacion));
		this.escribir("#");
		this.escribir(song);
		this.escribir("~");	
		
		
	}
	
	public void LimpiarPuntuajes(){
		try{
			//Intentamos crear objeto de lectura para el archivo
			fis=new FileInputStream(f);
			
		}catch (FileNotFoundException fnfe){
			System.out.println("File not found =(");
		}
		
		
		FileOutputStream fos=null;
		try{
			 fos=new FileOutputStream(f,false/*Concatena texto o sobreescribe*/);
			 fos.write(' ');
			 
			// fos.write((int) "El texto funciona correctamente");  buscar api / pedir presentación a Javier
		}catch(FileNotFoundException fnfe){
			System.out.println("No se encontró el archivo a escribir...");
		}catch(IOException ieo){
			System.out.println("No se pudo escribir en el arvhivo...");
		}
	}
	/*
	public static void main(String[] args) {
	
		TabladeRegistros h = null;
		h=new TabladeRegistros();
		h.AgregarPuntuacion("Paul", "StairToMyAss", 91458);
		System.out.print(h.mostrar(1));
		System.out.print(h.mostrar(2));
		System.out.print(h.mostrar(3));
		System.out.print(h.mostrar(4));
		System.out.print(h.mostrar(5));
		//h.LimpiarPuntuajes();
	
		}
	*/	
}


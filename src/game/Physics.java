package game;



import java.util.LinkedList;

import interfaces.Entity1;
import interfaces.Entity2;
import interfaces.EntityA;
import interfaces.EntityB;

public class Physics {

	//Analiza contacto cuando pista requiere alguna de las teclas (1,2,3,4)
	public static boolean Collision(EntityA enta, LinkedList<Entity1> ent1){
		for(int i=0; i<ent1.size();i++){
			if(enta.getBounds().intersects(ent1.get(i).getBounds())){//Analiza contacto por parte de tecla
				return true;
			}
		}
			return false;
		}
		
	
	public static boolean Collision(Entity1 ent1, LinkedList<EntityA> enta){//Analiza contacto por parte de pista
		for(int i=0; i<enta.size();i++){
			if(ent1.getBounds().intersects(enta.get(i).getBounds())){
				return true;
			}
		}
			return false;
	}
	
	//Analiza contacto cuando pista requiere tecla de ESPACIO
	public static boolean Collision(EntityB entb, LinkedList<Entity2> ent2){//Analiza contacto por parte de tecla
		for(int i=0; i<ent2.size();i++){
			if(entb.getBounds().intersects(ent2.get(i).getBounds())){
				return true;
			}
		}
			return false;
		}
		
	
	public static boolean Collision(Entity2 ent2, LinkedList<EntityB> entb){//Analiza contacto por parte de pista
		for(int i=0; i<entb.size();i++){
			if(ent2.getBounds().intersects(entb.get(i).getBounds())){
				return true;
			}
		}
			return false;
	}
}

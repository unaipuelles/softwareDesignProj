package src.java.proyectodisenosoftware;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Attribute;
import model.Guerrero;
import model.Character;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Character personaje = characterSelection();
        personaje = personalizeAttributes(personaje);
    }
    
    public static Character characterSelection(){
        boolean error = false;
        Character personaje = null;
        do{
            System.out.println("----Seleccion del personaje----\n");
            System.out.println("1.- Guerrero\n2.-Mago\n3.-Gigante");
            Scanner scanner = new Scanner(System.in);
            int characterNum = scanner.nextInt();
           
            switch(characterNum){
                case 1:
                    personaje = new Character(Character.GUERRERO);
                break;
                case 2:
                    personaje = new Character(Character.MAGO);
                break;
                case 3:
                    personaje = new Character(Character.GIGANTE);
                break;
                default:
                    showErrorMessage("El valor introducido no corresponde con ningún personaje");
                    error = true;
                break;    
            } 
        }while(error == true);
    
        return personaje;
    }
    
    public static Character personalizeAttributes(Character personaje) {
        boolean error = false;
        int puntos = 8;
        List<Attribute> atributos = personaje.getAttributes();
        do{
            showAllAttributes(atributos);
            System.out.println(puntos + " puntos restantes");
            
            System.out.println("\nIntroduce la habilidad a la que quieres sumarle un punto: ");
            Scanner scanner = new Scanner(System.in);
            int characterNum = scanner.nextInt();
            
            Attribute atributo = null;
            switch(characterNum){
                case 1:
                    atributo = findAttribute(Attribute.FUERZA, atributos);    
                break;
                case 2:
                    atributo = findAttribute(Attribute.RESISTENCIA, atributos); 
                break;
                case 3:
                    atributo = findAttribute(Attribute.AGILIDAD, atributos); 
                break;
                case 4:
                    atributo = findAttribute(Attribute.SALUD, atributos); 
                break;
                case 5:
                    atributo = findAttribute(Attribute.DEFENSA, atributos); 
                break;
                case 6:
                    atributo = findAttribute(Attribute.ATAQUE, atributos); 
                break;
                default:
                    showErrorMessage("El valor introducido no corresponde con ningún atributo");
                    error = true;
                break;    
            }
            if(error != true && atributo != null) {
                atributo.setValor(atributo.getValor()+1);
                puntos--;
            }
            
        }while(error == false && puntos > 0);
        
        return personaje;
    }
    
    public static void showErrorMessage(String message){
        System.out.println("[ERROR] "+message);
    }
    
    public static void showAllAttributes(List<Attribute> atributos) {
        int cont = 1;
        for(Attribute atributo : atributos){
            System.out.println(cont + ".- " + atributo.getName() + ": " + atributo.getValor() + "\n");
            cont++;
        }
    }
    
    public static Attribute findAttribute(int type, List<Attribute> atributos) {
        boolean encontrado = false;
        Attribute atributo = null;
        for(int x = 0; x < atributos.size() && encontrado == false; x++){
            Attribute tmp = atributos.get(x);
            if(tmp.equals(type)) {
                atributo = tmp;
                encontrado = true;
            }
        }
        
        return atributo;
    }
}

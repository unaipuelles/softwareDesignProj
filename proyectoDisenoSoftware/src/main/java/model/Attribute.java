package model;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
import java.util.List;
import java.util.ArrayList;

public class Attribute {
    public static final int FUERZA = 1;
    private static final String SFUERZA = "Fuerza";
    public static final int RESISTENCIA = 2;
    private static final String SRESISTENCIA = "Resistencia";
    public static final int AGILIDAD = 3;
    private static final String SAGILIDAD = "Agilidad";
    public static final int SALUD = 4;
    private static final String SSALUD = "Salud";
    public static final int DEFENSA = 5;
    private static final String SDEFENSA = "Defensa";
    public static final int ATAQUE = 6;
    private static final String SATAQUE = "Ataque";  
    
    private String name;
    private int type;
    private int valor;

    public Attribute(int type, int valor) {
        this.type = type;
        this.valor = valor;
        setName();
    }

    public String getName() {
        return name;
    }

    private void setName() {
        switch(type){
            case FUERZA:
                name = SFUERZA;
            break;
            case RESISTENCIA:
                name = SRESISTENCIA;
            break;
            case AGILIDAD:
                name = SAGILIDAD;
            break;
            case SALUD:
                name = SSALUD;
            break;
            case DEFENSA:
                name = SDEFENSA;
            break;
            case ATAQUE:
                name = SATAQUE;
            break;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        setName();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public boolean equals(int type) {
        boolean equals = false;
        if(this.type == type)
            equals = true;
        return equals;    
    }
}

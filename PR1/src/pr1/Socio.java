package pr1;

import java.util.ArrayList;

/**
 *  Clase socio en la que definimos los atributos del propio y cómo manipulamos sus atributos.
 */

public class Socio 
{
    private String nombre;
    private int id_socio;
    private int precio_motos = 0;
    private ArrayList<Moto> motos; //Vector de motos que tiene el propio cliente
    
    public Socio(String nombre, int id_socio)
    {
        this.nombre = nombre;
        this.id_socio = id_socio;
        motos = new ArrayList<Moto>();
        System.out.println("Socio creado " + id_socio + " " + nombre  + "\n");
    }
    
    @Override
    public String toString()
    {
        return "SOCIO\nSocio: " + id_socio + "\n" + "Nombre: " + nombre + "\n";
    }
    
    //Funcion para mostrar los atributos del socio, creada ya que no sabemos por qué el toString no muestra nada
    public void mostrar()
    {
        System.out.println("SOCIO\nSocio: " + id_socio + "\n" + "Nombre: " + nombre + "\n");
    }
    
    //Funcion que añade la moto al vector de motos del socio
    public boolean addMoto(Moto m)
    {
        motos.add(m);
        
        return true;
    }
    
    //Funcion que comprueba si la moto con identificador pasado como parámetro está en disposicion del socio
    public boolean comprobarMoto(int id)
    {
        boolean ok = false;
        
        for(Moto m: motos)
        {
            if(m.getID() == id)
            {
                ok = true;
            }
        }
        return ok;
    }
    
    //Funcion que comprueba si la moto pasada como parámetro la dispone el socio, y si es así, la elimina de su vector.
    public Socio removeMoto(Moto m)
    {
        for(int i = 0; i < motos.size(); i++)
        {
            if(m.getID() == motos.get(i).getID())
            {
                motos.remove(i);
            }
        }
        
        return this;
    }
    
    //Funcion que devuelve el vector de motos del socio en cuestion
    public ArrayList<Moto> getMotos()
    {
        return motos;
    }
    
    //Funcion que devuelve el nombre del socio en cuestion
    public String getNombre()
    {
        return nombre;
    }
    
    //Funcion que devuelve el identificador del socio en cuestion
    public int getId_Socio()
    {
        return id_socio;
    }
    
    //Funcion que devuelve el precio total de las motos que tiene en su desposicion
    public int getPrecios()
    {
        for(int i = 0; i < motos.size(); i++)
        {
            precio_motos += motos.get(i).getCoste();
        }
        
        return precio_motos;
    }
}

package pr1;

import java.util.Random;

/**
 *  Clase moto en la que definimos los atributos de la propia y cómo manipulamos sus atributos.
 */
public class Moto 
{
    private int id_moto;
    private String modelo;
    private int cc;
    private int coste;
    boolean ocupada = false;
    private String matricula;
    private Socio socio; //Socio al que va a estar vinculada
    
    public Moto(Socio socio, int id_moto)
    {
        this.id_moto = id_moto;
        this.socio = socio;
        matricula = generarMatricula();
    }

    @Override
    public String toString()
    {
        return "MOTO\nID Moto: " + id_moto + "\n" + "Modelo: " + modelo + "\n" + "Cilindrada: " + cc + "\n" + "Coste: " + coste + "\n" + "Matricula: " + matricula + "\nIDSocio Asociado: " + socio.getId_Socio() + "\n";
    }
    
    //Funcion para mostrar los atributos de la moto, creada ya que no sabemos por qué el toString no muestra nada
    public void mostrar()
    {
        System.out.println("MOTO\nID Moto: " + id_moto + "\n" + "Modelo: " + modelo + "\n" + "Cilindrada: " + cc + "\n" + "Coste: " + coste + "\n" + "Matricula: " + matricula + "\nIDSocio Asociado: " + socio.getId_Socio() + "\n");
    }
    
    //Funcion que crea una matrícula siguiendo el formato real
    private String generarMatricula()
    {
    //Letras válidas para matrícula
    char[] array = {'B', 'C',
                    'D', 'F', 'G', 'H', 'J', 'K', 'L', 
                    'M', 'N', 'P', 'R', 'S', 'T', 'V', 
                    'W', 'X', 'Y', 'Z'};

    String matricula = "";

    for (int i=0; i<7; i++)
    {
      Random rnd = new Random();
      int ale = (int)(rnd.nextDouble() * array.length); //Aleatorio para la letra
      int ale2 = (int)(rnd.nextDouble() * 10); //Aleatorio entre 0-9
      if (i>3) {
        matricula += array[ale];
      } else {
        matricula +=  ale2;
      }
    }

    return matricula;

  }
  
  //Funcion que cambia la disponibilidad de una moto
  public void setDisponibilidad(boolean ocupada)
  {
      this.ocupada = ocupada;
  }
  
  //Funcion que devuelve si una moto está o no disponible
  public boolean getDisponible()
  {
      return ocupada;
  }
  
  //Funcion que vincula la moto con un socio en concreto, el socio al que pertenece la moto
  public void setSocio(Socio socio)
  {
      this.socio = socio;
  }
  
  //Funcion que devuelve el socio al que está vinculado la moto
  public Socio getSocio()
  {
      return socio;
  }
  
  //Funcion que define el precio de la moto
  public void setCoste(int coste)
  {
      this.coste = coste;
  }
  
  //Funcion que devuelve el precio de la moto 
  public int getCoste()
  {
      return coste;
  }
  
  //Funcion que define los CC de la moto
  public void setCC(int cc)
  {
      this.cc = cc;
  }
  
  //Funcion que devuelve los CC de la moto
  public int getCC()
  {
      return cc;
  }
  
  //Funcion que devuelve la matrícula de la moto
  public String getMatricula()
  {
      return matricula;
  }
  
  //Funcion que define el modelo de la moto
  public void setModelo(String modelo)
  {
      this.modelo = modelo;
  }
  
  //Funcion que devuelve el modelo de la moto
  public String getModelo()
  {
      return modelo;
  }
  
  //Funcion que define el identificador de la moto
  public void setID(int id_moto)
  {
      this.id_moto = id_moto;
  }
  
  //Funcion que devuelve el identificador de la moto
  public int getID()
  {
      return id_moto;
  }
}

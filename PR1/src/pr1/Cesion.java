package pr1;

/**
 *  Clase cesion en la que definimos los atributos de la propia y cómo manipulamos sus atributos.
 */
public class Cesion 
{
    private Socio s1, s2;
    private Moto moto;
    
    public Cesion(Socio s1, Socio s2, Moto moto)
    {
        this.s1 = s1;
        this.s2 = s2;
        this.moto = moto;
        //System.out.println(s1.getNombre() + s1.getId_Socio());
        //System.out.println(s2.getNombre() + s2.getId_Socio());
    }
    
    @Override
    public String toString()
    {
        String mensaje = "CESION\nSocio que cede: " + s1.toString() + "\n" + "Socio al que se le cede la moto: " + s2.toString() + "\n" + "Moto que se cede: " + moto.toString() + "\n";
        return mensaje;
    }
    
    //Funcion en la que mostramos los atributos de la cesion ya que no sabemos por qué pero con el toString no muestra nada
    public void mostrar()
    {
        System.out.println("CESION\nSocio que cede: " + s1.toString() + "\n" + "Socio al que se le cede la moto: " + s2.toString() + "\n" + "Moto que se cede: " + moto.toString() + "\n");
    }
}

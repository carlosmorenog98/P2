package pr1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  Clase Inicio en la que vamos a realizar todas las acciones pertinentes y donde probaremos el programa
 */
public class Inicio 
{
    private boolean asignada = false;
    private ArrayList<Socio> socios; //Vector de socios del programa
    private ArrayList<Moto> motos; //Vector de motos del programa
    private ArrayList<Cesion> cesiones; //Vector de cesiones del programa en el que almacenaremos todas las cesiones que se realizan
    private Socio s_1, s_2;
    private Moto m_1;
    public String precio_total;
    
    public Inicio()
    {
        socios = new ArrayList<Socio>();
        motos = new ArrayList<Moto>();
        cesiones = new ArrayList<Cesion>();
        Scanner keyboard = new Scanner(System.in); //Leemos la opción desde la consola 
        int opcion = 0;
        
        System.out.println("Introduce el importe maximo que puede disponer cada miembro: ");
        precio_total = keyboard.next();
        
        while(opcion != 7)
        {
            opcion = imprimirMenu();
            
            switch(opcion){
                case 1:
                    System.out.println("Alta de socio: ");
                    altaSocio(keyboard);
                    break;
                case 2:
                    System.out.println("Alta de moto: ");
                    altaMoto(keyboard);
                    break;
                case 3:
                    System.out.println("Cesión de moto: ");
                    cederMoto(keyboard);
                    break;
                case 4:
                    System.out.println("Listar todo los miembros con motos: ");
                    mostrarSociosMoto();
                    break;
                case 5:
                    System.out.println("Listar las motos: ");
                    mostrarMotos();
                    break;
                case 6:
                    System.out.println("Mostrar cesiones realizadas: ");
                    mostrarCesiones();
                    break;
                case 7:
                    System.out.println("Salir: ");
                    System.exit(0);
                    break;
            }
        }    
    }
    
    //Funcion que muestra el menú cada vez que se acaba con una opción
    public int imprimirMenu()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 – Registrar un nuevo miembro.\n" +
                           "2 – Registrar una nueva motocicleta.\n" +
                           "3 – Registrar una cesión.\n" +
                           "4 – Listar en pantalla los miembros con motos en posesión.\n" +
                           "5 – Listar todas las motos.\n" +
                           "6 – Mostrar las cesiones realizadas.\n" +
                           "7 – Salir.\n");
        int opcion = keyboard.nextInt();
        return opcion;
    }

    //Función que da de alta a un socio
    public void altaSocio(Scanner keyboard) 
    {
        String nombre;
        
        do
        {
            System.out.println("Introduce su nombre: ");
            nombre = keyboard.next();
        }while(!validarNombre(nombre)); //Comprobamos que se escriba un nombre correcto, comprobando con una gramática
        
        Socio socio = new Socio(nombre, socios.size()+1);
        socios.add(socio);
        System.out.println("Socio añadido correctamente.\n");
        System.out.println("Listado Socios:" + socios.toString());
    }

    //Funcion que comprueba que un nombre esté bien escrito, usando para ello una gramática
    public boolean validarNombre(String nombre) 
    {
        String nombreRegex = "[a-zA-Z]+"; //Gramática con la que se comprueba que el nombre está bien escrito
                              
        Pattern pat = Pattern.compile(nombreRegex); 
        if (nombre == null) 
            return false; 
        return pat.matcher(nombre).matches(); 
    }
    
    //Funcion que da de alta una moto
    public void altaMoto(Scanner keyboard) 
    {
        Socio socio;
        Moto moto;
        String modelo, cc, precio, id;
        boolean ok = false;      
        
        do
        {
            System.out.println("Introduce su modelo: ");
            modelo = keyboard.next();
        }while(!validarModelo(modelo));  //Comprobamos que el modelo está excrito correctamente comprobando la gramática
        
        do
        {
            System.out.println("Introduce sus cc: ");
            cc = keyboard.next();
        }while(!validarCC(cc)); //Comprobamos que los CC están excritos correctamente comprobando la gramática
                        
        do
        {
            System.out.println("Introduce su coste: ");
            precio = keyboard.next();
        }while(!validarCoste(precio)); //Comprobamos que el precio está excrito correctamente comprobando la gramática  
        
        while(ok == false)
        {
            do
            {
                System.out.println("Introduce el ID del socio que va a adquirir la moto: ");
                id = keyboard.next();
            }while(validarID(id) == false); //Aqui comprobamos que el socio con ese identificador existe
            
            int id2 = Integer.parseInt(id);
            
            for(Socio s: socios)
            {
                if(id2 == (s.getId_Socio()) && ((s.getPrecios()+Integer.parseInt(precio)) <= Integer.parseInt(precio_total))) //Se comprueba si corresponde el id con algún socio y puede tener esa moto ya que no excede el límite de precio
                {
                    moto = new Moto(s, motos.size()+1);
                    moto.setCC(Integer.parseInt(cc));
                    moto.setCoste(Integer.parseInt(precio));
                    moto.setModelo(modelo);
                    ok = true;
                    motos.add(moto);
                    s.addMoto(moto);
                }
                else
                {
                    System.out.println("No es el ID o no le cabe.\n");
                }
            }
        }
        
        System.out.println("Moto añadida correctamente.\n");
        
        //System.out.println("Numero de motos: " + motos.size());
        System.out.println("Listado Motos:" + motos.toString());
    }

    //Funcion que valida el modelo con la gramática correspondiente
    public boolean validarModelo(String modelo) 
    {
        String nombreRegex = "[a-zA-Z]+[0-9]*"; 
                              
        Pattern pat = Pattern.compile(nombreRegex); 
        if (modelo == null) 
            return false; 
        return pat.matcher(modelo).matches(); 
    }
    
    //Funcion que valida los CC con la gramática correspondiente
    public boolean validarCC(String cc) 
    {
        String nombreRegex = "[0-9]+"; 
                              
        Pattern pat = Pattern.compile(nombreRegex); 
        if (cc == null) 
            return false; 
        return pat.matcher(cc).matches(); 
    }
    
    //Funcion que valida el coste con la gramática correspondiente
    public boolean validarCoste(String coste) 
    {
        String emailRegex = "[0-9]+"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (coste == null) 
            return false; 
        return pat.matcher(coste).matches(); 
    }
    
    //Funcion que comprueba si el identificador pasado como parámetro corresponde con alguno de los socios
    public boolean validarID(String id) 
    {
        boolean ok = false;
        
        for(Socio s: socios)
        {
            int id2 = Integer.parseInt(id);
            if(id2 == (s.getId_Socio()))
            {
                ok = true;
            }
        }
        return ok;
    }
    
    //Funcion que realiza la cesión de la moto de un socio a otro
    public void cederMoto(Scanner keyboard) 
    {
        boolean validado = true;
        String id1, id2, id3;
        
        do
        {
            do
            {
                System.out.println("Introduce el id del socio que desea ceder: ");
                id1 = keyboard.next();
                //System.out.println("Socio " + id1);
            }while(!validarID(id1)); //Comprobamos que el socio que desea ceder existe        

            do
            {
                validado = false;
                System.out.println("Introduce el id del socio al que desea cederle la moto: ");
                id2 = keyboard.next();
                //System.out.println("Socio " + id2);
            }while(!validarID(id2)); //Comprobamos que el socio al que se le desea ceder existe

            do
            {
                validado = false;
                System.out.println("Introduce el id de la moto que desea ceder: ");
                id3 = keyboard.next();
                //System.out.println("Moto " + id3);
            }while(!validarIDMoto(id3)); //Comprobamos que la moto que queremos ceder existe
            
            for(Socio s: socios)
            {
                if(this.validarID(id1))
                {
                    s_1 = s;
                    //System.out.println(s_1.getNombre() + s_1.getId_Socio());
                }
                else
                {
                    validado = false;
                    System.out.println("Identificador del Socio que desea ceder no corresponde con ninguno.\n");
                }
            }
            for(Socio s2: socios)
            {
                if(this.validarID(id2))
                    {
                        s_2 = s2;
                        //System.out.println(s_2.getNombre() + s_2.getId_Socio());
                    }
                    else
                    {
                        validado = false;
                        System.out.println("Identificador del Socio al que desea ceder la moto no corresponde con ninguno.\n");
                    }
            }
            
            for(Moto m: motos)
            {
                int id6 = Integer.parseInt(id3);
                if(id6 == (m.getID()))
                {
                    m_1 = m;
                }
                else
                {
                    validado = false;
                    System.out.println("Identificador de la moto que desea ceder no corresponde con ninguno.\n");
                }
            }
            
        
            if(validado == true)
            {
                if((s_2.getPrecios()+m_1.getCoste()) > Integer.parseInt(precio_total)) //Si no se puede ya que no le cabe la moto, o sea que se excede el presupuesto
                {
                    validado = false;
                }
            }
        }while(validado = false);
        
        //System.out.println("Se puede realizar correctamente.");
        //System.out.println("El ID del que cede: " + s_1.getId_Socio() + "\nEl ID del socio al que se le quiere ceder: " + s_2.getId_Socio());
        realizarCesion(s_1, s_2, m_1);
        Cesion cesion = new Cesion(s_1, s_2, m_1);
        System.out.println("Cesion realizada.\n");
        cesiones.add(cesion);
    }

    //Funcion que realiza la cesion una vez nos confirman que puede realizarse ya que todos los datos concuerdan
    public boolean realizarCesion(Socio s_1, Socio s_2, Moto m_1)
    {
        boolean ok = true;
        
        for(Socio s: socios)
        {
            if(this.validarID("" + s_1.getId_Socio()) && s.comprobarMoto(m_1.getID()) == true) //Si el usuario concuerda y ese usuario tiene la moto correspondiente eliminamos la moto del usuario que quiere ceder
            {
                for(Moto m : motos)
                {
                    if(m_1.getID() == m.getID())
                    {
                        s.getMotos().remove(m); 
                    }
                    
                }
                    
            }
            else if(this.validarID("" + s_2.getId_Socio()))
            {
                s.addMoto(m_1); //Añadimos la moto al socio que quiere que le cedan la moto
            }
            
            for(Moto m: motos)
            {
                if(this.validarIDMoto("" + m_1.getID()))
                {
                    m_1.setSocio(s_2); //Vinculamos la moto al nuevo socio
                }
            }
        }
        
        return ok;
    }
    
    //Funcion que comprueba que el identificador de la moto existe
    public boolean validarIDMoto(String id) 
    {
        boolean ok = false;
        
        for(Moto m: motos)
        {
            int id2 = Integer.parseInt(id);
            if(id2 == (m.getID()))
            {
                ok = true;
            }
        }
        return ok;
    }
    
    //Función que muestra a todos los socios con sus motos
    public void mostrarSociosMoto() 
    {
        ArrayList<Moto> m;
        //System.out.println("Hay " + socios.size() + " socios.");
        for(Socio s: socios)
        {
                System.out.println("Motos del socio: " + s.getMotos().size());
                s.mostrar();
                m = s.getMotos();
                if(m.isEmpty())
                {
                    System.out.println("No tiene motos el socio.\n");
                }
                else
                {
                    for(Moto mot: m)
                    {
                        mot.toString();
                        mot.mostrar();
                    }
                }
        }
    }

    //Funcion que muestra todas las motos y el socio que tiene asociado
    public void mostrarMotos() 
    {
        
        for(Moto m: motos)
        {
            m.mostrar();
            m.getSocio().mostrar();
        }
    }

    //Funcion que muestra las cesiones que se han realizado
    public void mostrarCesiones() 
    {
        if(cesiones.isEmpty())
        {
            System.out.println("No se ha hecho ninguna cesión por el momento.\n");
        }
        else
        {
            for(Cesion c: cesiones)
            {
                c.mostrar();
            }
        }
    }
}
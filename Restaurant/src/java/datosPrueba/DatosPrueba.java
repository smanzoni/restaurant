package datosPrueba;

import java.util.ArrayList;
import logica.Cliente;
import logica.Fachada;
import logica.Gestor;
import logica.Mesa;
import logica.Mozo;
import logica.Producto;
import logica.beneficio.Beneficio;
import logica.beneficio.Comun;
import logica.beneficio.DeLaCasa;
import logica.beneficio.Preferencial;
import utilidades.CustomException;

/**
 *
 * @author Ignacio Cabrera
 */
public class DatosPrueba {

    public static void cargarMozos() {

        try {
            ArrayList<Mozo> mozos = new ArrayList<>();

            Mozo mozoNacho = new Mozo("mozoNacho", "1234", "Ignacio Cabrera");
            mozos.add(mozoNacho);

            Mozo mozoSantiago = new Mozo("mozoSantiago", "1234", "Santiago Manzoni");
            mozos.add(mozoSantiago);

            Fachada.getInstancia().setMozosTodos(mozos);
            
        } catch (CustomException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void cargarGestores() {

        try {
            ArrayList<Gestor> gestores = new ArrayList<>();

            Gestor gestorNacho = new Gestor("gestorNacho", "1234", "Ignacio Cabrera");
            gestores.add(gestorNacho);

            Gestor gestorSantiago = new Gestor("gestorSantiago", "1234", "Santiago Manzoni");
            gestores.add(gestorSantiago);

            Fachada.getInstancia().setGestoresTodos(gestores);

        } catch (CustomException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public static void cargarMesas() {
        ArrayList<Mozo> mozos = Fachada.getInstancia().getMozosTodos();
        
        try {

            int i = 0;
            for (Mozo m : mozos) {
                for (int j = 0; j < 8; j++) {
                    m.agregarMesaAsignada(new Mesa(++i, false, m));
                }
            }

        } catch (CustomException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public static void cargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        
        productos.add(new Producto("a1", "Pan", 46, 20f));
        productos.add(new Producto("a2", "Papas fritas", 46, 20f));
        productos.add(new Producto("a3", "Milanesa", 46, 20f));
        productos.add(new Producto("a4", "Pure", 46, 20f));
        productos.add(new Producto("a5", "Omelette", 46, 20f));
        productos.add(new Producto("a6", "Helado", 46, 20f));
        productos.add(new Producto("a7", "Vino", 46, 20f));
        productos.add(new Producto("agua", "Agua", 46, 20f));
        productos.add(new Producto("cafe", "Cafe", 46, 20f));
        
        Fachada.getInstancia().setProductos(productos);
    }
    
    public static void cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Beneficio deLaCasa = new DeLaCasa("DeLaCasa");
        Beneficio preferencial = new Preferencial("Preferencial");
        Beneficio comun = new Comun("Comun");
        
        clientes.add(new Cliente(1, "c1@gmail.con", "Cliente de la casa"));
        clientes.add(new Cliente(2, "c2@gmail.con", "Cliente preferencial"));
        clientes.add(new Cliente(3, "c3@gmail.con", "Cliente comun"));

        clientes.get(0).setBeneficio(deLaCasa);
        clientes.get(1).setBeneficio(preferencial);
        clientes.get(2).setBeneficio(comun);
        
        Fachada.getInstancia().setClientes(clientes);
        
    }
    
}

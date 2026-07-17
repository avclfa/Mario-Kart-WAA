import java.util.ArrayList;

public class Corredor {
    private String nombre;
    private int velocidad;
    private int peso;
    private int CapacidadDeDrift;
    private String color;
    private Vehiculo vehiculo;
    private int recorrido;
    private int vueltas;
    private String record = "-";

    public Corredor(String nombre, int velocidad, int peso, int capacidadDeDrift, String color, Vehiculo vehiculo, int recorrido, int vueltas) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.peso = peso;
        CapacidadDeDrift = capacidadDeDrift;
        this.color = color;
        this.vehiculo = vehiculo;
        this.recorrido=recorrido;
        this.vueltas =vueltas;
    }

    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String BLANCO = "\u001B[37m";
    static final String MORADO = "\u001B[35m";

    static Corredor c1 = new Corredor("Mario", 25, 3, 3, ROJO, Vehiculo.auto,0,0);
    static Corredor c2 = new Corredor("Luigi", 30, 3, 5, VERDE, Vehiculo.moto,0,0);
    static Corredor c3 = new Corredor("Yoshi", 50, 2, 5, BLANCO, Vehiculo.moto,0,0);
    static Corredor c4 = new Corredor("Toad", 40, 1,10, AZUL, Vehiculo.auto,0,0);
    static Corredor c5 = new Corredor("Bowser", 50, 5, 2, AMARILLO, Vehiculo.auto,0,0);
    static Corredor c6 = new Corredor("DonKey Kong", 40, 4, 8, MORADO, Vehiculo.auto,0,0);

    static ArrayList<Corredor> corredores = new ArrayList<>();
    static{
        corredores.add(c1);
        corredores.add(c2);
        corredores.add(c3);
        corredores.add(c4);
        corredores.add(c5);
        corredores.add(c6);
    }
    static ArrayList<Corredor> corredores_Clasicos = new ArrayList<>();
    static{
        corredores_Clasicos.add(c1);
        corredores_Clasicos.add(c2);
        corredores_Clasicos.add(c3);
        corredores_Clasicos.add(c5);
    }

    static ArrayList<Corredor> corredores_Finales = new ArrayList<>();


    public static ArrayList<Corredor> corredores() {
        return corredores;
    }
    public static ArrayList<Corredor> corredores_Clasicos() { return corredores_Clasicos; }

    public static ArrayList<Corredor> corredores_Finales() {
        return corredores_Finales;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCapacidadDeDrift() {
        return CapacidadDeDrift;
    }
    public void setCapacidadDeDrift(int capacidadDeDrift) {
        CapacidadDeDrift = capacidadDeDrift;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getRecorrido() {
        return recorrido;
    }
    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public int getVueltas() {
        return vueltas;
    }
    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getRecord() {
        return record;
    }
    public void setRecord(String record) {
        this.record = record;
    }

}

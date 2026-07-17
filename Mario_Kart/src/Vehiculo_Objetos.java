public class Vehiculo_Objetos {
    private String tipo;
    private String nombre;
    private int estabilidad;
    private int peso;
    private int drift;

    public Vehiculo_Objetos(String tipo, String nombre, int estabilidad, int drift, int peso) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.estabilidad = estabilidad;
        this.drift = drift;
        this.peso = peso;
    }

    static Vehiculo_Objetos rueda1 = new Vehiculo_Objetos("Rueda", "Pequeña", -1, 2,-2);
    static Vehiculo_Objetos rueda2 = new Vehiculo_Objetos("Rueda", "Mediana", 0, 1, 1);
    static Vehiculo_Objetos rueda3 = new Vehiculo_Objetos("Rueda", "Monstruo", 2, 0, 2);
    static Vehiculo_Objetos chasis1 = new Vehiculo_Objetos("Chasis", "Liviano", -2, 2,-2);
    static Vehiculo_Objetos chasis2 = new Vehiculo_Objetos("Chasis", "Mediano", 1, 1,0 );
    static Vehiculo_Objetos chasis3 = new Vehiculo_Objetos("Chasis", "Pesado", 2, 0, 2);
    static Vehiculo_Objetos[] objetos = { rueda1, rueda2, rueda3, chasis1, chasis2, chasis3};

    public static Vehiculo_Objetos[] objetos() {
        return objetos;
    }

    public static Vehiculo_Objetos[] getObjetos() {
        return objetos;
    }
    public static void setObjetos(Vehiculo_Objetos[] objetos) {
        Vehiculo_Objetos.objetos = objetos;
    }



    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstabilidad() {
        return estabilidad;
    }
    public void setEstabilidad(int estabilidad) {
        this.estabilidad = estabilidad;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDrift() {
        return drift;
    }
    public void setDrift(int drift) {
        this.drift = drift;
    }



}

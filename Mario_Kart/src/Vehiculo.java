
public class Vehiculo {
    private int estabilidad;
    private int drift;
    private int peso;
    private String nombre;

    public Vehiculo(int estabilidad, int drift, int peso, String nombre) {
        this.estabilidad = estabilidad;
        this.drift = drift;
        this.peso = peso;
        this.nombre = nombre;
    }
    public Vehiculo(Vehiculo vehiculoOriginal) {
        this.estabilidad = vehiculoOriginal.getEstabilidad();
        this.drift = vehiculoOriginal.getDrift();
        this.peso = vehiculoOriginal.getPeso();
        this.nombre = vehiculoOriginal.getNombre();
    }

    static Vehiculo auto = new Vehiculo(10, 5, 10, "auto");
    static Vehiculo moto = new Vehiculo(5, 8, 5, "moto");


    static Vehiculo[] vehiculo_Base = {auto, moto};

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

    public int getDrift() {
        return drift;
    }
    public void setDrift(int drift) {
        this.drift = drift;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
}


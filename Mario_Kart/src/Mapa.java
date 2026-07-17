public class Mapa {
    private int longitud;
    private int vueltas;
    private String Nombre;

    public Mapa(int longitud, int vueltas, String Nombre) {
        this.longitud = longitud;
        this.vueltas = vueltas;
        this.Nombre = Nombre;
    }

    static Mapa m1 = new Mapa(200, 3, "Celda Arcoiris");
    static Mapa m2 = new Mapa(500, 4, "Circuito de McDonals");
    static Mapa m3 = new Mapa(1000,2, "Tierra Sorete");

    static Mapa[] mapas = {m1,m2,m3};

    public static Mapa[] mapas(){
        return mapas;
    }

    public int getLongitud() {
        return longitud;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getVueltas() {
        return vueltas;
    }
    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        Nombre = Nombre;
    }
}

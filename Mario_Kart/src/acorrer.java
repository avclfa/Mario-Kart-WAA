import java.util.ArrayList;
import java.util.Random;

public class acorrer extends Thread implements Runnable {
    ArrayList<Corredor> corredores_Finales = Corredor.corredores_Finales();
    static Random random = new Random();
    int[] corredoresPodio = new int[4];
    int caida;
    int boost;
    int porcaida;
    int porboost;
    int avance;
    boolean fin = false;
    int todosListos = 0;
    Reloj cronometro = new Reloj();
    static final String RESET = "\u001B[0m";
    static final String SUBRAYADO = "\u001B[4m";
    public static final String CIAN = "\u001B[36m";

    public acorrer() {

    }

    public void Inicio() {
        try {
            Main.reproducirSonido("start.wav");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int Velocidad(Corredor c) {
        int vmax = c.getVelocidad() - (c.getPeso() * 3);
        if (vmax <= 0) {
            vmax = 1;
        }
        return vmax;
    }

    public void Caerse() {
        for (Corredor c : corredores_Finales) {
            caida = random.nextInt(100) + 1;
            if (c.getVehiculo().getEstabilidad() <= 10) {
                porcaida = (10 - c.getVehiculo().getEstabilidad()) * 5;
                if (caida <= porcaida) {
                    c.setRecorrido(c.getRecorrido() - 5);
                    System.out.println(c.getNombre() + " se cayó");
                }
            }
        }
    }

    public void Boost() {
        for (Corredor c : corredores_Finales) {
            boost = random.nextInt(100) + 1;
            if (c.getVehiculo().getDrift() >= 10) {
                porboost = (c.getVehiculo().getDrift() - 10) * 5;
                if (boost <= porboost) {
                    c.setRecorrido(c.getRecorrido() + 10);
                    System.out.println(c.getNombre() + " obtuvo un boost");
                }
            }
        }
    }

    public void TheWinnerTakesItAll() {
        for (Corredor c : corredores_Finales) {
            while(c.getRecorrido() >= Main.MapaElegido.getLongitud() && c.getVueltas() < Main.MapaElegido.getVueltas()) {
                c.setRecorrido(c.getRecorrido()-Main.MapaElegido.getLongitud());
                c.setVueltas(c.getVueltas()+1);
                System.out.println(c.getNombre() + " ya va por la vuelta n° " + c.getVueltas());
                if (c.getVueltas() >= Main.MapaElegido.getVueltas()) {
                    c.setRecord(cronometro.reinicio());
                    System.out.println(c.getNombre() + " ¡ha terminao la carrera! Tiempo: " + c.getRecord());
                    todosListos++;


                }
            }
        }
        if (todosListos == corredores_Finales.size()) {
            podio();
            fin = true;
        }
    }

    public void MporS() {
        for (Corredor c : corredores_Finales) {
            int vmax = Velocidad(c);
            avance = random.nextInt(vmax);
            c.setRecorrido(c.getRecorrido() + avance);
            System.out.println(c.getNombre() + " posición actual: " + c.getRecorrido() + "m");
        }
    }

    public int tiempoASegundos(String tiempo) {
        String[] partes = tiempo.split(":");
        int min = Integer.parseInt(partes[0]);
        int sec = Integer.parseInt(partes[1]);
        return min * 60 + sec;
    }

    public void podio() {
        int n = corredores_Finales.size();
        ArrayList<Corredor> ordenados = new ArrayList<>(corredores_Finales);
        for (int i = 0; i < n; i++) {
            for (int b = 0; b < n - 1 - i; b++) {
                int tiempoB = tiempoASegundos(ordenados.get(b).getRecord());
                int tiempoBmas1 = tiempoASegundos(ordenados.get(b + 1).getRecord());
                if (tiempoB > tiempoBmas1) {
                    Corredor aux = ordenados.get(b);
                    ordenados.set(b, ordenados.get(b + 1));
                    ordenados.set(b + 1, aux);
                }
            }
        }
        System.out.println(SUBRAYADO + CIAN + RESET + "                                PODIO                               ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            Corredor c = ordenados.get(i);
            System.out.printf(SUBRAYADO + CIAN + " %-23s | %-23s | %-23s" + RESET + "%n", (i + 1) + "° ", c.getNombre(), c.getRecord());
        }
        System.out.println();
        System.out.printf( SUBRAYADO + CIAN +"        ESTADISTICAS DE LOS CORREDORES         " + RESET);
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getNombre());
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVelocidad() + " km/h");
        }
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getPeso() + " kg");
        }
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getCapacidadDeDrift());
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        for (Corredor c : corredores_Finales) {
            Vehiculo rival = c.getVehiculo();
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Vehiculo: " + c.getVehiculo().getNombre());
        }
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getVehiculo().getDrift());
        }
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Estabilidad: " + c.getVehiculo().getEstabilidad());
        }
        System.out.println();
        for (Corredor c : corredores_Finales) {
            System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVehiculo().getPeso() + " kg");
        }
        System.out.println();


    }
    @Override
    public void run() {
        Inicio();
        cronometro.start();
        while (!fin){
            try {
                Thread.sleep(1000);
                System.out.println("\n--- "  + Main.MapaElegido.getNombre() + " ---");
                MporS();
                Caerse();
                Boost();
                TheWinnerTakesItAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cronometro.detener();
    }
}


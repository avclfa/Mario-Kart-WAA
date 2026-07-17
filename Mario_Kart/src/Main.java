import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Corredor> corredores;
    static ArrayList<Corredor> corredores_Clasicos;
    static ArrayList<Corredor> corredores_Finales;
    static Vehiculo_Objetos[] objetos;
    static Vehiculo[] vehiculo_Base;
    static Mapa[] mapas;

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    static String eleccion;
    static Corredor Micorredor;

    static int modo;

    static int mapa;
    static Mapa MapaElegido;

    static int descarte;
    static int componente_r;
    static int componente_c;

    static String vehiculo;
    static Vehiculo MiVehiculo;
    static String rueda;
    static String chasis;

    static boolean valido = false;

    static final String RESET = "\u001B[0m";
    static final String NEGRITA = "\u001B[1m";
    static final String SUBRAYADO = "\u001B[4m";
    public static final String CIAN = "\u001B[36m";

    public static void main(String[] args) {
        corredores = Corredor.corredores();
        objetos = Vehiculo_Objetos.objetos();
        corredores_Clasicos = Corredor.corredores_Clasicos();
        vehiculo_Base = Vehiculo.vehiculo_Base;
        corredores_Finales = Corredor.corredores_Finales();
        mapas = Mapa.mapas();

        while (!valido) {
            System.out.printf(NEGRITA + "                                  MARIO KART WAA - ELIGE TU CORREDOR " + RESET);
            System.out.println();
            for (Corredor c : corredores) {
                System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getNombre());
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------");
            for (Corredor c : corredores) {
                System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVelocidad() + " km/h");
            }
            System.out.println();
            for (Corredor c : corredores) {
                System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getPeso() + " kg");
            }
            System.out.println();
            for (Corredor c : corredores) {
                System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getCapacidadDeDrift());
            }
            System.out.println();

            System.out.print("Escribe el nombre del corredor: ");
            eleccion = leer.nextLine().toLowerCase();
            for (Corredor c : corredores) {
                if (c.getNombre().toLowerCase().equals(eleccion)) {
                    Micorredor = c;
                    valido = true;
                    switch (eleccion) {
                        case "mario":
                            reproducirSonido("mario.wav");
                            break;
                        case "luigi":
                            reproducirSonido("luigi.wav");
                            break;
                        case "yoshi":
                            reproducirSonido("yoshi.wav");
                            break;
                        case "toad":
                            reproducirSonido("toad.wav");
                            break;
                        case "bowser":
                            reproducirSonido("bowser.wav");
                            break;
                        case "donkey kong":
                            reproducirSonido("donkey.wav");
                            break;
                    }
                }
            }
            if (!valido) {
                System.out.println("Tipo de dato no Valido. Ingrese nombre del corredor nuevamente");
            }
        }

        System.out.println(" ------------------- TALLER MECANICO ------------------- ");
        do {
            System.out.println("Crea tu propio vehiculo, elige entre un auto o moto:");
            vehiculo = leer.nextLine().toLowerCase();
            if (vehiculo.equals("auto")) {
                System.out.println("Buena eleccion! Elegiste el auto");
                MiVehiculo = new Vehiculo(vehiculo_Base[0]);
                reproducirSonido("beep.wav");
                valido = false;
            } else if (vehiculo.equals("moto")) {
                System.out.println("Buena eleccion! Elegiste la moto");
                MiVehiculo = new Vehiculo(vehiculo_Base[1]);
                //System.out.println("datos del vehiculo" + MiVehiculo.getDrift() + " " + MiVehiculo.getEstabilidad() +" " + MiVehiculo.getPeso());
                reproducirSonido("beep.wav");
                valido = false;
            } else {
                System.out.println("Ups! Tipo de no valido. Vuelva a seleccionar el tipo de vehiculo.");
            }
        } while (valido);

        System.out.println("Una vez seleccionado: " + vehiculo + " , podras equiparlo como te guste");
        System.out.println("Para las rueadas tenes: ");
        System.out.printf(NEGRITA + "                       RUEDAS " + RESET);
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf(SUBRAYADO + CIAN + "%-14s " + RESET + " | ", objetos[i].getNombre());
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s | ", "Estabilidad: " + objetos[i].getEstabilidad());
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s | ", objetos[i].getPeso() + " kg");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s | ", "Drift: " + objetos[i].getDrift());
        }
        System.out.println();
        do {
            System.out.println("Puedes selecionar solo un tipo de rueda, elige bien! ");
            rueda = leer.nextLine().toLowerCase();
            switch (rueda) {
                case "pequeña":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[0].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[0].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[0].getDrift());
                    valido = true;
                    break;
                case "mediana":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[1].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[1].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[1].getDrift());
                    valido = true;
                    break;
                case "monstruo":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[2].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[2].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[2].getDrift());
                    valido = true;
                    break;
                default:
                    System.out.println("Ups! Tipo de no valido. Vuelva a seleccionar el tipo de rueda.");
                    valido = false;
            }
        } while (!valido);

        System.out.println("Para el chasis tenes: ");
        System.out.printf(NEGRITA + "                       CHASIS " + RESET);
        System.out.println();
        for (int i = 3; i < 6; i++) {
            System.out.printf(SUBRAYADO + CIAN + "%-14s " + RESET + " | ", objetos[i].getNombre());
        }
        System.out.println();
        for (int i = 3; i < 6; i++) {
            System.out.printf("%-15s | ", "Estabilidad: " + objetos[i].getEstabilidad());
        }
        System.out.println();
        for (int i = 3; i < 6; i++) {
            System.out.printf("%-15s | ", objetos[i].getPeso() + " kg");
        }
        System.out.println();
        for (int i = 3; i < 6; i++) {
            System.out.printf("%-15s | ", "Drift: " + objetos[i].getDrift());
        }
        System.out.println();
        do {
            System.out.println("Puedes selecionar solo un tipo de chasis, elige bien! ");
            chasis = leer.nextLine().toLowerCase();
            switch (chasis) {
                case "liviano":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[3].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[3].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[3].getDrift());
                    valido = true;
                    break;
                case "mediano":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[4].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[4].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[4].getDrift());
                    valido = true;
                    break;
                case "pesado":
                    MiVehiculo.setEstabilidad(MiVehiculo.getEstabilidad() + objetos[5].getEstabilidad());
                    MiVehiculo.setPeso(MiVehiculo.getPeso() + objetos[5].getPeso());
                    MiVehiculo.setDrift(MiVehiculo.getDrift() + objetos[5].getDrift());
                    valido = true;
                    break;
                default:
                    System.out.println("Ups! Tipo de no valido. Vuelva a seleccionar el tipo de chasis.");
                    valido = false;
            }
        } while (!valido);

        System.out.println("Haz completado tu vehiculo con exito, elige el modo de juego");
        do {
            System.out.printf(SUBRAYADO + CIAN + " %-21s " + RESET + " | " + SUBRAYADO + CIAN + "%-21s" + RESET + "%n", " CLASICO [1] ", " ALEATORIO [2] ");
            System.out.printf("%-23s | %-23s%n", "Carrera tradicional.", "Tus rivales tienen ");
            System.out.printf("%-23s | %-23s%n", "Tus rivales ya estan", "valores aleatorios,");
            System.out.printf("%-23s | %-23s%n", "definidos.Tu vehiculo", "cualquiera puede");
            System.out.printf("%-23s | %-23s%n", "hace la diferencia. ", "ganar ¡Suerte!");
            System.out.print("Elige entre [1] Clasico o [2] Aleatorio: ");
            modo = leer.nextInt();
            switch (modo) {
                case 1:
                    for (Corredor c : corredores_Clasicos) {
                        if (c.getNombre().equalsIgnoreCase(eleccion)) {
                            corredores_Clasicos.remove(c);
                        } else {
                            descarte = random.nextInt(corredores_Clasicos.size());
                            corredores_Clasicos.remove(descarte);
                        }
                        valido = true;
                        break;
                    }
                    System.out.println();
                    System.out.println("Rivales listos en el circuito clásico: ");
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getNombre());
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------");
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVelocidad() + " km/h");
                    }
                    System.out.println();
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getPeso() + " kg");
                    }
                    System.out.println();
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getCapacidadDeDrift());
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------");
                    for (Corredor c : corredores_Clasicos) {
                        Vehiculo rival = c.getVehiculo();
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Vehiculo: " + c.getVehiculo().getNombre());
                    }
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getVehiculo().getDrift());
                    }
                    System.out.println();
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Estabilidad: " + c.getVehiculo().getEstabilidad());
                    }
                    System.out.println();
                    for (Corredor c : corredores_Clasicos) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVehiculo().getPeso() + " kg");
                    }
                    System.out.println();

                    corredores_Finales.addAll(corredores_Clasicos);
                    corredores_Finales.add(Micorredor);
                    valido = true;
                    break;
                case 2:
                    corredores.remove(Micorredor);
                    for (int i = 0; i < 2; i++) {
                        descarte = random.nextInt(corredores.size());
                        corredores.remove(descarte);
                    }
                    for (Corredor c : corredores) {
                        c.setVehiculo(new Vehiculo(c.getVehiculo()));
                        componente_r = random.nextInt(3);
                        switch (componente_r) {
                            case 0:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[0].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[0].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[0].getDrift());
                                break;
                            case 1:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[1].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[1].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[1].getDrift());
                                break;
                            case 2:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[2].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[2].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[2].getDrift());
                                break;
                        }
                        componente_c = random.nextInt(3);
                        switch (componente_c) {
                            case 0:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[3].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[3].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[3].getDrift());
                                break;
                            case 1:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[4].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[4].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[4].getDrift());
                                break;
                            case 2:
                                c.getVehiculo().setEstabilidad(c.getVehiculo().getEstabilidad() + objetos[5].getEstabilidad());
                                c.getVehiculo().setPeso(c.getVehiculo().getPeso() + objetos[5].getPeso());
                                c.getVehiculo().setDrift(c.getVehiculo().getDrift() + objetos[5].getDrift());
                                break;
                        }
                    }
                    System.out.println();
                    System.out.println("Rivales listos en el circuito aleatorio: ");
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getNombre());
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------");
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVelocidad() + " km/h");
                    }
                    System.out.println();
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getPeso() + " kg");
                    }
                    System.out.println();
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getCapacidadDeDrift());
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------");

                    for (Corredor c : corredores) {
                        Vehiculo rival = c.getVehiculo();
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Vehiculo: " + c.getVehiculo().getNombre());
                    }
                    System.out.println();
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Drift: " + c.getVehiculo().getDrift());
                    }
                    System.out.println();
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", "Estabilidad: " + c.getVehiculo().getEstabilidad());
                    }
                    System.out.println();
                    for (Corredor c : corredores) {
                        System.out.printf(c.getColor() + "%-15s" + RESET + " | ", c.getVehiculo().getPeso() + " kg");
                    }
                    System.out.println();

                    corredores_Finales.addAll(corredores);
                    corredores_Finales.add(Micorredor);
                    valido = true;
                    break;
                default:
                    System.out.println("Ups! Tipo de no valido. Vuelva a seleccionar el modo de juego.");
                    valido = false;
            }
        } while (!valido);

        System.out.println("Una vez elegido el modo, seleciona un mapa: ");
        do {
            System.out.printf(SUBRAYADO + CIAN + " %-22s " + RESET + " | " + SUBRAYADO + CIAN + "%-22s" + RESET + " | " + SUBRAYADO + CIAN + "%-22s" + RESET + "%n", "Celda Arcoiris", " Circuito de McDonals", "Tierra Sorete");
            System.out.printf("%-23s | %-23s | %-23s%n", "Longitud: 200m  ", "Longitud: 500m", "Longitud: 1000m");
            System.out.printf("%-23s | %-23s | %-23s%n", "Vueltas: 3", "Vueltas: 4", "Vueltas: 2");

            System.out.print("Elige entre [1] Celda Arcoiris, [2] Circuito de McDonals  o [3] Tierra Sorete: ");
            try {
                mapa = leer.nextInt();
                if (mapa != 1 && mapa != 2 && mapa != 3) {
                    System.out.println("No existe esa opcion");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida, boton");
                leer.nextLine();
            }
            switch (mapa) {
                case 1:
                    MapaElegido = mapas[0];
                    break;
                case 2:
                    MapaElegido = mapas[1];
                    break;
                case 3:
                    MapaElegido = mapas[2];
                    break;
            }
        } while (!valido);

        acorrer carrera = new acorrer();
        Thread hilo1 = new Thread(carrera);
        Reloj tiempo = new Reloj();
        Thread hilo2 = new Thread(tiempo);
        hilo1.start();
        hilo2.start();
    }
    public static void reproducirSonido (String nombreArchivo){
        try {
            File archivoSonido = new File(nombreArchivo);
            if (archivoSonido.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                Thread.sleep(1000);
            } else {
                System.out.println("No se encontró el archivo de sonido en: " + archivoSonido.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }

}


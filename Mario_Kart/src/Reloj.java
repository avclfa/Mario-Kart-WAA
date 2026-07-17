public class Reloj extends Thread implements Runnable{
    private int sec = 0;
    private int min = 0;
    private volatile boolean detener = false;

    public Reloj(){
    }

    public void Cronometro(){
        System.out.print("Tiempo: " );
        if (min < 10) {
            System.out.print("0" + min);
        } else {
            System.out.print(min);
        }

        System.out.print(":");

        if (sec < 10) {
            System.out.print("0" + sec);
        } else {
            System.out.print(sec);
        }
        System.out.println("");
    }

    public int getSec() {
        return sec;
    }
    public int getMin() {
        return min;
    }

    public String reinicio(){
        String minStr = (min < 10) ? "0" + min : String.valueOf(min);
        String secStr = (sec < 10) ? "0" + sec : String.valueOf(sec);
        return minStr + ":" + secStr;
    }

    public void detener() {detener = true;}

    @Override
    public void run() {
        while (!detener) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
            }
        }
    }
}

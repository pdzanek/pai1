import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime, startTimeMT;
        long endTime, endTimeMT;
        //1 watek
        startTime=System.currentTimeMillis();
        for(int i=0;i<args.length;i++){
           LineCounter[] lc = new LineCounter[args.length];
           lc[i]=new LineCounter(args[i]);
           System.out.println("Ilość linii pliku nr "+i+": "+lc[i].numberOfLines());
        }
        endTime=System.currentTimeMillis();
        System.out.println("Całkowity czas dla odczytu sekwencyjnego: "+(endTime-startTime)+"ms");
        //wiele watkow
        startTimeMT=System.currentTimeMillis();
        MyThread[] mt = new MyThread[args.length];
        for(int i=0;i<args.length;i++) {
            mt[i] =new MyThread(args[i]);
            mt[i].start();
        }
        endTimeMT=System.currentTimeMillis();
        System.out.println("Całkowity czas dla odczytu wielowątkowego: "+(endTimeMT-startTimeMT)+"ms");
    }
}

//Napisz program, ktory pobiera liste plikow z linii polecen i wyswietla liczbe wierszy kazdego z nich.
// Program powinien utworzyc jeden watek dla kazdego z plikow i uzyc tych watkow do zliczenia liczby wierszy kazdego z plikow rownoczenie.
// Utworz wersje programu, ktora odczytuje pliki nie jednoczesnie a sekwencyjnie. Porownaj wydajnosc wielowatkowego i jednowatkowego programu
// uzywajac System.currentTimeMillis() do okreslenia czasu wykonania. Porownania dokonaj dla dwoch, trzech i pieciu plikow.
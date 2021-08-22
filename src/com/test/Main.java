package com.test;

import jdk.internal.dynalink.beans.StaticClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedImage img = null;

    private static class Figura {
        private static ArrayList<String> listM = new ArrayList<>();
        private static ArrayList<Integer> listMk = new ArrayList<>();

        public static int searchM(int k) {
            int r=-1;
            for (int i=0; i<listMk.size(); i++){
                if (k==listMk.get(i))
                    r=i;
            }
            return r;
        }

        public static void addM(String n, int k) {
            listM.add(n);
            listMk.add(k);
        }

        public static String getM(int i) {
            return listM.get(i);
        }

        public static void saveM(String namefile) {
            try(FileWriter writer = new FileWriter(namefile, false))
            {
                int i=0;
                while (i<listM.size())
                {
                    writer.write(listM.get(i)+'-');
                    writer.write(Integer.toString(listMk.get(i))+'\n');
                    i++;
                }
                writer.flush();
            } catch (Exception ex){}
        }

        public static void loadM(String namefile) {
            try(FileReader reader = new FileReader(namefile))
            {
                int c;
                String s="";
                String n=null;
                int k;
                while((c=reader.read())!=-1){
                    if (c=='-') {
                        n = s;
                        s="";
                    } else
                    if (c=='\n') {
                        k= new Integer(s);
                        listM.add(n);
                        listMk.add(k);
                        s="";
                    } else
                    s+= ((char)c);
                }
            } catch (Exception ex){}
        }
    }

    public static void main(String[] args) {
        if (args.length>0) {
            String fileNameIn = args[0];
            File dir = new File(fileNameIn);
            File[] files = dir.listFiles();
            Figura.loadM("dm.txt");

            int[] kX = {146, 217, 289, 360, 432};

            String nameFile = null;
            for (int iImage = 0; iImage < files.length; iImage++) {
                try {
                    //img = ImageIO.read(new File("D:\\3\\java_test_task\\imgs\\20180821_093516.072_0x1FE201D8.png"));
                    nameFile = files[iImage].toString();
                    img = ImageIO.read(new File(nameFile));
                } catch (IOException e) {
                }

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                System.out.print(nameFile + " - ");
                for (int i = 0; i < 5; i++) {
                    int kodU = kodKarta(kX[i], 589);
                    if (kodU > 0){
                        int iU = Figura.searchM(kodU);
                        if (iU < 0){
                            System.out.print('\n' + "You need training" + '\n' + "In this file: " + nameFile + '\n' + "what level is " + (i + 1) + " card? - ");
                            try {
                                String sU = bufferedReader.readLine();
                                Figura.addM(sU, kodU);
                                Figura.saveM("dm.txt");
                            } catch (IOException e) {
                            }
                        } else {
                            System.out.print(Figura.getM(iU));
                        }
                    }

                    int kodM = kodKarta(kX[i], 589 + 30);
                    if (kodM > 0) {
                        int iM = Figura.searchM(kodM);
                        if (iM < 0) {
                            System.out.print('\n' + "You need training" + '\n' + "In this file: " + nameFile + '\n' + "what suit is " + (i + 1) + " card? - ");
                            try {
                                String sM = bufferedReader.readLine();
                                Figura.addM(sM, kodM);
                                Figura.saveM("dm.txt");
                            } catch (IOException e) {
                            }
                        } else {
                            System.out.print(Figura.getM(iM));
                        }
                    }
                }
                System.out.println();
            }
        }
        else
            System.out.println("Browse to the directory with files");
    }

    public static int kodKarta(int x, int y) {
        int kod=0;
        int kodf=0;
        for(int iy = y; iy <y+30; iy++){
            for(int ix = x; ix <x+40; ix++){
                Color c = new Color(img.getRGB(ix, iy));
                if (c.getGreen()<120)
                    kod= kod+ix*iy;
                else
                    kodf++;
            }
        }
        if (kodf<10)
            kod=0;
        return kod;
    }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Src {

    public static void main(String[] args) {

        File vstup = new File("data.txt");

        if (vstup.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(vstup))) {
                String radek;
                String samohlasky   = "aáAÁeéěEÉĚiíIÍyýYÝoóOÓuúůUÚŮ";
                String cislice      = "0123456789";
                String alphaSmall   = "abcčdďefghijklmnňopqrřsštťuúůvwxyzž";
                String alphaCapital = "ABCČDĎEFGHIJKLMNŇOPQRŘSŠTŤUÚŮVWXYZž";
                int pocetRadku      = 0;
                int pocetPoli       = 0;
                int soucetCisel     = 0;
                int pocetSamohlasek = 0;
                int pocetZbytek     = 0;
                int pocetCislic     = 0;
                int pocetVelkych    = 0;
                int pocetMalych     = 0;

                while ((radek = br.readLine()) != null) {
                    pocetRadku++;

                    for (int i = 0; i < radek.length(); i++) {
                        if (samohlasky.indexOf(radek.charAt(i)) != -1) {
                            pocetSamohlasek++;
                            pocetZbytek--;
                        }

                        if (cislice.indexOf(radek.charAt(i)) != -1) {
                            pocetCislic++;
                        }

                        if (alphaSmall.indexOf(radek.charAt(i)) != -1) {
                            pocetMalych++;
                        }

                        if (alphaCapital.indexOf(radek.charAt(i)) != -1) {
                            pocetVelkych++;
                        }
                    }

                    pocetZbytek += radek.length();

                    radek = radek.trim();
                    if (radek.length() > 0) {
                        String[] pole = radek.split(" ");
                        pocetPoli += pole.length;

                        for (int i=0; i<pole.length; i++) {
                            try {
                                int hodnota = Integer.parseInt(pole[i]);
                                soucetCisel += hodnota;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                System.out.println("Počet řádků je: "+pocetRadku);
                System.out.println("Počet polí je: "+pocetPoli);
                System.out.println("Součet čísel je: "+soucetCisel);
                System.out.println("Počet samohlasek je: "+pocetSamohlasek);
                System.out.println("Počet zbývajících znaků: "+pocetZbytek);
                System.out.println("Počet číslic: "+pocetCislic);
                System.out.println("Počet malých znaků: "+pocetMalych);
                System.out.println("Počet velkých znaků: "+pocetVelkych);
            } catch (Exception e) {
                System.out.println("chyba při čtení souboru");
            }
        } else {
            System.out.println("cesta k souboru neexistuje "+vstup);
        }
    }

}

public class Naklady {
    private int numZ;
    private int numOH;
    private int numKM;
    private int sazKM;
    private int sazH;

    public Naklady(int numZ, int numOH, int numKM, int sazKM, int sazH) {
        this.numZ = numZ;
        this.numOH = numOH;
        this.numKM = numKM;
        this.sazKM = sazKM;
        this.sazH = sazH;
    }


    public int FinVysledek() {
        int naklady = numZ * numOH * numKM * sazKM * sazH;
        return naklady;
    }
}

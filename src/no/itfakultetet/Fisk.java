package no.itfakultetet;

public class Fisk extends Dyr implements FiskeMetoder {

    private int antallFinner;
    private boolean spiselig;

    static int antallFisker = 0 ;

    public Fisk() {
        antallFisker++;
    }

    public Fisk(String navn, String art, int antallFinner, boolean spiselig) {
        super(navn, art);
        this.antallFinner = antallFinner;
        this.spiselig = spiselig;
        antallFisker++;
    }

    public int getAntallFinner() {
        return antallFinner;
    }

    public void setAntallFinner(int antallFinner) {
        this.antallFinner = antallFinner;
    }

    public boolean isSpiselig() {
        return spiselig;
    }

    public void setSpiselig(boolean spiselig) {
        this.spiselig = spiselig;
    }

    @Override
    public void svoem() {
        System.out.println(getNavn()+ " svømmer nå...");
    }


    @Override
    public String toString() {
        return "Fisk{" +
                "antallFinner=" + antallFinner +
                ", spiselig=" + spiselig +
                " navn='" + getNavn() + '\'' +
                ", art='" + getArt() + '\'' +
                ", lyd='" + getLyd() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fisk fisk = (Fisk) o;

        if (antallFinner != fisk.antallFinner) return false;
        return spiselig == fisk.spiselig;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + antallFinner;
        result = 31 * result + (spiselig ? 1 : 0);
        return result;
    }
}

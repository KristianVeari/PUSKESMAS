package Entity;

import java.util.ArrayList;

public class PoliEntity {
    private int antrian;
    private String namaPoli;
    public ArrayList<DokterEntity> listDokter;
    public PoliEntity(int antrian,String namaPoli){
        this.antrian = antrian;
        this.namaPoli = namaPoli;
        listDokter = new ArrayList<>();
    }

    public int getAntrian() {
        return antrian;
    }

    public void setAntrian(int antrian) {
        this.antrian = antrian;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public void setNamaPoli(String namaPoli) {
        this.namaPoli = namaPoli;
    }

    public ArrayList<DokterEntity> getALLDokter() {
        return this.listDokter;
    }
}

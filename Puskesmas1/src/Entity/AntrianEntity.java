package Entity;

import Utility.DateString;
import java.util.ArrayList;

public class AntrianEntity {
    private int antri;
    private String namaPoli;
    private String tanggal;
    private ArrayList<PasienEntity> detailPasien;

    public AntrianEntity(int antri, String namaPoli) {
        this.antri = antri;
        this.namaPoli = namaPoli;
        this.tanggal = DateString.now();
        this.detailPasien = new ArrayList<>();
    }

    public int getAntri() {
        return antri;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public String getTanggal(){
        return tanggal;
    }

    public ArrayList<PasienEntity> getAntrianDetails() {
        return detailPasien;
    }

    public void addPasien(PasienEntity pasien) {
        detailPasien.add(pasien);
    }

}
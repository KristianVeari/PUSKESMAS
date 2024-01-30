package Controller;

import java.util.ArrayList;
import Entity.DokterEntity;
import Entity.PoliEntity;
import Model.PoliModel;
public class PoliController {
    private PoliModel poliModel;
    private PoliEntity poliEntity;

    public PoliController() {
        this.poliModel = new PoliModel();
    }

    // Create
    public void insertPoli(int antrian,String namaPoli) {
        poliModel.addPoli(new PoliEntity(antrian,namaPoli));
    }

    // View
    public ArrayList<PoliEntity> viewAllPoli() {
        return poliModel.getAllPoli();
    }


    // Delete
    public void deletePoli(String namaPoli) {
        PoliEntity poli = poliModel.searchPoli(namaPoli);
        if (poli != null) {
            poliModel.deletePoli(poli);
            System.out.println("Poli " + namaPoli + " berhasil dihapus.");
        } else {
            System.out.println("Poli tidak ditemukan");
        }
        poliModel.commitData();
    }




    // Insert Praktek
    public void addDokter(PoliEntity poli, String namaDokter, String spesialis, String hari, String jam) {
        poli.getALLDokter().add(new DokterEntity(namaDokter, spesialis, hari, jam));
    }
    public void insertPraktek(String namaPoli, String namaDokter, String spesialis, String hari, String jam) {
        PoliEntity poli = poliModel.searchPoli(namaPoli);
        if (poli != null) {
            addDokter(poli, namaDokter, spesialis, hari, jam);
            poliModel.updatePoli(namaPoli, poli);
            poliModel.commitData();
            System.out.println("Praktek " + namaDokter + " di Poli " + namaPoli + " berhasil ditambahkan.");
        } else {
            System.out.println("Poli tidak ditemukan");
        }
    }



    // UpdateDokter
    public void updateDokterPoli(ArrayList<DokterEntity> listDokters) {
        if (poliEntity != null) {
            poliEntity.listDokter = listDokters;
        }
    }
    public void updateDokter(String namaPoli, String namaDokter, String prevHariKerja, String newHariKerja, String prevJamKerja, String newJamKerja) {
        PoliEntity poli = poliModel.searchPoli(namaPoli);
        if (poli != null) {
            ArrayList<DokterEntity> listDokter = poli.getALLDokter();
            DokterEntity dokter = poliModel.searchDokter(namaDokter, listDokter);
            if (dokter != null) {
                dokter.setHari(newHariKerja);
                dokter.setJam(newJamKerja);
                updateDokterPoli(listDokter);
                poliModel.commitData();
            } else {
                System.out.println("Dokter Tidak Ditemukan");
            }
        } else {
            System.out.println("Poli Tidak Ditemukan");
        }
    }
    //cari data poli
    public PoliEntity searchPoli(String namaPoli) {
        return poliModel.searchPoli(namaPoli);
    }

}


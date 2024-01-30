package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Entity.PasienEntity;
import Entity.PoliEntity;
import ModelGson.GsonModel;
import com.google.gson.reflect.TypeToken;

import Entity.PasienEntity;
import Entity.PoliEntity;
import ModelGson.GsonModel;

public class PasienModel {
    ArrayList<PasienEntity> listPasien;
    GsonModel<PasienEntity> modelGsonPasien = new GsonModel<>("src/Database/DatabasePasien.json");
    PoliModel poliModel;


    public PasienModel() {
        this.listPasien = new ArrayList<PasienEntity>();
        this.poliModel = new PoliModel();
        loadData();
    }

    public void addPasien(PasienEntity pasien) {
        listPasien.add(pasien);
        commitData();
    }

    public ArrayList<PasienEntity> getAllPasien() {
        return listPasien;
    }

    //cetak struck
    public PasienEntity searchPasien(String nama) {
        for (PasienEntity pasien : listPasien) {
            if (pasien.getNama().equalsIgnoreCase(nama)) {
                return pasien;
            }
        }
        return null;
    }

    public int ambilAntrian(String namaPoli) {
        ArrayList<PoliEntity> listPoli = poliModel.getAllPoli();
        int nomorAntrian = -1;

        for (PoliEntity poli : listPoli) {
            if (poli.getNamaPoli().equalsIgnoreCase(namaPoli)) {
                nomorAntrian = poli.getAntrian() + 1;
                poli.setAntrian(nomorAntrian);
                poliModel.commitData();

                break;
            }
        }
        return nomorAntrian;
    }
    public void loadData() {
        listPasien = modelGsonPasien.readFromFile(new TypeToken<ArrayList<PasienEntity>>() {
        }.getType());
    }

    public void commitData() {
        modelGsonPasien.WriteToFile(listPasien);
    }
}
// public void updatePasien(String nik, PasienEntity pasien) {
//     listPasien.contains(pasien);
//     commitData();
// }
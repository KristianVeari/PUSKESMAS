package Controller;

import Entity.AntrianEntity;
import Entity.PasienEntity;
import Entity.PoliEntity;
import Model.AntrianModel;
import Model.PasienModel;
import Model.PoliModel;
public class PasienController {
    private PasienModel pasienModel;
    private PoliModel poliModel;
    AntrianModel antrianModel;
    PoliEntity poliEntity;

    public PasienController() {
        this.pasienModel = new PasienModel();
        this.poliModel = new PoliModel();
        this.antrianModel = new AntrianModel();
    }

    // Create
    public void insertPasien(String nik, String namaPasien, String kelamin, String alamat, String bpjs) {
        pasienModel.addPasien(new PasienEntity(namaPasien, kelamin, nik, alamat, bpjs));
    }

    public int ambilAntrian(String namaPoli, String nik) {
        return pasienModel.ambilAntrian(namaPoli);
    }

    //cetak struk
    public PasienEntity searchPasien(String nik) {
        for (PasienEntity pasien : pasienModel.getAllPasien()) {
            if (pasien.getNik().equalsIgnoreCase(nik) || pasien.getBpjs().equalsIgnoreCase(nik)) {
                return pasien;
            }
        }
        return null;
    }

    public void addAntrian(String namaPoli, PasienEntity pasienEntity) {
        poliModel.loadData();
        PoliEntity poliEntity = poliModel.searchPoli(namaPoli);
        if (poliEntity != null) {
            AntrianEntity antrian = new AntrianEntity(poliEntity.getAntrian(), namaPoli);
            antrian.addPasien(pasienEntity);
            antrianModel.addAntrian(antrian);
        }
    }

    public AntrianEntity searchAntrian(int nomorAntrian, String namaPoli) {
        return antrianModel.searchAntrian(nomorAntrian, namaPoli);
    }

}

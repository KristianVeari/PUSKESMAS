package Controller;

import java.util.ArrayList;
import ModelGson.GsonModel;
import com.google.gson.reflect.TypeToken;
import Entity.AdminEntity;
import Entity.PasienEntity;
import View.AdminView;
import View.PasienView;

public class LoginController {
    private AdminView adminView;
    private PasienView pasienView;

    public LoginController() {
        this.adminView = new AdminView();
        this.pasienView = new PasienView();
    }

    public void loginAdmin(String username, String password) {
        ArrayList<AdminEntity> listAdmin = new GsonModel<AdminEntity>("src/Database/DatabaseAdmin.json")
                .readFromFile(new TypeToken<ArrayList<AdminEntity>>() {
                }.getType());
        if (listAdmin != null) {
            for (AdminEntity admin : listAdmin) {
                if (admin.getUsername().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
                    adminView.MenuAdmin();
                    return;
                }
            }
        }
        System.out.println("Username atau Password Salah");
    }

    public void loginPasien(String nik) {
        ArrayList<PasienEntity> listPasien = new GsonModel<PasienEntity>("src/Database/DatabasePasien.json")
                .readFromFile(new TypeToken<ArrayList<PasienEntity>>() {
                }.getType());

        if (listPasien != null) {
            for (PasienEntity pasien : listPasien) {
                if (pasien.getNik().equalsIgnoreCase(nik)|| pasien.getBpjs().equalsIgnoreCase(nik)) {
                    pasienView.MenuPasien(nik);
                    return;
                }
            }
            System.out.println("NIK atau BPJS tidak terdaftar");
        }
    }
}

package View;

import java.util.Scanner;
import Controller.LoginController;
import Controller.PasienController;
public class MenuView {
    public void MainMenu() {
        PasienController pasienController = new PasienController();
        LoginController loginController = new LoginController();

        Scanner input = new Scanner(System.in);

        int opsi = 0;
        do {
            try {
                System.out.println("=========================");
                System.out.println("| \t   Menu\t\t|");
                System.out.println("| 1. Input Data Pasien\t|");
                System.out.println("| 2. Ambil Antrian\t|");
                System.out.println("| 3. Login Admin\t|");
                System.out.println("| 4. Keluar\t\t|");
                System.out.println("=========================");
                System.out.print("Masukkan Pilihan: ");
                opsi = input.nextInt();

                switch (opsi) {
                    case 1:
                        input.nextLine();
                        System.out.println("=========================");
                        System.out.print("Masukkan NIK\t\t: ");
                        String nik = input.nextLine();
                        System.out.print("Masukkan Nama\t\t: ");
                        String nama = input.nextLine();
                        System.out.print("Masukkan Alamat\t\t:");
                        String alamat = input.nextLine();
                        System.out.print("Masukkan Jenis Kelamin\t: ");
                        String kelamin = input.nextLine();
                        System.out.print("Masukkan BPJS (Jika ada): ");
                        String bpjs = input.nextLine();
                        System.out.println("=========================");
                        pasienController.insertPasien(nik, nama, kelamin, alamat, bpjs);
                        break;
                    case 2:
                        input.nextLine();
                        System.out.print("Masukkan NIK atau BPJS: ");
                        nik = input.nextLine();
                        loginController.loginPasien(nik);
                        break;
                    case 3:
                        input.nextLine();
                        System.out.println("=========================");
                        System.out.print("Masukkan Username: ");
                        String username = input.nextLine();
                        System.out.print("Masukkan Password: ");
                        String password = input.nextLine();
                        System.out.println("=========================");
                        loginController.loginAdmin(username, password);
                        break;
                    case 4:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan.");
                input.nextLine();
            }
        } while (opsi != 4);
    }
}

package View;

import java.util.ArrayList;
import java.util.Scanner;
import Entity.AntrianEntity;
import Entity.DokterEntity;
import Entity.PasienEntity;
import Entity.PoliEntity;
import Controller.PasienController;
import Controller.PoliController;

public class AdminView {
    PoliController poliController;
    PasienController pasienController;

    public AdminView() {
        this.poliController = new PoliController();
        this.pasienController = new PasienController();
    }

    public void MenuAdmin() {
        Scanner input = new Scanner(System.in);
        int pilih = 0;
        do {
            try {
                System.out.println("================================");
                System.out.println("|  Menu Admin\t\t|");
                System.out.println("| 1. Tambah Poli\t\t|");
                System.out.println("| 2. Tambah Jadwal Praktek\t|");
                System.out.println("| 3. Update Jadwal Praktek\t|");
                System.out.println("| 4. Hapus Poli\t\t\t|");
                System.out.println("| 5. Lihat Data Poli\t\t|");
                System.out.println("| 6. Cetak Struk\t\t|");
                System.out.println("| 7. Logout\t\t\t|");
                System.out.println("=================================");
                System.out.print("Masukkan Pilihan : ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1:
                        input.nextLine();
                        System.out.println("=========================");
                        System.out.println("Masukkan Nama Poli : ");
                        String poli = input.nextLine();
                        int antrian = 0;
                        System.out.println("=========================");
                        poliController.insertPoli(antrian, poli);
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("=========================");
                        System.out.println("Masukkan nama poli");
                        String namaPoli = input.nextLine();
                        poliController.searchPoli(namaPoli);
                        if (poliController.searchPoli(namaPoli) == null) {
                            System.out.println("Poli Tidak Ditemukan");
                        } else {
                            System.out.println("nama dokter");
                            String dokter = input.nextLine();
                            System.out.println("Masukkan spesialis");
                            String spesialis = input.nextLine();
                            System.out.println("Hari kerja");
                            String hari = input.nextLine();
                            System.out.println("Jam kerja");
                            String jam = input.nextLine();
                            System.out.println("=========================");
                            poliController.insertPraktek(namaPoli, dokter, spesialis, hari, jam);
                        }
                        break;
                    case 3:
                        System.out.println("=========================");
                        System.out.println("- Update Praktek Dokter -");
                        input.nextLine();
                        System.out.print("Masukkan Nama Poli : ");
                        namaPoli = input.nextLine();
                        if (poliController.searchPoli(namaPoli) == null) {
                            System.out.println("Poli Tidak Ditemukan");
                        } else {
                            System.out.print("Masukkan Nama Dokter Yang ingin Diubah : ");
                            String namaDokter = input.nextLine();
                            System.out.print("Masukkan Hari Kerja Baru : ");
                            String newHariKerja = input.nextLine();
                            System.out.print("Masukkan Jam Kerja Baru : ");
                            String newJamKerja = input.nextLine();
                            poliController.updateDokter(namaPoli, namaDokter, newHariKerja, newHariKerja, newJamKerja,
                                    newJamKerja);
                            System.out.println("=========================");
                        }
                        break;
                    case 4:
                        System.out.println("=========================");
                        System.out.println("-Hapus Poli - ");
                        input.nextLine();
                        System.out.println("Masukkan Nama Poli : ");
                        namaPoli = input.nextLine();
                        poliController.deletePoli(namaPoli);
                        break;
                    case 5:
                        System.out.println("=========================");
                        ArrayList<PoliEntity> allPoli = poliController.viewAllPoli();
                        if (!allPoli.isEmpty()) {
                            System.out.println("- Data Poli dan Dokter -");
                            for (PoliEntity polilist : allPoli) {
                                System.out.println("Nama Poli: " + polilist.getNamaPoli());

                                System.out.println("----Dokter----");
                                for (DokterEntity dokters : polilist.getALLDokter()) {
                                    System.out.println("Nama Dokter  :" + dokters.getNamaDokter());
                                    System.out.println("Spesialis    :" + dokters.getSpesialis());
                                    System.out.println("Hari Kerja   :" + dokters.getHari());
                                    System.out.println("Jam Kerja    :" + dokters.getJam());
                                }
                            }
                        } else {
                            System.out.println("Belum ada data poli.");
                        }
                        System.out.println("=========================");
                        break;
                    case 6:
                        input.nextLine();
                        System.out.println("=========================");
                        System.out.print("Masukkan Nama Poli\t: ");
                        namaPoli = input.nextLine();
                        System.out.print("Masukkan Nomor Antrian\t: ");
                        int nomorAntrian = input.nextInt();
                        AntrianEntity Antrian = pasienController.searchAntrian(nomorAntrian, namaPoli);

                        if (Antrian != null) {
                            System.out.println("=== Antrian Details ===");
                            System.out.println("Nomor Antrian\t:" + Antrian.getAntri());
                            System.out.println("Nama Poli\t:" + Antrian.getNamaPoli());
                            System.out.println("Tanggal \t:" + Antrian.getTanggal());

                            ArrayList<PasienEntity> antrianDetails = Antrian.getAntrianDetails();
                            for (PasienEntity pasien : antrianDetails) {
                                System.out.println("NIK\t\t:" + pasien.getNik());
                                System.out.println("Nama Pasien\t:" + pasien.getNama());
                                System.out.println("BPJS\t\t:" + pasien.getBpjs());
                            }
                        } else {
                            System.out.println("Antrian Tidak Ditemukan");
                        }
                        System.out.println("=========================");
                        break;
                    case 7:
                        System.out.println("Log Out");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                input.nextLine();
            }
        } while (pilih != 7);
    }
}

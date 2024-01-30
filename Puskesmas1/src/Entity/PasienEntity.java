package Entity;

public class PasienEntity {
    private String nama;
    private String kelamin;
    private String alamat;
    private String nik;
    private String bpjs;
    public PasienEntity(String nama,String kelamin,String alamat,String nik,String bpjs){
        this.nama = nama;
        this.kelamin = kelamin;
        this.alamat = alamat;
        this.nik = nik;
        this.bpjs = bpjs;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getBpjs() {
        return bpjs;
    }

    public void setBpjs(String bpjs) {
        this.bpjs = bpjs;
    }
}

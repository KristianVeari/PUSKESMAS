package Entity;

public class DokterEntity {
    private String namaDokter;
    private String spesialis;
    private String hari;
    private String jam;
    public DokterEntity(String namaDokter,String spesialis,String hari,String jam){
        this.namaDokter= namaDokter;
        this.spesialis = spesialis;
        this.hari = hari;
        this.jam = jam;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}

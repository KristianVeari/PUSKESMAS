package Model;

import java.util.ArrayList;
import Entity.AntrianEntity;
import com.google.gson.reflect.TypeToken;
import Entity.AntrianEntity;
import ModelGson.GsonModel;
public class AntrianModel {
    private ArrayList<AntrianEntity> listAntrian;
    private GsonModel<AntrianEntity> modelGsonAntrian;

    public AntrianModel() {
        listAntrian = new ArrayList<>();
        modelGsonAntrian = new GsonModel<>("src/Database/DatabaseAntrian.json");
        loadData();
    }

    public void addAntrian(AntrianEntity antrian) {
        listAntrian.add(antrian);
        commitData();
    }

    public ArrayList<AntrianEntity> getAllAntrian() {
        return listAntrian;
    }

    public AntrianEntity searchAntrian(int nomorAntrian, String namaPoli) {
        for (AntrianEntity antrian : listAntrian) {
            if (antrian.getAntri() == nomorAntrian && antrian.getNamaPoli().equalsIgnoreCase(namaPoli)) {
                return antrian;
            }
        }
        return null;
    }

    public void loadData() {
        listAntrian = modelGsonAntrian.readFromFile(new TypeToken<ArrayList<AntrianEntity>>() {}.getType());
    }

    public void commitData() {
        modelGsonAntrian.WriteToFile(listAntrian);
    }
}

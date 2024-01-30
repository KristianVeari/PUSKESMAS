package Model;

import java.util.ArrayList;

import Entity.AdminEntity;
import Entity.AdminEntity;
import ModelGson.GsonModel;

import com.google.gson.reflect.TypeToken;
public class AdminModel {
    ArrayList<AdminEntity> listAdmin;
    GsonModel<AdminEntity> modelGSONAdmin = new GsonModel<>("src/Database/DatabaseAdmin.json");

    public AdminModel(){
        listAdmin = new ArrayList<AdminEntity>();
        loadData();
    }

    public void addAdmin(AdminEntity Admin) {
        listAdmin.add(Admin);
        commitData();
    }

    private void loadData(){
        listAdmin = modelGSONAdmin.readFromFile(new TypeToken<ArrayList<AdminEntity>>()
        {}.getType());
    }

    public void commitData(){
        modelGSONAdmin.WriteToFile(listAdmin);
    }
}

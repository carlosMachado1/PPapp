package BancoDeProvas;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Read {
    public ArrayList<Prova> deserialize(String path) throws Exception{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Prova> provas;

        provas  = (ArrayList<Prova>)ois.readObject();

        ois.close();
        fis.close();

        return provas;
    }
}

package BancoDeProvas;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public interface Read {
    public ArrayList<Prova> deserialize(String path) throws Exception;
}

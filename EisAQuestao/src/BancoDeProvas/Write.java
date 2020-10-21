package BancoDeProvas;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Write {
    public void serialize(String path, Object obj) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(obj);

        oos.close();
        fos.close();
    }
}
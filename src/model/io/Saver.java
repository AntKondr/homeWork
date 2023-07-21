package model.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import model.interfaces.Saveable;
import model.interfaces.Writer;

public class Saver implements Writer {
    String pathName;

    public Saver(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void writeObj(Saveable obj) throws IOException {
        pathName = pathName + obj.getFileExt();
        ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(pathName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}
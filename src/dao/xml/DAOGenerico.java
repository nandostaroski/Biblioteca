package dao.xml;

import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import dao.interfaces.DAOInterface;

public abstract class DAOGenerico implements DAOInterface {

    private File verificaArquivo(String diretorio) throws IOException {
        File arquivo = new File(diretorio);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        return arquivo;
    }

    public <K, V> void salvarArquivo(HashMap<K, V> map, String endereco) throws IOException {
        FileOutputStream fos = new FileOutputStream(verificaArquivo(endereco));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        XMLEncoder xmlenc = new XMLEncoder(bos);
        xmlenc.setPersistenceDelegate(LocalDate.class,
                new PersistenceDelegate() {
            @Override
            protected Expression instantiate(Object localDate, Encoder encdr) {
                return new Expression(localDate,
                        LocalDate.class,
                        "parse",
                        new Object[]{localDate.toString()});
            }
        });
        xmlenc.writeObject(map);
        xmlenc.close();
    }

    public <K, V> HashMap<K, V> carregarArquivo(String endereco) throws IOException {
        HashMap<K, V> map = new HashMap<>();
        FileInputStream inputStream = null;
        BufferedInputStream buffer = null;
        XMLDecoder xmldec = null;
        try {
            inputStream = new FileInputStream(endereco);
            buffer = new BufferedInputStream(inputStream);
            xmldec = new XMLDecoder(buffer);
            map = (HashMap<K, V>) xmldec.readObject();
        } finally {
            if (buffer != null) {
                buffer.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (xmldec != null) {
                xmldec.close();
            }
        }
        return map;
    }

}

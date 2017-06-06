package dao.interfaces;

import java.io.IOException;
import java.util.HashMap;

public interface DAOInterface {

    public abstract <K, V> HashMap<K, V> ler() throws IOException;

    public abstract <K, V> void salvar(HashMap<K, V> map) throws IOException;
}

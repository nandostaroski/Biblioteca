package dao.binario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import dao.interfaces.InterfaceDAO;

public abstract class DAOGenerico implements InterfaceDAO {

	private File verificaArquivo(String diretorio) throws IOException {
		File arquivo = new File(diretorio);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		return arquivo;
	}

	public <K, V> HashMap<K, V> carregarArquivo(String endereco) throws IOException {
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		HashMap<K, V> map = new HashMap<>();

		File file = verificaArquivo(endereco);
		if (file.length() > 0) {
			try {
				fileInputStream = new FileInputStream(file);
				objectInputStream = new ObjectInputStream(fileInputStream);
				try {
					map = (HashMap<K, V>) objectInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				if (objectInputStream != null) {
					objectInputStream.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			}
		}

		return map;
	}

	public <K, V> void salvarArquivo(HashMap<K, V> map, String endereco) throws IOException {
		FileOutputStream stream = null;
		ObjectOutputStream objectStream = null;

		try {
			File arquivo = verificaArquivo(endereco);
			stream = new FileOutputStream(arquivo);
			objectStream = new ObjectOutputStream(stream);
			objectStream.writeObject(map);
		} finally {
			stream.close();
			objectStream.close();
		}

	}

}

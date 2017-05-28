package dao.binario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public abstract class DAOBinarioGenerico {

	private File verificaArquivo(String diretorio) throws IOException {
		File arquivo = new File(diretorio);
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		return arquivo;
	}

	public <K, V> HashMap<K, V> carregarArquivo(String endereco) {
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		HashMap<K, V> map = new HashMap<>();
		try {
			File file = verificaArquivo(endereco);
			if (file.length() > 0) {
				try {
					fileInputStream = new FileInputStream(file);
					objectInputStream = new ObjectInputStream(fileInputStream);
					map = (HashMap<K, V>) objectInputStream.readObject();
				} finally {
					if (objectInputStream != null) {
						objectInputStream.close();
					}
					if (fileInputStream != null) {
						fileInputStream.close();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public <K, V> void salvarArquivo(HashMap<K, V> map, String endereco) {
		FileOutputStream stream = null;
		ObjectOutputStream objectStream = null;
		try {
			try {
				File arquivo = verificaArquivo(endereco);
				stream = new FileOutputStream(arquivo);
				objectStream = new ObjectOutputStream(stream);
				objectStream.writeObject(map);
			} finally {
				stream.close();
				objectStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract <K, V> HashMap<K, V> ler() throws Exception;

	public abstract <K, V> void salvar(HashMap<K, V> map) throws Exception;
}

package dao.binario;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Exemplar;
import modelo.Livro;

public class LivroDao extends DAOBinarioGenerico {

	public HashMap<Integer, Livro> importarLivros() {

		HashMap<Integer, Livro> livros = new HashMap<Integer, Livro>();
		String pastaDestino = System.getProperty("user.home") + System.getProperty("file.separator") + "livros.csv";
		int contadorExemplar = 0;
		int contadorLivro = 0;
		Scanner teclado = null;
		String linha;
		String[] colunas;

		try {

			teclado = new Scanner(new File(pastaDestino));

			while (teclado.hasNext()) {

				linha = (String) teclado.nextLine();

				if (linha.contains("codigoDeBarras")) {
					continue;
				} else {
					colunas = linha.split("\\|");
					if (colunas.length == 13) {
						if (colunas[1] != null && livros.get(Integer.parseInt(colunas[1])) != null) {
							((Livro) livros.get(Integer.parseInt(colunas[1])))
									.AdicionaExemplar(new Exemplar(colunas[0], colunas[2], colunas[3]));
							contadorLivro++;
						} else {
							Livro livro = new Livro(colunas[0], colunas[1], colunas[2], colunas[3], colunas[4],
									colunas[5], colunas[6], colunas[7], colunas[8], colunas[9], colunas[10],
									colunas[11], colunas[12]);
							livros.put(livro.getIdLivro(), livro);
						}
						contadorExemplar++;
					}
				}

			}

		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			teclado.close();
		}

		System.out.printf("Foram importados %s livros e %s exemplares." + "\r\n", contadorLivro, contadorExemplar);
		return livros;
	}

	@Override
	public <K, V> HashMap<K, V> ler() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> void salvar(HashMap<K, V> map) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

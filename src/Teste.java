import java.util.HashMap;

import dao.xml.LivroDao;
import modelo.Livro;

public class Teste {

	public static void main(String[] args) throws Exception {
		LivroDao dao = new LivroDao();
		HashMap<Integer, Livro> importarLivros = dao.importarLivros();

		importarLivros.forEach((id, livro) -> {
			System.out.println(livro);
			livro.getExemplares().forEach((cdBar, exemplar) -> System.out.println(exemplar.getExemplar()));
		});

	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//
// --------------- Analisador Léxico ---------------
//	Autor : Mateus Santos Costa
//	e-mail: mateus.costa@estudante.ifb.edu.br
//	
//
public class AnalisadorLexico {

	public static int compara(String parametro) {
		// Controla em qual coluna o erro possa ocorrer

		switch (parametro) {
		case "Program":
			return 1;
		case "Pgrau":
			return 1;
		case ";":
			return 1;
		case "Var":
			return 1;
		case "Y":
			return 1;
		case ",":
			return 1;
		case "x":
			return 1;
		case ":":
			return 1;
		case "real":
			return 1;
		case "Const":
			return 1;
		case "A":
			return 1;
		case "=":
			return 1;
		case "2":
			return 1;
		case "B":
			return 1;
		case "3":
			return 1;
		case "(":
			return 1;
		case ")":
			return 1;
		case "y":
			return 1;
		case ":=":
			return 1;
		case "a":
			return 1;
		case "*":
			return 1;
		case "+":
			return 1;
		case "b":
			return 1;
		case "Write":
			return 1;
		case "End":
			return 1;
		case ".":
			return 1;
		case "Begin":
			return 1;
		case "Read":
			return 1;
		case "":
			return 1;
		default:
			return 0;
		}
	}

	public static void leitor(String path) throws IOException {

		// Inicializando Leitor do arquivo
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		// Lista que separará o .txt em 'linhas'
		List<String> linhas = new ArrayList<String>();

		// leitura do arquivo
		while (linha != null) {
			linha = buffRead.readLine();
			if (linha != null)
				// adiciona na Lista as linhas do .txt
				linhas.add(linha);
		}
		buffRead.close();

		// String que receberá a transformação de cada linha em colunas
		String[] colum = new String[11];

		int verificador = 0;
		int msg=0;
		for (int i = 0; i < linhas.size(); i++) {
			// "quebra" de linha em colunas
			colum = linhas.get(i).split(" ");
			// System.out.println("Coluna: " + i);
			int j = 0;
			for (String parametro : colum) {
				//System.out.println(parametro);
				verificador = compara(parametro);
				// controlLinha++;
				j++;
				if (verificador != 1) {
					System.out.println("Erro na linha: " + (i + 1) + " Coluna: " + j);
					msg=1;
					continue;
				}

			}
		}
		if(msg ==0)
		{
			System.out.println("Análise Léxica conlcuída com sucesso");
		}
	}
}

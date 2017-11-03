import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {

		leitura();

	}

	public static void leitura() {
		LinkedStackOfInteger c = new LinkedStackOfInteger();
		Path path1 = Paths.get("exemplo6.txt");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.defaultCharset()))) {

			// sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
			int i = 0;
			int a = 0;
			int b = 0;
			String linhaString = "";
			int maior = 0;
			while (sc.hasNext()) {
				linhaString = sc.next();

				try {

					i = Integer.parseInt(linhaString);
					c.push(i);
					
					if (c.size() > maior) {
						maior = c.size();
					}					
					
				} catch (NumberFormatException e) {

					if (linhaString.equals("+")) {
						a = c.pop();
						b = c.pop();
						c.push(a + b);
						// System.out.println("Soma: ");
						// System.out.println(a + " + " + b);
					}
					if (linhaString.equals("-")) {
						a = c.pop();
						b = c.pop();
						c.push(a - b);
						// System.out.println("Subtração: ");
						// System.out.println(a + " - " + b);

					}
					if (linhaString.equals("*")) {
						a = c.pop();
						b = c.pop();
						c.push(a * b);
						// System.out.println("Multiplicação: ");
						// System.out.println(a + " * " + b);

					}
					if (linhaString.equals("/")) {
						a = c.pop();
						b = c.pop();
						c.push(a / b);
						// System.out.println("Divisão: ");
						// System.out.println(a + " / " + b);

					}

					if (linhaString.equals("pop")) {
						c.pop();
						// System.out.println("POP: ");
						// System.out.println(c.pop());

					}

					if (linhaString.equals("dup")) {
						c.push(c.top());
						// System.out.println("DUP: ");
						// System.out.println(c.top());

					}

					if (linhaString.equals("swap")) {
						a = c.pop();
						b = c.pop();
						c.push(a);
						c.push(b);

					}

					if (linhaString.equals("chs")) {
						int troca = c.pop() * (-1);
						c.push(troca);
						// System.out.println("Chs: ");
						// System.out.println();

					}

					if (linhaString.equals("sqrt")) {
						Math.sqrt(c.top());
						// System.out.println();

					}

					// System.out.println(sc.next());
				}

			}

			if (c.size() != 1) {
				System.out.println("Mais de um resultado na pilha");
			}
			
			System.out.println("Resultado no topo da pilha: " + c.top());
			System.out.println("Tamanho maximo da pilha: " + maior);
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
}

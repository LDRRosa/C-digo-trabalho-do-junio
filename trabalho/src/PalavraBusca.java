import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalavraBusca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto ;
        String palavra ;
        System.out.println("Digite o texto");
        texto=scanner.nextLine();
        System.out.println("Digite a palavra que quer buscar");
        palavra=scanner.nextLine();
        scanner.close();

        
        List<Integer> ocorrencias = encontrarOcorrencias(texto, palavra);
        
        
        if (ocorrencias.isEmpty()) {
            System.out.println("Palavra não encontrada no texto.");
        } else {
            String textoGrifado = destacarPalavra(texto, palavra);
            System.out.println(textoGrifado);
        }
    }

    public static List<Integer> encontrarOcorrencias(String texto, String palavra) {
        List<Integer> posicoes = new ArrayList<>();
        int n = texto.length();
        int m = palavra.length();
        int l = 0;
        
        while (l <= n - m) {
            int i = 0;
            boolean teste = true;
            
            // Verificar se palavra ocorre na posição atual
            while (i < m && teste) {
                if (texto.charAt(l + i) == palavra.charAt(i)) {
                    i++;
                } else {
                    teste = false;
                }
            }
            
            if (teste) {
                posicoes.add(l); // Adicionar posição encontrada
                l += m; // Avançar além da palavra encontrada para evitar sobreposição
            } else {
                l++;
            }
        }
        
        return posicoes;
    }
    public static String destacarPalavra(String texto, String palavra) {
        // Adicionando a formatação para destacar a palavra
        String palavraGrifada = "**"+palavra.toUpperCase() + "**"; // Você pode usar outra formatação como <b></b> para HTML
        String textoModificado = texto.replaceAll("\\b" + palavra + "\\b", palavraGrifada);
        
        return textoModificado;
    }
}


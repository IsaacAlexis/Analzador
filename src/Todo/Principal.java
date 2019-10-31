
package Todo;

import JFlex.anttask.JFlexTask;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alexis Maldonado88
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 ="C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/Lexer.flex";
        String ruta2 ="C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/sym.java"),
                Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/sym.java")
        );
        
        Path rutaSin = Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/Sintax.java"),
                Paths.get("C:/Users/Jose Luis/Documents/NetBeansProjects/Analizador Lexico/src/Todo/Sintax.java")
        );
    }
    
}

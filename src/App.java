import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Nom du controller:\n>");
            String nom = scan.next();
            System.out.print("Choisir le modele de controller:\n1) Spring MVC\n2) Java Flamework\n3) C# .NET\n>");
            int modele = scan.nextInt();
            Template temps = null;
            String configPath;
            Constantes constantes = null;
            Langage[] langages;
            Langage langage = null;
            switch (modele) {
                case 1:
                    configPath = "data/springControllerApp.config";
                    constantes = new Constantes(configPath);
                    langages = Langage.getAllLangages(constantes);
                    langage = Langage.getLangageByName(langages, "java");
                    assert langage != null;
                    temps = langage.getSpringControllerTemplate(constantes);
                    break;
                case 2:
                    configPath = "data/flameworkController.config";
                    constantes = new Constantes(configPath);
                    langages = Langage.getAllLangages(constantes);
                    langage = Langage.getLangageByName(langages, "java");
                    assert langage != null;
                    temps = langage.getFlameworkTemplate(constantes);
                    break;
                case 3:
                    configPath = "data/csControllerApp.config";
                    constantes = new Constantes(configPath);
                    langages = Langage.getAllLangages(constantes);
                    langage = Langage.getLangageByName(langages, "csharp");
                    assert langage != null;
                    temps = langage.getCsControllerTemplate(constantes);
                    break;
            }
            if (temps instanceof CsControllerTemplate) {
                ((CsControllerTemplate) temps).formatStructure(nom, langage);
                ((CsControllerTemplate) temps).generate(nom, constantes, langage);
            } else if (temps instanceof FlameworkTemplate) {
                ((FlameworkTemplate) temps).formatStructure(nom, langage);
                ((FlameworkTemplate) temps).generate(nom, constantes, langage);
            } else if (temps != null) {
                ((SpringControllerTemplate) temps).formatStructure(nom, langage);
                ((SpringControllerTemplate) temps).generate(nom, constantes, langage);
            }
        }
    }
}

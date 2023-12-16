import java.util.Scanner;

public class CsControllerApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Generate REST controller");
        String configPath="";
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Modele:\n");
            System.out.println("1) C#\n2) Flamework\n");
            int modele = scan.nextInt();
            configPath = switch (modele) {
                case 1 -> "data/csControllerApp.config";
                case 2 -> "data/flameworkController.config";
                default -> "data/app.config";
            };
            Constantes constantes = new Constantes(configPath);
            System.out.print("Langage:\n>");
            Langage[] langages = Langage.getAllLangages(constantes);
            for (int i = 1; i <= langages.length; i++) {
                System.out.println(i + ")" + langages[i - 1].getNom());
            }
            int indexLang = scan.nextInt() - 1;
            Langage cs = langages[indexLang];
            System.out.print("Controller name :\n>");
            String nameController = scan.next();
            Template temps = switch (modele) {
                case 1 -> cs.getCsControllerTemplate(constantes);
                case 2 -> cs.getFlameworkTemplate(constantes);
                default -> null;
            };
            if (temps instanceof CsControllerTemplate) {
                ((CsControllerTemplate) temps).formatStructure(nameController, cs);
                ((CsControllerTemplate) temps).generate(nameController, constantes, cs);
            } else if (temps != null) {
                ((FlameworkTemplate) temps).formatStructure(nameController, cs);
                ((FlameworkTemplate) temps).generate(nameController, constantes, cs);
            }
        }
    }
}

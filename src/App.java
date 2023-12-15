import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        try{    
            System.out.print("Nom du controller:\n>");
            String nom=scan.next();
            System.out.print("Choisir le modele de controller:\n1) Spring\n2) Flamework\n3) .NET\n>");
            int modele=scan.nextInt();
            Template temps=null;
            String configPath=null;
            Constantes constantes=null;
            Langage[] langages=null;
            Langage langage=null;
            switch(modele){
                case 2:
                    configPath="data/flameworkController.config";
                    constantes=new Constantes(configPath);
                    langages=Langage.getAllLangages(constantes);
                    langage=langages[1];
                    temps=langage.getFlameworkTemplate(constantes);
                    break;
                case 3:
                    configPath="data/csControllerApp.config";
                    constantes=new Constantes(configPath);
                    langages=Langage.getAllLangages(constantes);
                    langage=langages[0];
                    temps=langage.getCsControllerTemplate(constantes);
                    break;
            }
            if(temps instanceof CsControllerTemplate){
                ((CsControllerTemplate)temps).formatStructure(nom, langage);
                ((CsControllerTemplate)temps).generate(nom, constantes, langage);
            }else if(temps instanceof FlameworkTemplate){
                ((FlameworkTemplate)temps).formatStructure(nom, langage);
                ((FlameworkTemplate)temps).generate(nom, constantes, langage);
            }
        }finally{
            scan.close();
        }
    }
}

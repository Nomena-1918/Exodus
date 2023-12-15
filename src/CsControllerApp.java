import java.util.Scanner;

public class CsControllerApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Generate REST controller");
        String configPath="";
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("Modele:\n");
            System.out.println("1) C#\n2) Flamework\n");
            int modele=scan.nextInt();
            switch(modele){
                case 1:
                    configPath="data/csControllerApp.config";
                    break;
                case 2:
                    configPath="data/flameworkController.config";
                    break;
                default:
                    configPath="data/app.config";
            }
            Constantes constantes=new Constantes(configPath);
            System.out.print("Langage:\n>");
            Langage[] langages=Langage.getAllLangages(constantes);
            for(int i=1;i<=langages.length;i++){
                System.out.println(i+")"+langages[i-1].getNom());
            }
            int indexLang=scan.nextInt()-1;
            Langage cs = langages[indexLang];
            System.out.print("Controller name :\n>");
            String nameController = scan.next();
            Template temps=null;
            switch(modele){
                case 1:
                    temps=cs.getCsControllerTemplate(constantes);
                    break;
                case 2:
                    temps=cs.getFlameworkTemplate(constantes);
                    break;
            }
            if(temps instanceof CsControllerTemplate){
                ((CsControllerTemplate)temps).formatStructure(nameController, cs);
                ((CsControllerTemplate)temps).generate(nameController, constantes, cs);
            }else if(temps instanceof FlameworkTemplate){
                ((FlameworkTemplate)temps).formatStructure(nameController, cs);
                ((FlameworkTemplate)temps).generate(nameController, constantes, cs);
            }
        }finally{
            scan.close();
        }
    }
}

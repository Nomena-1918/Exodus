import java.util.Scanner;

public class SpringControllerApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Generate Spring REST controller");
        Constantes constantes=new Constantes("data_exodus/springControllerApp.config");
        Langage[] langages=Langage.getAllLangages(constantes);
        Scanner scan=new Scanner(System.in);
        System.out.print("Langage:\n>");
        int i = 1;
        for(Langage l : langages){
            System.out.println(i+")"+l.getNom());
            i++;
        }
        int indexLang=scan.nextInt() - 1;
        Langage cs = langages[indexLang];
        System.out.print("Controller name :\n>");
        String nameController = scan.next();
        SpringControllerTemplate temps=cs.getSpringControllerTemplate(constantes);
        try{
            temps.formatStructure(nameController, cs);
            temps.generate(nameController, constantes, cs);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

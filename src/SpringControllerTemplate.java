import java.io.File;
import java.io.IOException;
import java.util.Map;
import veda.godao.utils.StringUtils;

public class SpringControllerTemplate extends Template {
    public void formatAttrBehavior(String nameController, Langage langage){
        String struct=getStructure();

        for(Map.Entry<String, String> e:langage.getParams().entrySet()){
            struct=struct.replace(e.getKey(), e.getValue());
        }
        //struct=struct.replace("min-ame", StringUtils.majStart(nameController));
        struct=struct.replace("class-name", StringUtils.majStart(nameController));
        struct=struct.replace("package-value", "controllers".toLowerCase());
        setStructure(struct);
    }

    public File generate(String nameController, Constantes constantes, Langage langage) throws IOException{
        return FileUtils.createFile(".", StringUtils.majStart(nameController)+"Controller"+constantes.getConfigs().get(langage.getNom()+"-ext"), getStructure());
    }
}

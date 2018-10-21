package com.azhen.org.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator {

    public static void main(String[] args) {

        try {
            new CodeGenerator().gen();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void gen() throws IOException, TemplateException{

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/Azhen/Documents/GitHub/JavaUtilsLearnDemo/src/main/java/com/azhen/org/freemarker"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("person.ftl");  // load E:/Work/Freemarker/templates/person.ftl

        // Create the root hash
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("packageName", "com.azhen.org.freemarker");
        String className = "Person";
        root.put("className", className);
        root.put("author", "Azhen");

        List<Attribute> attr_list = new ArrayList<>();
        attr_list.add(new Attribute("id", "Long"));
        attr_list.add(new Attribute("name", "String"));
        attr_list.add(new Attribute("age", "Integer"));
        attr_list.add(new Attribute("hobby", "List<String>"));

        root.put("attrs", attr_list);

//      Writer out = new OutputStreamWriter(System.out);
//      Writer out = new OutputStreamWriter(System.out);
        File dir = new File("C:/Users/Azhen/Documents/GitHub/JavaUtilsLearnDemo/src/main/java/com/azhen/org/freemarker");
        if(!dir.exists()){
            dir.mkdirs();
        }
        OutputStream fos = new  FileOutputStream( new File(dir, className + ".java")); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);

        fos.flush();
        fos.close();

        System.out.println("gen code success!");
    }

    private static class Attribute extends HashMap{
        public Attribute(String name, String type) {
            put("name", name);
            put("type", type);
        }
    }
}
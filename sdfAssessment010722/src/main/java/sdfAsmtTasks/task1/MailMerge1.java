package sdfAsmtTasks.task1;

import java.util.List;

import org.w3c.dom.Document;

public class MailMerge1 {
    
    public static void main(String[] args) throws Exception{
        Document document = new Document(); 
        document.loadFromFile("thankyou.txt");
        String[] textFieldNames = new String[]{"first_name", "address", "years"};
        String[] textFieldValues = new String[]{"Sherlock ", "221b Baker St\nLondon", "22"};
        document.getMailMerge().execute(textFieldNames,textFieldValues);
        ("TextInput", TextFormFieldType.REGULAR, "", " ", 0);
        ("MERGEFIELD address \\* MERGEFORMAT");
        ("TextInput", TextFormFieldType.REGULAR, "", "Dear , ", 0);
        ("MERGEFIELD first_name \\* MERGEFORMAT");
        ("TextInput", TextFormFieldType.REGULAR, "", "Thanks for staying with us over these ", 0);
        ("MERGEFIELD years \\* MERGEFORMAT");

    }

}

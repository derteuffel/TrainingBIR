package com.derteuffel;


import com.derteuffel.controller.FileStorageProperties;
import com.derteuffel.repository.UserRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class GestionFormationBirApplication implements CommandLineRunner {

	private static final String FILE_NAME = "./src/main/resources/static/document/2e Grpmt LISTE GENERALE.docx";
	public static void main(String[] args) throws IOException, InvalidFormatException {

		SpringApplication.run(GestionFormationBirApplication.class, args);



	}
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... strings) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(FILE_NAME);
			XWPFDocument xdoc = new XWPFDocument(fis);
			ArrayList<String> noms= new ArrayList<>();
			for (XWPFTable table : xdoc.getTables()) {
				System.out.println(table.getRows().size());

				/** ADD ALL USERNAME START
				//in case you want to do more with the table cells...
				for (int i=1; i<table.getRows().size();i++){
					List<XWPFTableRow> row = table.getRows();
					XWPFTableCell cell= row.get(i).getCell(1);
					if (cell != null){
						System.out.println(cell.getText());
						noms.add(cell.getText());
						//System.out.println(noms);
					}
				}
				 ADD ALL USERNAME END **/

			/** ADD ALL USERBIRTHDATE START **/

				//in case you want to do more with the table cells...
				for (int i=1; i<table.getRows().size();i++){
					List<XWPFTableRow> row = table.getRows();
					XWPFTableCell cell= row.get(i).getCell(2);
					if (cell != null){
						System.out.println(cell.getText());
						noms.add(cell.getText());
						//System.out.println(noms);
					}
				}

				/** ADD ALL USERBIRTHDATE END **/
			}

			/*System.out.println(noms);
			List<User> users= userRepository.findAll();
			for (int i=0;i<users.size();i++){
				User user=users.get(i);
				user.setStatus(true);
				userRepository.save(user);
			}*/
			fis.close();
			xdoc.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}
}


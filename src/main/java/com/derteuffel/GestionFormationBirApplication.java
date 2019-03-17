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
public class GestionFormationBirApplication  {

	private static final String FILE_NAME = "./src/main/resources/static/document/2e Grpmt LISTE GENERALE.docx";
	public static void main(String[] args) throws IOException, InvalidFormatException {

		SpringApplication.run(GestionFormationBirApplication.class, args);



	}
}


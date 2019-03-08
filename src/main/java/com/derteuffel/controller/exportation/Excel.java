package com.derteuffel.controller.exportation;

import com.derteuffel.controller.FileUploadService;
import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import com.derteuffel.data.User;
import com.derteuffel.repository.CourseRepository;
import com.derteuffel.repository.UserRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neword on 07/03/2019.
 */
@Controller
@RequestMapping("/export")
public class Excel {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    // a function which performs creation
    public String create(HSSFWorkbook workbook, List<String> headers, List<List<String>> datas) throws FileNotFoundException, DocumentException, IOException
    {
        FileOutputStream fileOutputStream=null;
        String filename=null;
        try
        {
            // Obtain a workbook from the excel file
            HSSFSheet sheet=workbook.createSheet("Sheet1");


            // create style for header cells
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            style.setFont(font);
            // create header row

            HSSFRow header = sheet.createRow(0);
            for(int i=0;i< headers.size();i++)
            {
                header.createCell(i).setCellValue(headers.get(i));
                header.getCell(i).setCellStyle(style);
            }
            header.setHeight((short)-1);

            // create data rows
            int rowCount = 1;

            for (List<String> data : datas) {
                HSSFRow aRow = sheet.createRow(rowCount++);
                aRow.setHeight((short)450);
                for(int i=0;i< headers.size();i++)
                {
                    aRow.createCell(i).setCellValue(data.get(i));
                }
            }
            for (short i = sheet.getRow(0).getFirstCellNum(),
                 end = sheet.getRow(0).getLastCellNum() ; i < end ; i++) {
                sheet.autoSizeColumn(i);
            }
            filename = "Utilisateurs, Matières et Moyennes" + ".xls";
            fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public double average2(List<Note> notes)
    {
        if(notes.size()==0) return 0;
        double average=0.0;
        for(int i=0;i<notes.size();i++)
        {
            average+=notes.get(i).getNoteVal();
        }
        return average/6;
    }
    public double moyenne(List<Double> notes)
    {
        double average=0;
        for(int i=0;i< notes.size();i++)
        {
            average+= notes.get(i);
        }
        return average/notes.size();
    }
    DecimalFormat formatter= new DecimalFormat("#0.00");
    // for the creation of excel docs, don't mind the name
    @GetMapping(value = "/excel/courses_average",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource createPdf(HSSFWorkbook workbook, HttpServletResponse response) throws DocumentException, IOException  {
        response.setContentType("application/xls");
        response.setHeader("Content-Disposition", "attachment; filename="+ "Utilisateurs Matieres et Moyennes" + ".xls");
        List<String> headers = new ArrayList<String>();
        headers.add("RECRUES/SLDTS");
        List<Course> courses = courseRepository.findAll1();
        for(int i=0;i<courses.size();i++)
        {
            headers.add(courses.get(i).getCourseName());

        }
        headers.add("MOYENNE");

        List<List<String>> datas = new ArrayList<>() ;
        List<String> tmp = new ArrayList<>();
        List<User> users = userRepository.findAll();
        User user;
        List<Double> averages = new ArrayList<>();
        for(int i=0;i< users.size();i++)
        {
             user = users.get(i);
            tmp.add( user.getUserName());
            for(int j=0;j<courses.size();j++)
            {
                List<Note> notes = courseRepository.findNotesByCourseIdByUserId(courses.get(j).getCourseId(),users.get(i).getUserId());
                double average = average2(notes);
                tmp.add(String.valueOf(average));
                averages.add(average);
            }

            tmp.add(formatter.format(moyenne(averages)));
        }
            datas.add(tmp);
            tmp= new ArrayList<>();

        return new FileSystemResource(create( workbook,headers,datas));
    }

}

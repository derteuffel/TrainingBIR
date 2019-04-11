package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import com.derteuffel.data.User;
import com.derteuffel.repository.CourseRepository;
import com.derteuffel.repository.UserRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by neword on 28/02/2019.
 */

@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;
    /** helper average **/
    public double average(List<Note> notes, long divider)
    {
        if(notes.size()==0) return 0;
       double average=0.0;
        for(int i=0;i<notes.size();i++)
        {
                average+=notes.get(i).getNoteVal();
        }
        return average/divider;
    }
    /** helper average **/
    class Diplome
    {
        String title;
        List<User> users;

        public Diplome(String title, List<User> users) {
            this.title = title;
            this.users = users;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }
    public List<Diplome> getUsersByDiploms()
    {
        List<Diplome> diplomes = new ArrayList<>();
        List<User> users = userRepository.findAll();
        List<String> dip = new ArrayList<>();
        String tmp;
        for(User user:users)
        {
            if(user.getUserHigerCivilDiplom()!=null) {

                tmp = user.getUserHigerCivilDiplom().replaceAll("\\s+", "");
                dip.add(tmp);

            }

        }

        List<String> dipUnique = CompagnieController.removeDuplicates(dip);

        Collections.sort(dipUnique);
        for(String diplome : dipUnique)
        {
            diplomes.add(new Diplome(diplome,userRepository.findAllByUserHigerCivilDiplom(diplome)));
        }
        return diplomes;
    }
    @GetMapping("/diplomes")
    public String diplomeInsight(Model model)
    {
        model.addAttribute("diplomes",getUsersByDiploms());
        return "stats/diplomeStats";
    }
    // a function which performs creation
    public String create(HSSFWorkbook workbook, List<String> headers, List<Diplome> diplomes, String m_filename) throws FileNotFoundException, DocumentException, IOException
    {
        FileOutputStream fileOutputStream=null;
        String filename=m_filename;
        try
        {
            // Obtain a workbook from the excel file
            HSSFSheet sheet=workbook.createSheet("Sheet1");
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            style.setAlignment(HorizontalAlignment.CENTER);
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
            int j=3;
            for (Diplome diplome: diplomes) {
                sheet.createRow(j);
                sheet.addMergedRegion(new CellRangeAddress( j,j,0,headers.size()));
                Cell cell = sheet.getRow(j).createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue( "Diplôme: " + diplome.getTitle().toUpperCase() + "  Effectif total : " + diplome.getUsers().size() );

                for(User user : diplome.getUsers())
                {
                    j++;
                    HSSFRow aRow = sheet.createRow(j);
                    aRow.setHeight((short) 450);
                        aRow.createCell(0).setCellValue(user.getUserName());
                        aRow.createCell(1).setCellValue(user.getUserTrainingLevelInstruction().toUpperCase());
                        if(user.getSection()!=null)
                        aRow.createCell(2).setCellValue(user.getSection().getSectionName());
                    else

                            aRow.createCell(2).setCellValue("     ");

                    if(user.getSection()!=null && user.getSection().getCompagnie()!=null)
                        aRow.createCell(3).setCellValue(user.getSection().getCompagnie().getCompagnieName());
                    else
                        aRow.createCell(3).setCellValue("    ");
                    aRow.createCell(4).setCellValue(user.getUserRegion());
                }
                j+=2;
            }
            for (short i = sheet.getRow(0).getFirstCellNum(),
                 end = sheet.getRow(0).getLastCellNum() ; i < end ; i++) {
                sheet.autoSizeColumn(i);
            }
            fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    @GetMapping(value = "/diplomes/export/excel/{diplome}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource diplomeExport( @PathVariable String diplome ,HSSFWorkbook workbook, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/xls");
        response.setHeader("Content-Disposition", "attachment; filename="+ "Recrues par diplômes " + diplome + ".xls");
        List<String> headers = new ArrayList<String>();
        headers.add("RECRUES/SLDTS");
        headers.add("NIVEAU D'ETUDE");
        headers.add("COMPAGNIE");
        headers.add("SECTION");
        headers.add("REGION");
        List<Diplome> diplomes = new ArrayList<>();
               diplomes.add(new Diplome(diplome,userRepository.findAllByUserHigerCivilDiplom(diplome)));
        return new FileSystemResource(create(workbook,headers,diplomes,"Recrues par diplômes "+ diplome + ".xls"));
    }

        @GetMapping(value = "/diplomes/export/excel",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource diplomesExport( HSSFWorkbook workbook, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/xls");
        response.setHeader("Content-Disposition", "attachment; filename="+ "Recrues par diplômes.xls");
        List<String> headers = new ArrayList<String>();
        headers.add("RECRUES/SLDTS");
            headers.add("NIVEAU D'ETUDE");
        headers.add("COMPAGNIE");
        headers.add("SECTION");
        headers.add("REGION");
        List<Diplome> diplomes = getUsersByDiploms();
        return new FileSystemResource(create(workbook,headers,diplomes,"Recrues par diplômes.xls"));
    }

    @GetMapping("/all")
    public String users(Model model){

        List<Double> averages = new ArrayList<>();
        List<Course> course = courseRepository.findAll1();
        long divider = userRepository.findAll().size();
        for(int i=0;i<course.size();i++)
        {
            averages.add(average(courseRepository.findNotesByCourseId(course.get(i).getCourseId()),divider));
        }


        model.addAttribute("averages",averages);
        model.addAttribute("courses", courseRepository.findAll1());
        return "stats/stats";
    }
}

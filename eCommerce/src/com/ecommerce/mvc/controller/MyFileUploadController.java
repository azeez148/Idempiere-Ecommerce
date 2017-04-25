package com.ecommerce.mvc.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.ecommerce.mvc.model.MyUploadForm;
 
@Controller
@RequestMapping("/homea")
public class MyFileUploadController {
 
   
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == MyUploadForm.class) {
 
            // Register to handle the conversion between the multipart object
            // and byte array.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
 
    // GET: Show upload form page.
    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model) {
 
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
 
        // Forward to "/WEB-INF/pages/uploadOneFile.jsp".
        return "uploadOneFile";
    }
 
    // POST: Do Upload
    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
 
        return this.doUpload(request, model, myUploadForm);
 
    }
 
    // GET: Show upload form page.
    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
    public String uploadMultiFileHandler(Model model) {
 
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
 
        // Forward to "/WEB-INF/pages/uploadMultiFile.jsp".
        return "uploadMultiFile";
    }
 
    // POST: Do Upload
    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
 
        return this.doUpload(request, model, myUploadForm);
 
    }
 
    private String doUpload(HttpServletRequest request, Model model, //
            MyUploadForm myUploadForm) {
 
        String description = myUploadForm.getDescription();
        System.out.println("Description: " + description);
 
     
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
 
        File uploadRootDir = new File(uploadRootPath);
        //
        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = myUploadForm.getFileDatas();
        //
        List<File> uploadedFiles = new ArrayList<File>();
        for (CommonsMultipartFile fileData : fileDatas) {
 
      
            // Client File Name
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
 
            if (name != null && name.length() > 0) {
                try {
                    // Create the file on server
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
  
                    // Stream to write data to file in server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    //
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";
    }
 
}
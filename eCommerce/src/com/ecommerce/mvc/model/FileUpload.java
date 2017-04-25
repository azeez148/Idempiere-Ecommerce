package com.ecommerce.mvc.model;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload{

	MultipartFile file;
	//getter and setter methods

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
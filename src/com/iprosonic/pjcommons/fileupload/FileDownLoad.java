package com.iprosonic.pjcommons.fileupload;

import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileDownLoad")
public class FileDownLoad {

	private StreamedContent	file;

	public FileDownLoad() {
		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("download/spring_dispatcherservlet.png");
		file = new DefaultStreamedContent(stream, "image/png", "download/spring_dispatcherservlet.png");
	}
	public StreamedContent getFile() {
		return file;
	}

}
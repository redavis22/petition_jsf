package com.iprosonic.pjcommons.fileupload;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.PetitionaAttachment;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "fileUploadView")
public class FileUploadView {

	private List<PetitionaAttachment>	fileList;
	private StreamedContent				file;

	public FileUploadView() {
		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
		file = new DefaultStreamedContent(stream, "image/gif", "E:/test/download/MVC-Applied-Servlet.gif");
	}

	public StreamedContent getFile() {
		return file;
	}

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
		PetionService petionService = new PetionService();
		fileList = petionService.getPetitionaAttachmentList(id);

		setFileList(fileList);
	}

	public void fileListView() {

	}

	public List<PetitionaAttachment> getFileList() {
		return fileList;
	}

	public void setFileList(List<PetitionaAttachment> fileList) {
		this.fileList = fileList;
	}

}

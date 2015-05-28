package com.iprosonic.pjcommons.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;

import com.iprosonic.petiton.service.PetionService;
import com.iprosonic.pjcommons.domains.PetitionaAttachment;

@ManagedBean(name = "fileUploadComponent")
public class FileUploadComponent {

	// Primitives
	private static final int	BUFFER_SIZE	= 6124;
	private String				folderToUpload;

	/**
	 * Creates a new instance of UploadBean
	 * 
	 * @return
	 */
	public void uploadFilesBean() {
	}

	public void handleFileUpload(FileUploadEvent event) {

		ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
		File result = new File(extContext.getRealPath("//download//" + event.getFile().getFileName()));

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(result);
			byte[] buffer = new byte[BUFFER_SIZE];

			int bulk;
			InputStream inputStream = event.getFile().getInputstream();
			while (true) {
				bulk = inputStream.read(buffer);
				if (bulk < 0) {
					break;
				}
				fileOutputStream.write(buffer, 0, bulk);
				fileOutputStream.flush();
			}

			fileOutputStream.close();
			inputStream.close();
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			PetionService petionService = new PetionService();
			PetitionaAttachment petitionaAttachment = new PetitionaAttachment();
			petitionaAttachment.setPetitionId(Integer.parseInt(request.getSession().getAttribute("id").toString()));
			petitionaAttachment.setFilePath("download/" + event.getFile().getFileName());
			petitionaAttachment.setFileName(event.getFile().getFileName());
			petionService.saveFileAttachment(petitionaAttachment);

			FacesMessage msg = new FacesMessage("File Description", "file name: " + event.getFile().getFileName() + "file size: " + event.getFile().getSize() / 1024
					+ " Kb content type: " + event.getFile().getContentType() + "The file was uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The files were not uploaded!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
	}

	public String getFolderToUpload() {
		return folderToUpload;
	}

	public void setFolderToUpload(String folderToUpload) {
		this.folderToUpload = folderToUpload;
	}
}

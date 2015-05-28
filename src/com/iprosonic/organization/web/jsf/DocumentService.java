package com.iprosonic.organization.web.jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "documentService")
@ApplicationScoped
public class DocumentService {

	public TreeNode createDocuments() {
		TreeNode root = new DefaultTreeNode(new Document("Files", "-", "Folder"), null);

		TreeNode sp_jalore = new DefaultTreeNode(new Document("SP District Jalore", "-", "SP District Jalore"), root);
		sp_jalore.setExpanded(true);

		// ASP
		TreeNode asp_jlr = new DefaultTreeNode(new Document("ASP_Jalore", "-", "ASP_Jalore"), sp_jalore);
		TreeNode asp_bml = new DefaultTreeNode(new Document("ASP_Bml", "-", "ASP_Bhinmal"), sp_jalore);
		asp_jlr.setExpanded(true);
		asp_bml.setExpanded(true);

		// CO
		TreeNode co_jlr = new DefaultTreeNode("document", new Document("CO_Jalore", "6", "Circle Officer"), asp_jlr);
		TreeNode co_bml = new DefaultTreeNode("document", new Document("CO_Binmal", "4", "Circle Officer"), asp_bml);
		co_jlr.setExpanded(true);
		co_bml.setExpanded(true);

		// SHO_CO_JLR
		TreeNode sho_jlr = new DefaultTreeNode("document", new Document("SHO_Jalore", "1", "SHO"), co_jlr);
		TreeNode sho_ahore = new DefaultTreeNode("document", new Document("SHO_Ahore", "1", "SHO"), co_jlr);
		TreeNode sho_nosra = new DefaultTreeNode("document", new Document("SHO_Nosra", "1", "SHO"), co_jlr);
		TreeNode sho_sayla = new DefaultTreeNode("document", new Document("SHO_Sayala", "1", "SHO"), co_jlr);
		TreeNode sho_bagra = new DefaultTreeNode("document", new Document("SHO_Bagra", "1", "SHO"), co_jlr);
		TreeNode sho_mahila = new DefaultTreeNode("document", new Document("SHO_Mahila", "1", "SHO"), co_jlr);

		// SHO_CO_BML
		TreeNode sho_bml = new DefaultTreeNode("document", new Document("SHO_Binmal", "1", "SHO"), co_bml);
		TreeNode sho_ramseen = new DefaultTreeNode("document", new Document("SHO_ramseen", "1", "SHO"), co_bml);
		TreeNode sho_bagora = new DefaultTreeNode("document", new Document("SHO_Bagora", "1", "SHO"), co_bml);

		return root;

	}

	public TreeNode createCheckboxDocuments() {
		TreeNode root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);

		TreeNode documents = new CheckboxTreeNode(new Document("Documents", "-", "Folder"), root);
		TreeNode pictures = new CheckboxTreeNode(new Document("Pictures", "-", "Folder"), root);
		TreeNode movies = new CheckboxTreeNode(new Document("Movies", "-", "Folder"), root);

		TreeNode work = new CheckboxTreeNode(new Document("Work", "-", "Folder"), documents);
		TreeNode primefaces = new CheckboxTreeNode(new Document("PrimeFaces", "-", "Folder"), documents);

		// Documents
		TreeNode expenses = new CheckboxTreeNode("document", new Document("Expenses.doc", "30 KB", "Word Document"), work);
		TreeNode resume = new CheckboxTreeNode("document", new Document("Resume.doc", "10 KB", "Word Document"), work);
		TreeNode refdoc = new CheckboxTreeNode("document", new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);

		// Pictures
		TreeNode barca = new CheckboxTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
		TreeNode primelogo = new CheckboxTreeNode("picture", new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
		TreeNode optimus = new CheckboxTreeNode("picture", new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);

		// Movies
		TreeNode pacino = new CheckboxTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
		TreeNode deniro = new CheckboxTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);

		TreeNode scarface = new CheckboxTreeNode("mp3", new Document("Scarface", "15 GB", "Movie File"), pacino);
		TreeNode carlitosWay = new CheckboxTreeNode("mp3", new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);

		TreeNode goodfellas = new CheckboxTreeNode("mp3", new Document("Goodfellas", "23 GB", "Movie File"), deniro);
		TreeNode untouchables = new CheckboxTreeNode("mp3", new Document("Untouchables", "17 GB", "Movie File"), deniro);

		return root;
	}
}
/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package com.bitranger.parknshop.common.fulltext;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitranger.parknshop.seller.dao.IPsShopDAO;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * @author GaoJin
 * 
 */
public class BuildIndexForShop {

	// use the IPsItemDAO to get the information.
	@Autowired
	private IPsShopDAO shopDao;

	public IPsShopDAO getShopDao() {
		return shopDao;
	}

	public void setItemDao(IPsShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	// the index will be stored in the given way
	private static File indexFile = new File("D:\\luceneIndex");

	public static File getIndexFile() {
		return indexFile;
	}

	public static void setIndexFile(File indexFile) {
		BuildIndexForShop.indexFile = indexFile;
	}

	// define a analyzer
	private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// get the shoplist
	private static List<PsShop> shoplist;

	// create the index
	@SuppressWarnings("deprecation")
	public void createIndex() throws IOException {
		// store in the directory
		Directory directory = new SimpleFSDirectory(indexFile);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_45, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);// ׼��д��
		shoplist = shopDao.findAll();
		if (shoplist.size() > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < shoplist.size(); i++) {
				Document document = new Document();
				document.add(new Field("id", String.valueOf(shoplist.get(i).getName()),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("psSeller", String.valueOf(shoplist.get(i)
						.getPsSeller()), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("name", shoplist.get(i)
						.getName(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("status", String.valueOf(shoplist.get(i)
						.getStatus()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("introduction", shoplist.get(i)
						.getIntroduction(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("timeCreated", String.valueOf(shoplist.get(i)
						.getTimeCreated()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("vote", String.valueOf(shoplist
						.get(i).getVote()), Field.Store.YES,
						Field.Index.ANALYZED));

				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("������" + writer.numDocs() + "����");
			System.out.println("һ������" + (time2 - time1) + "ʱ��");
		}
		writer.close();
	}

}

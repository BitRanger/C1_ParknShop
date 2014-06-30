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

import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;

/**
 * @author GaoJin
 * 
 */
public class BuildIndexForItem {

	// use the IPsItemDAO to get the information.
	private IPsItemDAO itemDao;

	public IPsItemDAO getItemDao() {
		return itemDao;
	}

	public void setItemDao(IPsItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	// the index will be stored in the given way
	private static File indexFile = new File("D:\\luceneIndex");

	public static File getIndexFile() {
		return indexFile;
	}

	public static void setIndexFile(File indexFile) {
		BuildIndexForItem.indexFile = indexFile;
	}

	// define a analyzer
	private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// get the itemlist
	private static List<PsItem> itemlist;

	// create the index
	@SuppressWarnings("deprecation")
	public void createIndex() throws IOException {
		// store in the directory
		Directory directory = new SimpleFSDirectory(indexFile);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_45, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);// ׼��д��
		itemlist = itemDao.findAll();
		if (itemlist.size() > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < itemlist.size(); i++) {
				Document document = new Document();
				document.add(new Field("name", itemlist.get(i).getName(),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("introduction", itemlist.get(i).getIntroduction(),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("price",String.valueOf(itemlist.get(i).getPrice()),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("urlPicture", itemlist.get(i).getUrlPicture(),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("extra1", String.valueOf(itemlist.get(i)
						.getExtra1()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("extra2", String.valueOf(itemlist.get(i)
						.getExtra2()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("countPurchase", String.valueOf(itemlist.get(i)
						.getCountPurchase()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("countFavourite", String.valueOf(itemlist.get(i)
						.getCountFavourite()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("countClick", String.valueOf(itemlist.get(i)
						.getCountClick()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("vote", String.valueOf(itemlist.get(i)
						.getVote()), Field.Store.YES, Field.Index.ANALYZED));

				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("������" + writer.numDocs() + "����");
			System.out.println("һ������" + (time2 - time1) + "ʱ��");
		}
		writer.close();
	}

}

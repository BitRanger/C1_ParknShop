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

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * @author GaoJin
 * 
 */
public class BuildIndexForSeller {

	// use the IPsItemDAO to get the information.
	private IPsSellerDAO sellerDao;

	public IPsSellerDAO getSellerDao() {
		return sellerDao;
	}

	public void setItemDao(IPsSellerDAO sellerDao) {
		this.sellerDao = sellerDao;
	}

	// the index will be stored in the given way
	private static File indexFile = new File("D:\\luceneIndex");

	public static File getIndexFile() {
		return indexFile;
	}

	public static void setIndexFile(File indexFile) {
		BuildIndexForSeller.indexFile = indexFile;
	}

	// define a analyzer
	private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// get the sellerlist
	private static List<PsSeller> sellerlist;

	// create the index
	@SuppressWarnings("deprecation")
	public void createIndex() throws IOException {
		// store in the directory
		Directory directory = new SimpleFSDirectory(indexFile);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_45, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);// ׼��д��
		FetchOption option = new FetchOption();
		sellerlist = sellerDao.findAll(new FetchOption().limit(100));
		if (sellerlist.size() > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < sellerlist.size(); i++) {
				Document document = new Document();
				document.add(new Field("id", String.valueOf(sellerlist.get(i).getId()),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("nickname", sellerlist.get(i)
						.getNickname(), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("personIdNum", String.valueOf(sellerlist.get(i)
						.getPersonIdNum()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("email", sellerlist.get(i)
						.getEmail(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("password", sellerlist.get(i)
						.getPassword(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("status", String.valueOf(sellerlist.get(i)
						.getStatus()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("timeCreated", String.valueOf(sellerlist
						.get(i).getTimeCreated()), Field.Store.YES,
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

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
import java.util.Date;
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

import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * @author masterpiece
 * 
 */
public class BuildIndexForOrder {

	// use the IPsItemDAO to get the information.
	private IPsOrderDAO orderDao;

	public IPsOrderDAO getOrderDao() {
		return orderDao;
	}

	public void setItemDao(IPsOrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	// the index will be stored in the given way
	private static File indexFile = new File("D:\\luceneIndex");

	public static File getIndexFile() {
		return indexFile;
	}

	public static void setIndexFile(File indexFile) {
		BuildIndexForOrder.indexFile = indexFile;
	}

	// define a analyzer
	private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// get the orderlist
	private static List<PsOrder> orderlist;

	// create the index
	@SuppressWarnings("deprecation")
	public void createIndex() throws IOException {
		// store in the directory
		Directory directory = new SimpleFSDirectory(indexFile);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_45, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);// ׼��д��
		Date from = new Date(), to = new Date();
		orderlist = orderDao.findAll(from, to);
		if (orderlist.size() > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < orderlist.size(); i++) {
				Document document = new Document();
				document.add(new Field("id", String.valueOf(orderlist.get(i).getId()),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("psCustomer", String.valueOf(orderlist.get(i)
						.getPsCustomer()), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("idShop", String.valueOf(orderlist.get(i)
						.getId()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("status", String.valueOf(orderlist.get(i)
						.getStatus()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("trackingNumber", orderlist.get(i)
						.getTrackingNumber(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("address", orderlist.get(i)
						.getPsRecipient().getAddresss(), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("postalCode", orderlist
						.get(i).getTrackingNumber(), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("nameRecipient", orderlist.get(i).getPsRecipient().getPsCustomer().getName(),
						Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("phoneRecipient", orderlist
						.get(i).getPsRecipient().getPhoneNumber(), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("priceTotal", String.valueOf(orderlist.get(i)
						.getPriceTotal()), Field.Store.YES, Field.Index.ANALYZED));
				document.add(new Field("timeCreated", String.valueOf(orderlist.get(i)
						.getTimeCreated()), Field.Store.YES, Field.Index.ANALYZED));

				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("������" + writer.numDocs() + "����");
			System.out.println("һ������" + (time2 - time1) + "ʱ��");
		}
		writer.close();
	}

}

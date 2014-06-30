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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.bitranger.parknshop.common.model.PsItem;

/**
 * @author GaoJin
 * 
 */
public class SearchItem {

	// you can search the item using the following keywords
	private String[] queryString = { "name", "introduction" };
	// state a analyzer
	private Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// we want to get the attributes, so here we state the indexfield
	static String[] indexField = { "name","introduction","price","urlPrice",
		"extra1","extra2","countPurchase","countFavourite","countClick","vote" };

	// the method search
	public List<PsItem> search(String value) throws IOException {
		// get the index
		IndexReader reader = DirectoryReader.open(FSDirectory.open(BuildIndexForItem
				.getIndexFile()));
		// use this to search
		IndexSearcher indexSearcher = new IndexSearcher(reader);
		// use the queryParser to wrap your request
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_45,
				queryString, analyzer);
		
		List<PsItem> item = new ArrayList<PsItem>();

		Query query = null;
		try {
			query = queryParser.parse("title:" + value + "~");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// we get what we want in the topdocs
		TopDocs topDocs = indexSearcher.search(query, 25);
		System.out.println("һ���鵽:" + topDocs.totalHits + "��¼");
		// ScoreDoc[] scoreDoc = topDocs.scoreDocs;
		for (int i = 0; i < topDocs.scoreDocs.length; i++) {
			Document resultDocument = indexSearcher
					.doc(topDocs.scoreDocs[i].doc);
			PsItem myitem = new PsItem();
			myitem.setName(resultDocument.get((indexField[0])));
			myitem.setIntroduction(resultDocument.get((indexField[1])));
			myitem.setPrice(Double.valueOf(resultDocument.get((indexField[2]))));
			myitem.setUrlPicture(resultDocument.get((indexField[3])));
			myitem.setExtra1(resultDocument.get((indexField[4])));
			myitem.setExtra2(resultDocument.get((indexField[5])));
			myitem.setCountPurchase(Integer.valueOf(resultDocument.get((indexField[6]))));
			myitem.setCountFavourite(Integer.valueOf(resultDocument.get((indexField[7]))));
			myitem.setCountClick(Integer.valueOf(resultDocument.get((indexField[8]))));
			myitem.setVote(Double.valueOf(resultDocument.get((indexField[9]))));
			item.add(myitem);

		}
		return item;
	}
	
}
